package in.umt.service;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.umt.bindings.Login;
import in.umt.bindings.UnlockAccount;
import in.umt.bindings.User;
import in.umt.repo.*;
import in.umt.util.Mail;
import in.umt.util.MailSMTPUtil;
import in.umt.util.PasswordGeneratorUtil;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	
	@Autowired
	private Mail mailsender;
	
	@Autowired
	private LocationRepo locationRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CountryRepo countryRepo;

	@Autowired
	private StateRepo stateRepo;

	// @Override
	public List<String> getCountries() {

		return countryRepo.getCountries();

	}

	@Override
	public List<String> getStates(String country) {

		return countryRepo.getStates(country);
	}

	@Override
	public List<String> getCities(String state) {

		return stateRepo.getCities(state);
	}

	// same implementaion with single table

	@Override
	public List<String> getDistinctCountries() {

		return locationRepo.getDistinctCountries();
	}

	@Override
	public List<String> getStatesBycountry(String country) {

		return locationRepo.getStatesBycountry(country);
	}

	@Override
	public List<String> getCitiesByState(String state) {

		return locationRepo.getCitiesByState(state);
	}

	@Override
	public boolean userExists(String email) {
		return userRepo.existsByEmail(email); 
	}

	@Override
	public String saveUser(User user) throws MessagingException {

		user.setPassword(PasswordGeneratorUtil.generateSecurePassword());
		userRepo.save(user);

		mailsender.sendHtmlEmail(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail());

		return "Please check your email inbox to activate your account by changing one time password provided by IES team!";

	}

	//not yet completed
	@Override
	public String unLockAccount(String  email) {
		
		UnlockAccount account=new UnlockAccount();
		if(account.getTemparoryPassword().equals(userRepo.getPassword(email)))
		{	
			userRepo.updatePassword(email, account.getNewPassword());
			
		}
				
		return null;
	}

	@Override
	public String forgotPasswordEmail(String email) {
		 Optional<User> user = userRepo.findByEmail(email);
		if(user.isPresent())
		{
			user.get().setPassword(PasswordGeneratorUtil.generateSecurePassword());
			userRepo.updatePassword(email, user.get().getPassword());
			mailsender.sendSimpleEmail(user.get().getFirstName(), user.get().getLastName(), user.get().getPassword(), user.get().getEmail());
			return "Please check your email inbox to unlock account..";
		}
		return "emailId is not registered, please enter registered email";
	}

	

}