package com.example.Poll10.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Poll10.entity.PollName;
import com.example.Poll10.repositories.PollNameRepository;



@Service
public class PollNameService   {
	@Autowired
	private PollNameRepository pollNameRepo;
	
	
	public Iterable<PollName> listAll() {
        return this.pollNameRepo.findAll();
    }
	
	 public void saveOrUpdate(PollName pollName)
	 {
	 //System.out.println("You entered:= ");
		 pollNameRepo.save(pollName);
	 }
	 
	
	
}



