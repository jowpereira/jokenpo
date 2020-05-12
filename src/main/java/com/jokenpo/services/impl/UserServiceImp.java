package com.jokenpo.services.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jokenpo.security.UserSS;
import com.jokenpo.services.UserService;

@Service
public class UserServiceImp implements UserService{

	@Override
	public UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}

}
