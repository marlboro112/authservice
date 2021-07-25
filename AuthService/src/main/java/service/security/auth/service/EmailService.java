package service.security.auth.service;

import java.util.Locale;

public interface EmailService {
	
	void sendEmailVerification (String to,String url,String verificationToken,Locale locale); 

}
