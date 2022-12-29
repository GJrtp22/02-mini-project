package in.umt.service;

import java.util.List;

import javax.mail.MessagingException;

import in.umt.bindings.Login;
import in.umt.bindings.UnlockAccount;
import in.umt.bindings.User;

public interface UserManagementService {

	List<String> getCountries();

	List<String> getStates(String country);

	List<String> getCities(String state);

	String userExists(String email);

	String saveUser(User user) throws MessagingException;

	String unLockAccount(UnlockAccount email);

	String forgotPasswordEmail(String email);

	String signIn(Login login);

	//List<String> getDistinctCountries();

	//List<String> getStatesBycountry(String country);

	//List<String> getCitiesByState(String state);

}
