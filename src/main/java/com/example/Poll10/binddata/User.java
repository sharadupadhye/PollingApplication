package com.example.Poll10.binddata;

public class User {
	
	
	private Integer userID;
     
	private int user_age;
	
	private String  user_location;
	

	

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public int getUser_age() {
		return user_age;
	}

	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	public String getUser_location() {
		return user_location;
	}

	public void setUser_location(String user_location) {
		this.user_location = user_location;
	}

//	@Override
//	public String toString() {
//		return "User [ age=" + age + "]";
//	}
	
	
}