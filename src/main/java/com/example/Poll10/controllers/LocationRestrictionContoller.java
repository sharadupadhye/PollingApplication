package com.example.Poll10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Poll10.entity.LocationRestriction;
import com.example.Poll10.entity.PollName;
import com.example.Poll10.services.LocationRestrictionService;

@RestController
public class LocationRestrictionContoller {
	@Autowired
	private LocationRestrictionService locationRestrictionService;
	
	@PostMapping(value = "/saveLocation")
	private int saveLocation(@RequestBody LocationRestriction loc)  
	{  
		locationRestrictionService.saveOrUpdate(loc);  
	return  loc.getLocationID();  
	}

}
