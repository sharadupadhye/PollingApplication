package com.example.Poll10.payload;

import com.example.Poll10.entity.PollName;

public class AgeRestrictionDTO {
	private int ageId;
	
	private String ageRest;
	
	private PollName pollId;

	public int getAgeId() {
		return ageId;
	}

	public void setAgeId(int ageId) {
		this.ageId = ageId;
	}

	

	public String getAgeRest() {
		return ageRest;
	}

	public void setAgeRest(String ageRest) {
		this.ageRest = ageRest;
	}

	public PollName getPollId() {
		return pollId;
	}

	public void setPollId(PollName pollId) {
		this.pollId = pollId;
	}
	
	

}
