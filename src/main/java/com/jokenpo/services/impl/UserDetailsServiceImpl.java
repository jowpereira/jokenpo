package com.jokenpo.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jokenpo.security.UserSS;
import com.jokenpo.security.enums.Perfil;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Value("${user.email}")
	private String user;
	
	@Value("${user.password}")
	private String password;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private Set<Perfil> perfis = null;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return new UserSS(user, this.bCryptPasswordEncoder.encode(password), perfis);
	}

}
