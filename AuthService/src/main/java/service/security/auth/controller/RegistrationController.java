package service.security.auth.controller;

import java.util.Locale;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.security.auth.dto.NewUserRegisterDTO;
import service.security.auth.request.UserRequest;
import service.security.auth.service.UserService;

@RestController
@RequestMapping("register")
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(path = "/", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public String registerNewUser (@RequestBody UserRequest user,Locale locale )throws Exception {
		
		NewUserRegisterDTO newUserDTO = new NewUserRegisterDTO();
		BeanUtils.copyProperties(user, newUserDTO);
		
		String newUserRegistration = userService.registerNewUser(newUserDTO, locale);
		
		return newUserRegistration;
	}
	

}
