package service.security.auth.common;

import java.security.SecureRandom;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SigningKeyResolverAdapter;
import service.security.auth.dto.UserDTO;
import service.security.auth.service.UserService;

@Service
public class Utils {
	

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
    	return new BCryptPasswordEncoder();
    }
	
	
	@Autowired
	private SecurityConstants securityConstants;
	
	@Autowired
	UserService userService;
	
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public String generateRandomString(int length) {
		StringBuilder returnValue = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}

		return new String(returnValue);
	}
		
	// Get Used Login Public Id
	public String GetLogedInUser(HttpServletRequest request) {
		String token = request.getHeader(securityConstants.getHeaderString());				
		if (token != null) {

			token = token.replace(securityConstants.getTokenPrefix(), "");

			SigningKeyResolverAdapter signingKeyResolver = new SigningKeyResolverAdapter() {
				@Override
				public byte[] resolveSigningKeyBytes(@SuppressWarnings("rawtypes") JwsHeader header, Claims claims) {
					String getPublicId = claims.getSubject();
					UserDTO userDTO = userService.getUserByPublicId(getPublicId);
					String secretToken = userDTO.getTokenSecret();
					return secretToken.getBytes();
				}
			};

			String publicId = Jwts.parser().setSigningKeyResolver(signingKeyResolver).parseClaimsJws(token)
					.getBody().getSubject();

			return publicId;
		}

		return null;

	}

}
