package service.security.auth.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SigningKeyResolverAdapter;
import service.security.auth.common.SecurityConstants;
import service.security.auth.dto.UserDTO;
import service.security.auth.service.UserService;



public class AuthorizationFilter extends BasicAuthenticationFilter {

	public AuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	@Autowired
	SecurityConstants securityConstants;
	
	@Autowired
	UserService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		String header = req.getHeader(securityConstants.getHeaderString());

		if (header == null || !header.startsWith(securityConstants.getTokenPrefix())) {
			chain.doFilter(req, res);
			return;
		}

		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
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

			String publicId = Jwts.parser().setSigningKeyResolver(signingKeyResolver)
					.parseClaimsJws(token)
					.getBody()
					.getSubject();

			if (publicId != null) {

				UserDTO userDTO = userService.getUserByPublicId(publicId);
				UserDetails userDetails = userService.loadUserByUsername(userDTO.getEmail());

				return new UsernamePasswordAuthenticationToken(publicId, null, userDetails.getAuthorities());
			}

			return null;
		}

		return null;
	}

}
