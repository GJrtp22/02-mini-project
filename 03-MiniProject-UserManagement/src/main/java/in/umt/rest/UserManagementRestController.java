package in.umt.rest;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.umt.bindings.Country;
import in.umt.bindings.Location;
import in.umt.bindings.Login;
import in.umt.bindings.UnlockAccount;
import in.umt.bindings.User;
import in.umt.repo.CountryRepo;
import in.umt.repo.LocationRepo;
import in.umt.repo.UserRepo;
import in.umt.service.UserManagementService;

@RestController
public class UserManagementRestController {

	@Autowired
	private LocationRepo locationRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CountryRepo countryRepo;

	@Autowired
	private UserManagementService managementService;

	@PostMapping("/signup")
	public String saveUser(@RequestBody User user) throws MessagingException {

		return managementService.saveUser(user);

	}

	@GetMapping("/email/{emailId}")
	public String userExists(@PathVariable String email) {
		return managementService.userExists(email);

	}

	@GetMapping("/forget/{emailId}")
	public String forgotPassword(@PathVariable String emailId) {
		return managementService.forgotPasswordEmail(emailId);
	}

	@PostMapping("/accountunlock")
	public String unlockAccount(@RequestBody UnlockAccount account) {
		return managementService.unLockAccount(account);
	}

	@PostMapping("/signin")
	public String signIn(@RequestBody Login login) {
		return managementService.signIn(login);
	}

	@GetMapping("/countries")
	public List<String> getCountries() {
		return managementService.getCountries();
	}

	@GetMapping("/states/{country}")
	public List<String> getStates(@PathVariable String country) {

		return managementService.getStates(country);

	}

	@GetMapping("/cities/{state}")
	public List<String> getCities(@PathVariable String state) {
		return managementService.getCities(state);

	}

}
