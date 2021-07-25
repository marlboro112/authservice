package service.security.auth.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	MessageSource messageSource;

	@Override
	public void sendEmailVerification(String to,String url,String verificationToken,Locale locale) {
		SimpleMailMessage message =  new SimpleMailMessage();
		String messageContent = messageSource.getMessage("spring.mail.emailVerificationTokenText",null, locale) + "\n \n" + url +"/" + verificationToken;
		message.setFrom("noreply@authservice.com");
		message.setTo(to);
		message.setSubject(messageSource.getMessage("spring.mail.emailVerificationTokenSubject",null, locale));
		message.setText(messageContent);
		emailSender.send(message);

	}

}
