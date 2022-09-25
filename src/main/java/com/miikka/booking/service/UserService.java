package com.miikka.booking.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.miikka.booking.dto.UserRegisterDto;
import com.miikka.booking.model.User;

public interface UserService extends UserDetailsService {

	User save(UserRegisterDto registerDto);
	
}
