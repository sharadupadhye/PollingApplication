package com.example.Poll10.services;
import java.util.ArrayList;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Poll10.entity.DAOUser;
import com.example.Poll10.entity.UserDTO;
import com.example.Poll10.payload.forgotPwd;
import com.example.Poll10.repositories.UserDao;




@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setUser_age(user.getUser_age());
		newUser.setUser_location(user.getUser_location());
		return userDao.save(newUser);
	}
	
	public int resetPassword(forgotPwd fp) {
		String uname=fp.getUsername();
		String pwd=fp.getPassword();
		pwd=bcryptEncoder.encode(pwd);
		int a=userDao.updatePassword(pwd, uname);
//		if(a>1) 
//		{
//			UserDetails userDetails= loadUserByUsername(uname) ;
//			final String token = jwtTokenUtil.generateToken(userDetails);
//			
//		}
		 return a;		
	}
}