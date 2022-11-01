package com.example.Poll10.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "agerestriction")
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
public class AgeRestriction {
	@Id
    @Column(name="ageId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ageId;
   
	
	@Column(name="minAge")
    private Integer minAge;
    
	@Column(name="maxAge")
    private Integer maxAge;
	
	
	
	@ManyToOne
	@JoinColumn(name="pollId")
     private PollName pollId;

	

	public int getAgeId() {
		return ageId;
	}

	public void setAgeId(int ageId) {
		this.ageId = ageId;
	}



	public PollName getPollId() {
		return pollId;
	}

	public void setPollId(PollName pollId) {
		this.pollId = pollId;
	}

	

	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	

	

	
	
	
  

}
