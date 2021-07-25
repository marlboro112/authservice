package service.security.auth.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import service.security.auth.common.SecurityConstants;
import service.security.auth.common.Utils;
import service.security.auth.dto.NewUserRegisterDTO;
import service.security.auth.dto.UserDTO;
import service.security.auth.entity.UserEntity;
import service.security.auth.repository.UserRepository;
import service.security.auth.request.UserRequest;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleService roleService;
	
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	Utils utils;
	
	@Autowired
	private SecurityConstants securityConstants;
	
	@Autowired
	MessageSource messageSource;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		 return new User (userEntity.getEmail(), userEntity.getEncryptedPassword(), userEntity.getAuthorities());
	}

	@Override
	public UserDTO createUser(UserDTO user, Locale locale) {
		
		UserEntity checkStoredUser = userRepository.findByEmail(user.getEmail());
		
		if(checkStoredUser != null) throw new RuntimeException(messageSource.getMessage("exception.user.available",null,locale));

		UserEntity userEntity = new UserEntity();
		Date currentDate = new Date();
		BeanUtils.copyProperties(user, userEntity);

		userEntity.setEncryptedPassword(passwordEncoder.encode(user.getPassword()));
		
		userEntity.setEmailVerificationToken(passwordEncoder.encode(user.getPassword()));
		
		String publicId = utils.generateRandomString(securityConstants.getGenerateUserIdLength());
		userEntity.setPublicId(publicId);
		
		String tokenSecret = utils.generateRandomString(securityConstants.getTokenSecretIdLength());
		userEntity.setTokenSecret(tokenSecret);
		
		userEntity.setCreated(currentDate);
		userEntity.setCreatedBy(publicId);
		
		userEntity.setModified(currentDate);
		userEntity.setModifiedBy(publicId);
		
		userEntity.setDeleted(false);
		userEntity.setDeletedBy(publicId);
		
		userEntity.setEnabled(true);
		
		
		userEntity.setEmailVerificationStatus(true);

		UserEntity storedUserDetails = userRepository.save(userEntity);
		UserDTO returnValue = new UserDTO();
		BeanUtils.copyProperties(storedUserDetails, returnValue);

		return returnValue;
	}

	@Override
	public UserDTO getUser(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		UserDTO returnValue = new UserDTO();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

	@Override
	public UserDTO getUserByPublicId(String publicId) {		
		UserEntity userEntity = userRepository.findByPublicId(publicId);
		if(userEntity == null) throw new UsernameNotFoundException(publicId);
		Gson gson = new Gson();
		String temp = gson.toJson(userEntity);
		UserDTO returnValue = gson.fromJson(temp, UserDTO.class);
		return returnValue;
	}

	@Override
	public Iterable<UserDTO> getUserList() {
		Iterable<UserEntity> userEntitys = userRepository.findAll();
		List<UserDTO> listUsers = new ArrayList<UserDTO>();
		for (UserEntity userEntity : userEntitys) {
			Gson gson = new Gson();
			String temp = gson.toJson(userEntity);
			UserDTO returnValue = gson.fromJson(temp, UserDTO.class);
			listUsers.add(returnValue);
		}
		
		return listUsers;
	}

	@Override
	public UserDTO updateUser(UserRequest user, String publicId) {
		UserDTO returnValue = new UserDTO();
		
		UserEntity userEntity = userRepository.findByPublicId(publicId);
		if(userEntity == null) throw new UsernameNotFoundException(publicId);
		BeanUtils.copyProperties(user, userEntity);
		UserEntity updateUser = userRepository.save(userEntity);
		BeanUtils.copyProperties(updateUser, returnValue);
		
		
		return returnValue;
	}

	@Override
	public void deleteUser(String publicId) {
		UserEntity userEntity = userRepository.findByPublicId(publicId);
		if(userEntity == null) throw new UsernameNotFoundException(publicId);
		userRepository.delete(userEntity);

	}

	@Override
	public void disableUser(String publicId) {
		UserEntity userEntity = userRepository.findByPublicId(publicId);
		if(userEntity == null) throw new UsernameNotFoundException(publicId);
		userEntity.setEnabled(false);
		userRepository.save(userEntity);

	}

	@Override
	public String registerNewUser(NewUserRegisterDTO user, Locale locale) {
		
        UserEntity checkStoredUser = userRepository.findByEmail(user.getEmail());
		if(checkStoredUser != null) throw new RuntimeException(messageSource.getMessage("exception.user.available",null,locale));
		UserEntity userEntity = new UserEntity();
		Date currentDate = new Date();
		String publicId = utils.generateRandomString(securityConstants.getGenerateUserIdLength());
		userEntity.setPublicId(publicId);
		userEntity.setDescription(messageSource.getMessage("self.registered.user",null, locale));
		userEntity.setCreatedBy(publicId);
		userEntity.setCreated(currentDate);
		userEntity.setModifiedBy(publicId);
		userEntity.setModified(currentDate);
		userEntity.setDeleted(false);
		userEntity.setDeletedBy(messageSource.getMessage("not.deleted.yet",null, locale));
		userEntity.setEnabled(false);
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setEmail(user.getEmail());
		userEntity.setEncryptedPassword(passwordEncoder.encode(user.getPassword()));
		userEntity.setTokenSecret(utils.generateRandomString(securityConstants.getTokenSecretIdLength()));
		userEntity.setOrganization(user.getOrganization());
		userEntity.setMobilePhone(user.getMobilePhone());
		userEntity.setEmailVerificationToken(utils.generateRandomString(securityConstants.getGenerateEmailVerificationTokenLength()));		
		userEntity.setEmailVerificationStatus(false);
		userRepository.save(userEntity);

		return messageSource.getMessage("user.registration.successful",null, locale);
	}

}
