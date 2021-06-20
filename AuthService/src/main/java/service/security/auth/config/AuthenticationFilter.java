package service.security.auth.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import service.security.auth.common.SecurityConstants;
import service.security.auth.dto.UserDTO;
import service.security.auth.request.UserLoginRequest;
import service.security.auth.service.UserService;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
    private final AuthenticationManager authenticationManager;
    
    @Autowired
    UserService userService;
    
    @Autowired
    SecurityConstants securityConstants;
    
    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
 
        	
            UserLoginRequest creds = new ObjectMapper()
                    .readValue(req.getInputStream(), UserLoginRequest.class);
            
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        
        String userName = ((User) auth.getPrincipal()).getUsername();  
       UserDTO userDTO =  userService.getUser(userName);
       String userPublicId = userDTO.getPublicId();
       String tokenSecret = userDTO.getTokenSecret();
        String token = Jwts.builder()
                .setSubject(userPublicId)
                .setExpiration(new Date(System.currentTimeMillis() + securityConstants.getExpirationTime()))
                .signWith(SignatureAlgorithm.HS512,  tokenSecret.getBytes() )
                .compact();
        

        res.addHeader("Access-Control-Expose-Headers", "Authorization");
        res.addHeader("Access-Control-Allow-Headers", "Authorization, X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept, X-Custom-header");
        res.addHeader(securityConstants.getHeaderString(), securityConstants.getTokenPrefix() + " " + token);
       


    }  

}
