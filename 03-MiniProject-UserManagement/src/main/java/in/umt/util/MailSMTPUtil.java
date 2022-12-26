package in.umt.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSMTPUtil implements Mail {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendSimpleEmail(String firstName, String lastName, String password, String to) {
		String from = "govardhan.jrtp@gmail.com";

		String content = "Hi" + firstName + "," + lastName + " :\n"
				+ "         Welcome to IES family, your registration is almost complete\n"
				+ "         Please set your password by using temporary password below \n"
				+ "		  Temporary Password: " + password + "	\n" + "         Link to unlock account \n" + "Thanks,\n"
				+ "IES Team";

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("Welcome- Unlock IES Account");
		message.setText(content);

		mailSender.send(message);
	}

	@Override
	public void sendHtmlEmail(String firstName, String lastName, String password, String to) throws MessagingException {
		String from = "govardhan.jrtp@gmail.com";

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setSubject("Welcome- Unlock IES Account");
		helper.setFrom(from);
		helper.setTo(to);

		boolean html = true;
		helper.setText("<b>Hi " + firstName + "," + lastName + "</b>,"
				+ "<br><i>Welcome to IES family, your registration is almost completed</i>"
				+ "<br><i>Please set your password by using temporary password below:</i>"
				+ "<br><i>Temporary Password:" + password + "</i>" + "<br><i>Link to set your new password </i>"
				+ "<br><hr>" + "<br><i>Thanks,</i>" + "<br><i>IES Team</i>", html);

		mailSender.send(message);

	}
	
	@Override
	public void sendForgetPasswordEmail(String firstName, String lastName, String password, String to) {
		String from = "govardhan.jrtp@gmail.com";

		String content = "Hi" + firstName + "," + lastName + " :\n"
				+ "        Please unlock your account using below one time password \n"
				+ "         Please set your password by using temporary password below \n"
				+ "		  Temporary Password: " + password + "	\n" + "Thanks,\n"
				+ "IES Team";

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("Welcome- Unlock IES Account");
		message.setText(content);

		mailSender.send(message);
	}

}
