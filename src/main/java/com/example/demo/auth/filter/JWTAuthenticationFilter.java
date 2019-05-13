package com.example.demo.auth.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager; 
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		
		if (username != null && password != null) {
        	logger.info("Usuario en FORM " + username);
        	logger.info("Password en FORM " + password);
    	}
		
		username = username.trim();
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password); 
		
		return authenticationManager.authenticate(token);
		
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String username = authResult.getName();
		String token = Jwts.builder()
				.setSubject(username)
				.signWith(SignatureAlgorithm.HS512, "ClaveSecreta.123456".getBytes())
				.compact();
		
		response.addHeader("Authorization", "Bearer " + token);
		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("token", token);
		body.put("user", (User)authResult.getPrincipal());
		body.put("mensaje", String.format("Hola %s, has iniciado sesión correctamente", username));
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(200);
		response.setContentType("application/json");

	}
	
	
	
}
