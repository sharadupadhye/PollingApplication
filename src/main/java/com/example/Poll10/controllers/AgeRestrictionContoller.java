package com.example.Poll10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Poll10.entity.AgeRestriction;
import com.example.Poll10.payload.AgeRestrictionDTO;
import com.example.Poll10.services.AgeRestrictionService;


@RestController
public class AgeRestrictionContoller {
	@Autowired
	private AgeRestrictionService ageRestrictionService;
	
	@PostMapping(value = "/saveAge")
	private int saveBook(@RequestBody AgeRestriction ageRec)  
	{  
		int xy=ageRec.getMinAge();
		System.out.println("value of id = "+xy);
		ageRestrictionService.saveOrUpdate(ageRec);  
	return  ageRec.getAgeId();  
	}
	
	@PostMapping(value = "/saveAge1")
	private int saveAgeRest(@RequestBody AgeRestrictionDTO ageRe)  
	{  
		ageRestrictionService.saveAge(ageRe);
//		String xy=ageRe.getAgeRest();
//		System.out.println("value of id = "+xy);
		//ageRestrictionService.saveOrUpdate(ageRec);  
		return  ageRe.getAgeId();  
	}
	

	

}
