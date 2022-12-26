package in.umt.util;

import javax.mail.MessagingException;

public interface Mail {
	
	public void sendSimpleEmail(String firstName, String lastName, String password, String to);
	
	public void sendHtmlEmail(String firstName, String lastName, String password, String to) throws MessagingException;
	
	public void sendForgetPasswordEmail(String firstName, String lastName, String password, String to);
}
