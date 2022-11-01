package com.example.Poll10.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Poll10.entity.PollOption;
import com.example.Poll10.payload.AgePayload;
import com.example.Poll10.payload.VoteDto;

@Repository
public interface PollOptionRepository extends JpaRepository<PollOption,Integer> {
	//ArrayList<Integer> gfg = new ArrayList<Integer>();
	//@Query("select count(u.user_age) from Users u where useId=:ud")
	//Integer age(@Param("ud") Integer uId);
    //SELECT * FROM poll10.user WHERE use_id!=1;
	
	@Query("select p from PollOption p where poll_id =:pd")
	List<PollOption> resList(@Param("pd") Integer pId);
//	
//	@Query("select p from PollOption p where poll_id!=:pd")
//	List<PollOption> resList1(@Param("pd") Integer pId);
	//@Query("SELECT e FROM postData e INNER JOIN e.user t where t.country!=:c")
	//List<postData> countryWisePost(@Param("c") String country);
	
	@Query("SELECT p.optionId FROM PollOption p WHERE poll_id =:id")
	ArrayList<Integer> search(@Param("id") Integer id);
	
	//@Query("SELECT COUNT(v.optionId) FROM  Vote v inner join v.users  u inner join v.optionId p  " 
	//        +" where p.optionId =:optId and u.user_location=:userLoc")
	//poll_id
	//SELECT poll140.polloption.poll_id FROM poll140.polloption WHERE option_id=1;
	//@Query("SELECT u.poll_id FROM PollOption p inner join p.poll_id u WHERE p.optionId =:optId")
	@Query("SELECT u.pollId FROM PollOption p inner join p.pollOpt u WHERE p.optionId =:optId")
	Integer findPollId(@Param("optId") Integer optId);
}
