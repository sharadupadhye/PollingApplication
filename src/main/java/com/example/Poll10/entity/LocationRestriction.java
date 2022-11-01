package com.example.Poll10.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.tools.DocumentationTool.Location;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "locationrestriction")
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
public class LocationRestriction {
	@Id
    @Column(name="locationID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationID;
	
//------------------------------------------------------------------------
	@Column(name = "Restriction")
	private String Restriction;
	
	
	@ManyToOne
	@JoinColumn(name="pollId")
     private PollName pollId;
 //------------------------------------------------------------------------  
//	@Column(name = "Restriction")
//	@Enumerated(EnumType.STRING)
//	private Loc Restriction ;
//	//@Enumerated(EnumType.STRING )
//		//private OrderStatus status;
//	public enum Loc {
//		SOLAPUR,PUNE,SANGLI,SATARA,NASHIK,MUMBAI,KOLHAPUR
//		
//	}
//------------------------------------------------------------------------


	public int getLocationID() {
		return locationID;
	}


	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}


	public String getRestriction() {
		return Restriction;
	}


	public void setRestriction(String restriction) {
		Restriction = restriction;
	}


	public PollName getPollId() {
		return pollId;
	}


	public void setPollId(PollName pollId) {
		this.pollId = pollId;
	}
	
	
	
	
	
}
