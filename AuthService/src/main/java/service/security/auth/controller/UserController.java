package service.security.auth.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.security.auth.dto.UserDTO;
import service.security.auth.repository.UserRepository;
import service.security.auth.request.UserRequest;
import service.security.auth.response.UserResponse;
import service.security.auth.service.UserService;

@RestController
@RequestMapping("users")
@PreAuthorize("denyAll")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	// Get users list	
		@PreAuthorize("hasAuthority('PERM_USER_LIST_GET')")
		@GetMapping(path ="/" , produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
		public Iterable<UserResponse> getUser() {
			Iterable<UserDTO> userDTOS = userService.getUserList();
			List<UserResponse> listUsers = new ArrayList<UserResponse>();
			for (UserDTO userDTO : userDTOS) {
				UserResponse returnValue = new UserResponse();
				BeanUtils.copyProperties(userDTO, returnValue);
				listUsers.add(returnValue);
			}
			
			return listUsers;
		}
	
		//Get user info according PublicId	
		@PreAuthorize("hasAuthority('PERM_USER_BY_PUBLICID_GET')")
		@GetMapping(path ="/{id}" , produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
		public UserResponse getUser(@PathVariable String id) {
			UserResponse returnValue = new UserResponse();
			UserDTO userDto = userService.getUserByPublicId(id);
			BeanUtils.copyProperties(userDto, returnValue);
			return returnValue;
		}
		
		//Create new User
		@PreAuthorize("hasAuthority('PERM_CREATE_USER_POST')")
		@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
				MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
		public UserResponse createUser(@RequestBody UserRequest user,Locale locale )throws Exception {
			
			UserResponse returnValue = new UserResponse();
			UserDTO userDTO = new UserDTO();
			
			BeanUtils.copyProperties(user, userDTO);
			
			UserDTO createUser  = userService.createUser(userDTO, locale);
			
			BeanUtils.copyProperties(createUser, returnValue);
			
			
			return returnValue;
		}
		
		
		//Update User info according PublicId
		@PreAuthorize("hasAuthority('PERM_UPDATE_USER_PUT')")
		@PutMapping(path ="/{id}",
				consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
				produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
				)
		public UserResponse updateUser(@RequestBody UserRequest user,@PathVariable String id ) {
			UserResponse returnValue = new UserResponse();
					
			UserDTO updateUser = userService.updateUser(user, id);
			BeanUtils.copyProperties(updateUser, returnValue);
			
			
			return returnValue;
		}
		
		
		
		// Update User Profile Info
		@PreAuthorize("hasAuthority('PERM_UPDATE_USER_PROFILE_PUT')")
		@PutMapping(path ="/profile/{id}",
				consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
				produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
				)
		public UserResponse updateUserProfile(@RequestBody UserRequest user,@PathVariable String id,HttpServletRequest request ) {
			UserResponse returnValue = new UserResponse();
			String userPublicId = request.getUserPrincipal().getName(); 
			
	       if(userPublicId.equals(id)) {
	    	   UserDTO updateUser = userService.updateUser(user, id);
			BeanUtils.copyProperties(updateUser, returnValue);		
			return returnValue;
	       }else {
	    	   UserDTO loggedUser = userService.getUserByPublicId(userPublicId);
	    	   BeanUtils.copyProperties(loggedUser, returnValue);
	    	   return returnValue;
	       }
	       
		}
		 	
		
		//Delete User account according UserPublicId
		@PreAuthorize("hasAuthority('PERM_DELETE_USER_DELETE')")
		@DeleteMapping(path ="/{id}"
				)
		public String deleteUser(@PathVariable String id) {		
			userService.deleteUser(id);		
			return "Deleted";
		}
		
		//Disable User account according UserPublicId
		@PreAuthorize("hasAuthority('PERM_DISABLE_USER_PUT')")
		@PutMapping(path ="/disable/{id}")
		public String disableUser(@PathVariable String id) {		
			userService.disableUser(id);		
			return "Disabled";
		}

}
