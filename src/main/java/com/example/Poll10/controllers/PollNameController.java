package com.example.Poll10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Poll10.entity.PollName;

import com.example.Poll10.services.PollNameService;



@RestController 
class PollNameController {
	@Autowired
	private PollNameService pollNameService;
	
	
	
	@GetMapping("/")
	public Iterable<PollName>getPollnames()
	{
	return pollNameService.listAll();    
	}
	
	
	@PostMapping(value = "/savePoll")
	private int saveBook(@RequestBody PollName poll)  
	{  
	pollNameService.saveOrUpdate(poll);  
	return  poll.getPollId();  
	}
	

}
