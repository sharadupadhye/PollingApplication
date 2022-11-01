package com.example.Poll10.repositories;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Poll10.entity.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	public DAOUser findByUsername(String username);
	
	@Query("select u.user_age from DAOUser u where useId=:ud")
	Integer age(@Param("ud") Integer uId);
	
	@Query("select u.user_location from DAOUser u where useId=:ud")
	String location(@Param("ud") Integer uId);
	
	@Transactional
	@Modifying 
	@Query("update DAOUser c set c.password =:n where c.username =:m")
	int updatePassword(@Param("n") String password,@Param("m") String userid);
}