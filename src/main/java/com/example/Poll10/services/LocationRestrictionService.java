package com.example.Poll10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Poll10.entity.LocationRestriction;
import com.example.Poll10.repositories.LocationRestrictionRepository;

@Service
public class LocationRestrictionService {
	@Autowired
	private LocationRestrictionRepository locationRestrictionRepo;
	
	 public void saveOrUpdate(LocationRestriction locRestrictio)
	 {
		// System.out.println("You entered:= " + pollName);
		 locationRestrictionRepo.save(locRestrictio);
	 }
	 

}
