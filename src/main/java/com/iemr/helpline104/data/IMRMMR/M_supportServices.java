package com.iemr.helpline104.data.IMRMMR;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_imrmmrsupportservices")
public class M_supportServices {
	
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supportServiceID ")
	private Integer supportServiceID ;

	@Expose
	@Column(name = "supportServiceName")
	private String supportServiceName ;

	public M_supportServices() {
	}
	
	public M_supportServices(Integer supportServiceID, String supportServiceName) {
	    this.supportServiceID = supportServiceID;
	    this.supportServiceName = supportServiceName;
	}

	public Integer getSupportServiceID() {
		return supportServiceID;
	}

	public void setSupportServiceID(Integer supportServiceID) {
		this.supportServiceID = supportServiceID;
	}

	public String getSupportServiceName() {
		return supportServiceName;
	}

	public void setSupportServiceName(String supportServiceName) {
		this.supportServiceName = supportServiceName;
	}
}
