package com.example.Poll10.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Poll10.entity.PollOption;
import com.example.Poll10.entity.Vote;

@Repository
public interface VoteRepository extends JpaRepository <Vote,Integer>{
	
	//@Query("select count(s) from Strategy s where s.name=:name and s.username=:username")

//working query for vote	//@Query("SELECT EXISTS(SELECT v FROM Vote v WHERE polloption=:optId AND users=:userId")
	//@Query("SELECT count(v)FROM Vote v WHERE option_id =:optId AND use_id=:userId")
	
	//Integer voting(@Param("optId") Integer optId ,@Param("userId") Integer userId);
	//inner join p.pollOpt o 
	
	@Query("SELECT COUNT(v.voteId) FROM  Vote v inner join v.users u inner join v.optionId p inner join p.pollOpt o " 
	       +" where o.pollId =:optId and u.useId=:userId")
	Integer voting(@Param("userId") Integer userId,@Param("optId") Integer optId);
	
	////@Query("SELECT EXISTS(SELECT v FROM Vote v where v.use_id =:userId and v.optionId =:optId)")
	////Integer voting(@Param("optId") Integer optId ,@Param("userId") Integer userId);
	
	//SELECT EXISTS(SELECT * FROM Vote v WHERE v.option_id = :optId AND v.use_id = :userId)
	//update Employee e set e.content = :content where e.id = :id
	//boolean existsVoteBypolloption(Integer opt);
	
	//@Query("SELECT COUNT(v.option_id) FROM  v.Users u inner join Vote v  where v.option_id =:1 and u.user_age BETWEEN 4 AND 26")
	//Integer count1();
	//group by u.useId
	//SELECT COUNT(option_id) FROM  poll10.user inner join poll10.vote on user.use_id = vote.use_id 
	//		where option_id = 1 and user.user_age BETWEEN 4 AND 26;
	@Query("SELECT COUNT(v.optionId) FROM  Vote v inner join v.users  u inner join v.optionId p  " 
	        +" where p.optionId =:count and u.user_age BETWEEN 5 AND 21 ")
	Integer count1(@Param("count") Integer count);
	
	@Query("SELECT COUNT(v.optionId) FROM  Vote v inner join v.users  u inner join v.optionId p  " 
	        +" where p.optionId =:count and u.user_age BETWEEN 22 AND 40 ")
	Integer count2(@Param("count") Integer count);
	
	@Query("SELECT COUNT(v.optionId) FROM  Vote v inner join v.users  u inner join v.optionId p  " 
	        +" where p.optionId =:count and u.user_age BETWEEN 41 AND 60 ")
	Integer count3(@Param("count") Integer count);
	
    //SELECT user.user_location  FROM  poll10.user inner join poll10.vote on user.use_id = vote.use_id  WHERE option_id=1;
	@Query("SELECT u.user_location FROM  Vote v inner join v.users  u inner join v.optionId p where p.optionId =:option" )
	ArrayList<String> LocationList(@Param("option") Integer option);
	
	@Query("SELECT COUNT(v.optionId) FROM  Vote v inner join v.users  u inner join v.optionId p  " 
	        +" where p.optionId =:optId and u.user_location=:userLoc")
	Integer locationCount(@Param("optId") Integer optId ,@Param("userLoc") String userLoc);
}
