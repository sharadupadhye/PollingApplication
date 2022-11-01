package com.example.Poll10.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Poll10.entity.PollName;
import com.example.Poll10.entity.PollOption;
import com.example.Poll10.entity.Vote;
import com.example.Poll10.payload.VoteDto;
import com.example.Poll10.services.VoteService;

@RestController
public class VoteController {
	@Autowired
	private VoteService voteService;
	
	@PostMapping(value = "/saveVot")
	private int saveBook(@RequestBody Vote vot)  
	{  
		voteService.saveOrUpdate(vot);  
	return  vot.getVoteId();  
	}

	@PostMapping("/update/{optId}/{userId}")  
	private String updatecontentbyid(VoteDto votedto,@PathVariable("optId") Integer optId,@PathVariable("userId") Integer userId)
	{
		
		return voteService.search(votedto,optId,userId);  
	}
	
	@GetMapping("/ageResult/{postId}")  
	private ArrayList<ArrayList<Double>> ResultByAge(@PathVariable("postId") Integer postId)  
	{  
		
		//System.out.println(id);
		
		return voteService.SearchByAge1(postId) ;  
	}
	
	@GetMapping("/LocationResult/{postLocId}")  
	private ArrayList<ArrayList<String>> ResultByLocation(@PathVariable("postLocId") Integer postLocId)  
	{  
		//voteService.SearchByLocation();
		
		
		return voteService.SearchByLocation(postLocId);   
	}
	@GetMapping("/LocAgeReach/{postReachId}")  
	private ArrayList<ArrayList<String>> reachcount(@PathVariable("postReachId") Integer postReachId)  
	{  
		
		//voteService.reach(postReachId); 
		
		return voteService.reach(postReachId);  
	}

}
