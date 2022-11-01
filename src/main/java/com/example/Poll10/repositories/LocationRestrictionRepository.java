package com.example.Poll10.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Poll10.entity.LocationRestriction;

@Repository
public interface LocationRestrictionRepository extends JpaRepository <LocationRestriction,Integer> {
	
	//@Query("select p.pollId from AgeRestriction a inner join a.pollId p where a.minAge <=:ag and a.maxAge >=:ag")
	//ArrayList<Integer> poll(@Param("ag") Integer age);
	
	@Query("select p.pollId from LocationRestriction l inner join l.pollId p  where l.Restriction=:location")
	ArrayList<Integer> Loc(@Param("location") String location);
	
	//@Query("SELECT COUNT(v.optionId) FROM  Vote v inner join v.users  u inner join v.optionId p  " 
	//        +" where p.optionId =:count and u.user_age BETWEEN 5 AND 21 ")
	//Integer count1(@Param("count") Integer count);
}
