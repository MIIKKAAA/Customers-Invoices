package com.miikka.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miikka.booking.dto.UserRegisterDto;
import com.miikka.booking.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegisterController {

	private UserService userService;

	public UserRegisterController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@ModelAttribute("user")
	public UserRegisterDto userRegisterDto() {
		return new UserRegisterDto();
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegisterDto registerDto) {
		userService.save(registerDto);
		return "redirect:/registration?success";
		
	}
	
	@GetMapping
	public String showRegisterForm() {
		
		return "registration";
	}
	
	
	
}
