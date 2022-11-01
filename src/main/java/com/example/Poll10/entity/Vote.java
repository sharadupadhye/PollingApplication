package com.example.Poll10.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vote")
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
public class Vote {
	@Id
    @Column(name="voteId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voteId;
	
	@ManyToOne
	@JoinColumn(name="useId")
    private DAOUser users;
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "optionId")
//    private PollOption polloption;
	
	@ManyToOne
	@JoinColumn(name="optionId")
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
