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

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "pollname")
@DynamicUpdate
public class PollName {
	@Id
    @Column(name="pollId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pollId;
   
	@Column(name="pollName")
    private String pollName;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "pollOpt",cascade = CascadeType.ALL)
    private List<PollOption> polloptions = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "pollId",cascade = CascadeType.ALL)
    private List<AgeRestriction> agerestrictions = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "pollId",cascade = CascadeType.ALL)
	 private List<LocationRestriction> locationrestrictions = new ArrayList<>();

	

	public int getPollId() {
		return pollId;
	}

	public void setPollId(int pollId) {
		this.pollId = pollId;
	}

	public String getPollName() {
		return pollName;
	}

	public void setPollName(String pollName) {
		this.pollName = pollName;
	}

	

	public List<PollOption> getPolloptions() {
		return polloptions;
	}

	public void setPolloptions(List<PollOption> polloptions) {
		this.polloptions = polloptions;
	}

	public List<AgeRestriction> getAgerestrictions() {
		return agerestrictions;
	}

	public void setAgerestrictions(List<AgeRestriction> agerestrictions) {
		this.agerestrictions = agerestrictions;
	}

	public List<LocationRestriction> getLocationrestrictions() {
		return locationrestrictions;
	}

	public void setLocationrestrictions(List<LocationRestriction> locationrestrictions) {
		this.locationrestrictions = locationrestrictions;
	}
    
	 
   
}
