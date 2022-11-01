package com.example.Poll10.services;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.example.Poll10.entity.DAOUser;
import com.example.Poll10.repositories.UserDao;



@Service
public class UsersService {
	@Autowired
	private UserDao usersRepo;
	
	 public void saveOrUpdate(DAOUser use)
	 {
		// System.out.println("You entered:= " + pollName);
		 usersRepo.save(use);
	 }
	 public DAOUser getbyid(int id) {
		return usersRepo.findById(id).get();
		 
	 }

}
