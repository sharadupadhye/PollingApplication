package com.example.Poll10.services;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Poll10.entity.AgeRestriction;
import com.example.Poll10.entity.PollName;
import com.example.Poll10.entity.PollOption;
import com.example.Poll10.repositories.AgeRestrictionRepository;
import com.example.Poll10.repositories.LocationRestrictionRepository;
import com.example.Poll10.repositories.PollNameRepository;
import com.example.Poll10.repositories.PollOptionRepository;
import com.example.Poll10.repositories.UserDao;




@Service
public class PollOptionService {
@Autowired	
private PollOptionRepository pollOptRepo;

@Autowired
private AgeRestrictionRepository ageRestrictionRepo;

@Autowired
private UserDao usersRepo;

@Autowired
private LocationRestrictionRepository locRepo;

@Autowired
private PollNameRepository pollNameRepo;

   public Iterable<PollOption> listAll() {
      return this.pollOptRepo.findAll();
     }

   public void saveOrUpdate(PollOption pollOption)
    {
	 //System.out.println("You entered:= " + pollName);
	   pollOptRepo.save(pollOption);
     }
   
   public PollOption getbyid(int id) {
		return pollOptRepo.findById(id).get();
		 
	 }
   
//   public Iterable<PollOption> listAllAge(Integer id) {
//	   int b=0;
//	   System.out.println("value of id = "+id);
//		 Integer a=usersRepo.age(id);
//		 System.out.println("value of a = "+a); 
//		 try
//	        {
//			 b=  ageRestrictionRepo.poll(a); 
//	        }
//	        catch(NullPointerException e)
//	        {
//	        	 b= 0;
//	        }
//		 
//		 System.out.println("value of b = "+b);
//		
//	      return this.pollOptRepo.resList(b);
//	 }
   
   public Iterable<PollOption> listAllAge1(Integer id) {
	//   int b=0;
	   ArrayList<PollOption> nonRestrictedPoll = new ArrayList<PollOption>();
	   ArrayList<Integer> ageRestrictedPoll = new ArrayList<Integer>();
	   ArrayList<Integer> locationRestrictedPoll = new ArrayList<Integer>();
	   ArrayList<Integer> finalPoll = new ArrayList<Integer>();
	   System.out.println("hellooo");
//	   System.out.println("value of id = "+id);
		 Integer userAge=usersRepo.age(id);
		 System.out.println("value of userAge = "+userAge); 
		 ageRestrictedPoll=ageRestrictionRepo.poll(userAge);
		 System.out.println("value arraylist userAge = "+ageRestrictedPoll);
		 
		 String userLocation=usersRepo.location(id);
		 System.out.println("value of userAge = "+userLocation); 
		 
		 locationRestrictedPoll =locRepo.Loc(userLocation);
		 System.out.println("value of location list = "+locationRestrictedPoll);
		 finalPoll.addAll(ageRestrictedPoll);
		 finalPoll.addAll(locationRestrictedPoll);
		 System.out.println("finalPoll = "+finalPoll);
		 Set<Integer> removeDuplicate = new LinkedHashSet<Integer>(finalPoll); 
		 ArrayList<Integer> finalPollAllUnique = new ArrayList<Integer>(removeDuplicate);
		 System.out.println("finalPollAllUnique = "+finalPollAllUnique);
		 
		 ArrayList<Integer> existingPoll = new ArrayList<Integer>();
		 existingPoll=pollNameRepo.allPoll();
		 
		 System.out.println("existingPoll= "+existingPoll);
		 
		 existingPoll.removeAll(finalPollAllUnique);
		 
		 System.out.println("non restricted= "+existingPoll);
		 for(int i=0;i<existingPoll.size();i++) {
		 nonRestrictedPoll.addAll(i, pollOptRepo.resList(existingPoll.get(i)));
		 }
		 
		 
//		 try
//	        {
//			 b=  ageRestrictionRepo.poll(a); 
//	        }
//	        catch(NullPointerException e)
//	        {
//	        	 b= 0;
//	        }
//		 
//		 System.out.println("value of b = "+b);
	  // this.pollOptRepo.resList(b);
	      return nonRestrictedPoll ;
	 }
   
}
