package com.example.Poll10.payload;

import java.util.ArrayList;

import java.util.List;

import com.example.Poll10.entity.DAOUser;
import com.example.Poll10.entity.PollOption;
import com.example.Poll10.entity.Vote;

public class VoteDto {

	private int voteId;
	
	private DAOUser users;
	
	private PollOption optionId;

	public int getVoteId() {
		return voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	public DAOUser getUsers() {
		return users;
	}

	public void setUsers(DAOUser users) {
		this.users = users;
	}

	public PollOption getOptionId() {
		return optionId;
	}

	public void setOptionId(PollOption optionId) {
		this.optionId = optionId;
	}
	
	
	

}
