package com.example.Poll10.services;

import java.util.ArrayList;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Poll10.entity.DAOUser;
import com.example.Poll10.entity.PollOption;
import com.example.Poll10.entity.Vote;
import com.example.Poll10.payload.AgePayload;
import com.example.Poll10.payload.VoteDto;
import com.example.Poll10.repositories.PollOptionRepository;
import com.example.Poll10.repositories.VoteRepository;

@Service
public class VoteService {
	@Autowired
	private PollOptionRepository pollOptRepo;
	@Autowired
	private VoteRepository voteRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
    private UsersService usersService;
	@Autowired
	private PollOptionService pollOptionService;
	 public void saveOrUpdate(Vote vote)
	 {
		
		 voteRepo.save(vote);
	 }
	 public String search(VoteDto votedto,Integer userId,Integer optionId)  
	 {   
	//	int opid= votedto.getOptionId().getOptionId();
		 System.out.println("userId"+userId);
		 System.out.println("optionId"+optionId);
		 //int kk=2;
		 int pollId=pollOptRepo.findPollId(optionId);
		 System.out.println("pollId"+pollId);
		// int xyz=1;
		// int dk=1;
		 int result=voteRepo.voting(userId,pollId);
		 System.out.println("result "+result);
		// int result=0;
		if(result==0) {
			DAOUser user=usersService.getbyid(userId);
			PollOption poll=pollOptionService.getbyid(optionId);
		Vote vote=this.modelMapper.map(votedto,Vote.class);
			//saveOrUpdate( vote);
		vote.setUsers(user);
		vote.setOptionId(poll);
		this.voteRepo.save(vote);
			return "voting success";
		}
		 return "already voted";
			
	 }
//-----------------------------age percentage result------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------
	public ArrayList<ArrayList<Double>> SearchByAge1(Integer a) {
		
		 ArrayList<Integer> gfg1 = new ArrayList<Integer>();
		 ArrayList<Integer> gfg2 = new ArrayList<Integer>();
		 ArrayList<Integer> gfg3 = new ArrayList<Integer>();
		 ArrayList<Double> percetage1 = new ArrayList<>();
		 ArrayList<Double> percetage2 = new ArrayList<Double>();
		 ArrayList<Double> percetage3 = new ArrayList<Double>();
		//  gfg2=pollOptRepo.search();
		 // gfg3=pollOptRepo.search();
		 ArrayList<Integer> optionCount = new ArrayList<Integer>();
		 optionCount=pollOptRepo.search(a);
//--------------------------------------------------------------------------------------
		 for(int i=0;i<optionCount.size();i++) {
			gfg1.add(i, voteRepo.count1(optionCount.get(i)));
		 }
		  double sum = 0.00; 
	    	 for(int i = 0 ; i < gfg1.size() ; i++){
	    	   sum += gfg1.get(i);    
	    	 }
	    	 for(int i = 0 ; i < gfg1.size() ; i++){
	         percetage1.add(i, ((gfg1.get(i))/sum *100));
	    	 }
//---------------------------------------------------------------------------------------
	    	 for(int i=0;i<optionCount.size();i++) {
	 			gfg2.add(i, voteRepo.count2(optionCount.get(i)));
	 		 }
	    	System.out.println("gfg2 "+gfg2);
	    	 double sum1 = 0.00;
	 	    	 for(int i = 0 ; i < gfg2.size() ; i++){
	 	    	   sum1 += gfg2.get(i);    
	 	    	 }
	 	    	 for(int i = 0 ; i < gfg2.size() ; i++){
	 	         percetage2.add(i, ((gfg2.get(i))/sum1 *100));
	 	    	 }	    	 
//---------------------------------------------------------------------------------------
	 	    	for(int i=0;i<optionCount.size();i++) {
	 	 			gfg3.add(i, voteRepo.count3(optionCount.get(i)));
	 	 		 }
	 	     //System.out.println("gfg3 "+gfg3);
	 	    	double sum2 = 0.00;
	 	 	    	 for(int i = 0 ; i < gfg3.size() ; i++){
	 	 	    	   sum2 += gfg3.get(i);    
	 	 	    	 }
	 	 	    	//System.out.println("sum2 "+sum2);
	 	 	    	 for(int i = 0 ; i < gfg3.size() ; i++){
	 	 	         percetage3.add(i, ((gfg3.get(i))/sum2 *100));
	 	 	    	 }	 	    	 
//---------------------------------------------------------------------------------------
		 ArrayList<ArrayList<Double>> result = new  ArrayList<ArrayList<Double>>();
		 result.add(percetage1);
		 result.add(percetage2);
		 result.add(percetage3); 
		
		 return result ;
	}
//-----------------------------------------------------------------------------------------------
//-------------------------location percentage result----------------------------------------------------------------------
	public ArrayList<ArrayList<String>> SearchByLocation(Integer locInput) {
		//int locInput =1;
		//final List<String> nummm = new ArrayList<String>();
		ArrayList<String> pollLocationListAll = new ArrayList<String>();
		
		ArrayList<String> pollLocationList = new ArrayList<String>();
		 ArrayList<Integer> optionCount1 = new ArrayList<Integer>();
		  optionCount1=pollOptRepo.search(locInput);
		 //System.out.println("hello every one "+optionCount1);
		 
		 for(int i=0;i<optionCount1.size();i++) {
	     
		 pollLocationList=voteRepo.LocationList(optionCount1.get(i));
		 pollLocationListAll.addAll(pollLocationList);
		 }
		// System.out.println("hello every one "+pollLocationListAll);
		 Set<String> removeDuplicate = new LinkedHashSet<String>(pollLocationListAll); 
		 ArrayList<String> pollLocationListAllUnique = new ArrayList<String>(removeDuplicate);
		// System.out.println("remove hello every one "+pollLocationListAllUnique);
		   
		 ArrayList<ArrayList<String>> finalLocationCount = new  ArrayList<ArrayList<String>>();
		 finalLocationCount.add(pollLocationListAllUnique);  
   for (int i = 0; i < pollLocationListAllUnique.size(); i++) {
	   ArrayList<Integer> countOption = new ArrayList<Integer>();
	   ArrayList<Double> percetage = new ArrayList<>();
	   for (int j = 0; j < optionCount1.size() ; j++) {
		   countOption.add(voteRepo.locationCount(optionCount1.get(j),pollLocationListAllUnique.get(i)));
		
		   	   }
	   //--------------------------------------------------------------------------------------
	  // System.out.println("percentage list "+ countOption);
	   double sum5 = 0.00;
	   int x1 = 0;int y1 = 0;
  	 for( x1 = 0 ; x1 < countOption.size() ; x1++){
   	   sum5 += countOption.get(x1);    
 	 }
  	 for( y1 = 0 ; y1 < countOption.size() ; y1++){
       percetage.add(y1, ((countOption.get(y1))/sum5 *100));
  	 }	
  	//System.out.println("percentage list "+ percetage);
////---------------------converting integer list to array list------------------------------------------------------------------
  	ArrayList<String> newList = new ArrayList<>(percetage.size());
	for (Double myInt : percetage) { 
	  newList.add(String.valueOf(myInt)); 
	}
	//System.out.println("percentage list with string"+ newList);
////---------------------------------------------------------------------------------------
	   
	   finalLocationCount.add(newList);
    	         	   }
   //finalLocationCount.add(pollLocationListAllUnique);
   System.out.println("final list "+ finalLocationCount);
		 
				 return finalLocationCount;
		 }
	
	
	
//-----------------------------------------------------------------------------------------------
//-------------------------age and location wise count----------------------------------------------------------------------	     
	public ArrayList<ArrayList<String>> reach(Integer input) {
		ArrayList<ArrayList<String>> ageCount = new  ArrayList<ArrayList<String>>();
		ArrayList<Integer> ageSum = new ArrayList<Integer>();
		//System.out.println("hi ");
		//Integer input=1;
		 ArrayList<Integer> gfg11 = new ArrayList<Integer>();
		 ArrayList<Integer> gfg22 = new ArrayList<Integer>();
		 ArrayList<Integer> gfg33 = new ArrayList<Integer>();
		 ArrayList<Integer> optionCount2 = new ArrayList<Integer>();
		 optionCount2=pollOptRepo.search(input);	
		// System.out.println("optionCount2 "+optionCount2);
//-----------------------------------------------------------------
		 for(int i=0;i<optionCount2.size();i++) {
				gfg11.add(i, voteRepo.count1(optionCount2.get(i)));
			 }
		 //System.out.println("gfg11 "+gfg11);
		 int sum11 = 0;
		 for(int i = 0; i < gfg11.size(); i++) {
		     sum11 += gfg11.get(i);}
		 //System.out.println("sum11 "+sum11);
//-----------------------------------------------------------------
		 for(int i=0;i<optionCount2.size();i++) {
				gfg22.add(i, voteRepo.count2(optionCount2.get(i)));
			 }
		 //System.out.println("gfg22 "+gfg22);
		 int sum22 = 0;
		 for(int i = 0; i < gfg22.size(); i++) {
		     sum22 += gfg22.get(i);}
		 //System.out.println("sum22 "+sum22);
//-----------------------------------------------------------------
		 for(int i=0;i<optionCount2.size();i++) {
				gfg33.add(i, voteRepo.count3(optionCount2.get(i)));
			 }
		 //System.out.println("gfg33 "+gfg33);
		 int sum33 = 0;
		 for(int i = 0; i < gfg33.size(); i++) {
		     sum33 += gfg33.get(i);}
		// System.out.println("sum33 "+sum33);
//-----------------------------------------------------------------
		 ageSum.add(sum11);
		 ageSum.add(sum22);
		 ageSum.add(sum33);
		 
		// System.out.println("count-- "+ageCount);
		 ArrayList<String> newList11 = new ArrayList<>(ageSum.size());
			for (Integer myInt : ageSum) { 
			  newList11.add(String.valueOf(myInt)); 
			}
			ageCount.add(newList11);
//-----------------------------------------------------------------
//-----------------------------------------------------------------
		 int aa =input;
			final List<String> nummm = new ArrayList<String>();
			ArrayList<String> pollLocationListAll1 = new ArrayList<String>();
			
			ArrayList<String> pollLocationList1 = new ArrayList<String>();
			 ArrayList<Integer> optionCount11 = new ArrayList<Integer>();
			  optionCount11=pollOptRepo.search(aa);
			 //System.out.println("hello every one "+optionCount1);
			 
			 for(int i=0;i<optionCount11.size();i++) {
		     
			 pollLocationList1=voteRepo.LocationList(optionCount11.get(i));
			 pollLocationListAll1.addAll(pollLocationList1);
			 }
			System.out.println("hello every one "+pollLocationListAll1);
			// System.out.println("hello every one "+pollLocationListAll);
			 Set<String> removeDuplicate1 = new LinkedHashSet<String>(pollLocationListAll1); 
			 ArrayList<String> pollLocationListAllUnique1 = new ArrayList<String>(removeDuplicate1);
			 System.out.println("remove hello every one "+pollLocationListAllUnique1);
			 ArrayList<String> finalLocationCount1 = new  ArrayList<String>();
		     
			   for (int i = 0; i < pollLocationListAllUnique1.size(); i++) {
				   ArrayList<Integer> countOption1 = new ArrayList<Integer>();
				   ArrayList<Double> percetage = new ArrayList<>();
				   for (int j = 0; j < optionCount11.size() ; j++) {
					   countOption1.add(voteRepo.locationCount(optionCount11.get(j),pollLocationListAllUnique1.get(i)));
				   } //-------------
					   int sumALL = 0;
						 for(int i1 = 0; i1 < countOption1.size(); i1++) {
							 sumALL += countOption1.get(i1);}
						 //------------------------
					 String newList1 = String.valueOf(sumALL);
						
					finalLocationCount1.add(newList1);
			   }
				   ArrayList<ArrayList<String>> locCount = new  ArrayList<ArrayList<String>>();
				   
				  // locCount.add(pollLocationListAllUnique1);
				  // locCount.add(finalLocationCount1); 
			   
			   ageCount.add(pollLocationListAllUnique1);
			   ageCount.add(finalLocationCount1);
			   System.out.println("locCount "+ locCount);
		return ageCount;
		}
}
