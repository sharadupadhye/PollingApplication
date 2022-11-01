package com.example.Poll10.repositories;

import java.util.ArrayList;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.Poll10.entity.AgeRestriction;

@Repository
public interface AgeRestrictionRepository extends JpaRepository <AgeRestriction,Integer>{
	
	//@Query("select count(u.user_age) from Users u where useId=:ud")
	//Integer age(@Param("ud") Integer uId);
	//SELECT poll_id FROM poll10.agerestriction WHERE age_restriction=20;
	
	@Query("select p.pollId from AgeRestriction a inner join a.pollId p where a.minAge <=:ag and a.maxAge >=:ag")
	ArrayList<Integer> poll(@Param("ag") Integer age);

	
	//INSERT INTO poll140.agerestriction (max_age, min_age, poll_id ) VALUES (20,30,2);
	@Modifying
	@Query(value = "insert into AgeRestriction (min_age,max_age,poll_id) VALUES (:minAge,:maxAge,:pollid)", nativeQuery = true)
	@Transactional
	 void saveAge(@Param("pollid") Integer pollid,@Param("minAge") Integer minAge,@Param("maxAge") Integer maxAge);
}


