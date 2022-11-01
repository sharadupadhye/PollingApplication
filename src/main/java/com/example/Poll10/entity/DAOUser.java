package com.example.Poll10.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@Column(name="useId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int useId;
	
	@Column
	private String username;
	
	@Column
	@JsonIgnore
	private String password;
	
	@Column(name="user_age")
	@JsonIgnore
    private int user_age;
	
	@Column(name="user_location")
    private String  user_location;
    @JsonIgnore
    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
	 private List<Vote> votes = new ArrayList<>();
	public int getUseId() {
		return useId;
	}
	public void setUseId(int useId) {
		this.useId = useId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public List<Vote> getVotes() {
		return votes;
	}
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	

	

}