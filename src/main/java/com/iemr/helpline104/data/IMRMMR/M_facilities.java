package com.iemr.helpline104.data.IMRMMR;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_imrmmrFacility")
public class M_facilities {
	
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ImrmmrfacilityID ")
	private Integer facilityID ;

	@Expose
	@Column(name = "facilityName")
	private String facilityName ;

	public M_facilities() {
	}
	
	public M_facilities(Integer facilityID, String facilityName) {
	    this.facilityID = facilityID;
	    this.facilityName = facilityName;
	}

	public Integer getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(Integer facilityID) {
		this.facilityID = facilityID;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
}
