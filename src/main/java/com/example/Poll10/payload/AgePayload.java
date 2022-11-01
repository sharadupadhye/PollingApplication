package com.example.Poll10.payload;

import com.example.Poll10.entity.PollName;
import com.example.Poll10.entity.Vote;

public class AgePayload {
	
	 private int optionId;
	 
	 private String pollOption;
	 
	 private PollName pollOpt;
	 
	 private Vote vote;

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getPollOption() {
		return pollOption;
	}

	public void setPollOption(String pollOption) {
		this.pollOption = pollOption;
	}

	public PollName getPollOpt() {
		return pollOpt;
	}

	public void setPollOpt(PollName pollOpt) {
		this.pollOpt = pollOpt;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}
	 
	 
	
	

}
