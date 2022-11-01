package com.example.Poll10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Poll10.entity.DAOUser;
import com.example.Poll10.services.UsersService;
import com.example.Poll10.services.JwtUserDetailsService;
import com.example.Poll10.payload.forgotPwd;

@RestController
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private JwtUserDetailsService service;
	
	@PostMapping(value = "/saveUsers")
	private int saveBook(@RequestBody DAOUser user)  
	{  
		usersService.saveOrUpdate(user);  
	return  user.getUseId();  
	}
	@PutMapping("/forgotPwd")
	public int getForgotPwd(@RequestBody forgotPwd fp) {
		return service.resetPassword(fp);
		
	}
	
//	@GetMapping("/")
//	public String home() {
//		return "index";
//		
//	}
	
	

}
