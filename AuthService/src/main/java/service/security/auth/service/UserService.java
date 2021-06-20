package service.security.auth.service;

import java.util.Locale;

import org.springframework.security.core.userdetails.UserDetailsService;

import service.security.auth.dto.UserDTO;
import service.security.auth.request.UserRequest;


public interface UserService extends UserDetailsService {
	
	UserDTO createUser(UserDTO user,Locale locale);
	UserDTO getUser(String email);
	UserDTO getUserByPublicId(String publicId);
	Iterable<UserDTO> getUserList();
	UserDTO updateUser(UserRequest user,String publicId );
	void deleteUser(String publicId);
	void disableUser(String publicId);

}
