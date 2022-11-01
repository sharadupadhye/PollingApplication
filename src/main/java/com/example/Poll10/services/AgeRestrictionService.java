package com.example.Poll10.services;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.example.Poll10.entity.AgeRestriction;
import com.example.Poll10.payload.AgeRestrictionDTO;
import com.example.Poll10.repositories.AgeRestrictionRepository;



@Service
public class AgeRestrictionService {
	@Autowired
	private AgeRestrictionRepository ageRestrictionRepo;
	

	
	 public void saveOrUpdate(AgeRestriction ageRestriction)
	 {
		// System.out.println("You entered:= " + pollName);
		 ageRestrictionRepo.save(ageRestriction);
	 }
	 
	 public void saveAge(AgeRestrictionDTO ageRe)
	 {
		    String xy=ageRe.getAgeRest();
			System.out.println("string = "+xy);
			int pollId=ageRe.getPollId().getPollId();
			//System.out.println("getPollId = "+pollId);
			String str=ageRe.getAgeRest();
			String[] arrOfStr = str.split("-", 2); 
			int minAge= Integer.parseInt(arrOfStr[0]);  
			int maxAge= Integer.parseInt(arrOfStr[1]);
			//System.out.println("minAge= "+minAge);
			//System.out.println("maxAge = "+maxAge);
			ageRestrictionRepo.saveAge(pollId,minAge,maxAge);
		// System.out.println("You entered:= " + pollName);
		 //ageRestrictionRepo.save(ageRestriction);
	 }
	 

	

}