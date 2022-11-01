package com.example.Poll10.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Poll10.entity.AgeRestriction;
import com.example.Poll10.entity.PollOption;
import com.example.Poll10.services.PollOptionService;

@RestController 
public class PollOptionController {
	@Autowired
	private PollOptionService pollOptService;
	
	@GetMapping("/opt")
	public Iterable<PollOption>getPollOption()
	{
	return pollOptService.listAll();    
	}
	
	@PostMapping(value = "/saveOption")
	private int saveOption(@RequestBody PollOption opt)  
	{  
		pollOptService.saveOrUpdate(opt);  
	return  opt.getOptionId();  
	}
	
//	@GetMapping("/opt")
//	public Iterable<PollOption>getPoll()
//	{
//	return pollOptService.listAll();    
//	}
//	@GetMapping("/age/{id}")  
//	private Iterable<PollOption> findByAge(@PathVariable("id") Integer ageid)  
//	{  
//		return  pollOptService.listAllAge(ageid); 
//	}
	
	@GetMapping("/age1/{id}") 
	
	private Iterable<PollOption> findByAge1(@PathVariable("id") Integer ageid)  
	{  
		return  pollOptService.listAllAge1(ageid); 
	}
}
