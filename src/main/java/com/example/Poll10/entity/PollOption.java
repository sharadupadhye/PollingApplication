package com.example.Poll10.entity;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType
;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "polloption")
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
public class PollOption {
	public static int fg;


	@Id
    @Column(name="optionId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int optionId;
   
	
	@Column(name="poll_option")
    private String pollOption;
    
	@ManyToOne
	@JoinColumn(name="pollId")
    private PollName pollOpt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "optionId",cascade = CascadeType.ALL)
	 private List<Vote> vote = new ArrayList<>();

	
	//@JsonIgnore
	//@OneToOne(cascade = CascadeType.ALL, mappedBy = "polloption",fetch = FetchType.LAZY)
   // private Vote vote;

	

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

	public List<Vote> getVote() {
		return vote;
	}

	public void setVote(List<Vote> vote) {
		this.vote = vote;
	}

	public static int getFg() {
		return fg;
	}

	public static void setFg(int fg) {
		PollOption.fg = fg;
	}
	 
	
   
}
