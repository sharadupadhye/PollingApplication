package com.example.Poll10.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Poll10.entity.PollName;
import com.example.Poll10.entity.PollOption;


@Repository
public interface PollNameRepository extends JpaRepository<PollName,Integer> {
	
	@Query("select p.pollId from PollName p ")
	ArrayList<Integer> allPoll();
	

}
