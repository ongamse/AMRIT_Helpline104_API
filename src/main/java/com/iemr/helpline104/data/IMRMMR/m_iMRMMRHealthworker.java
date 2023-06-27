package com.iemr.helpline104.data.IMRMMR;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_imrmmrhealthworker")
public class m_iMRMMRHealthworker {

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imrmmrhwID ")
	private Integer imrmmrHealthWorkerID ;
	
	@Expose
	@Column(name = "HealthWorkerType")
	private String healthWorkerType ;
	
	public m_iMRMMRHealthworker(Integer imrmmrHealthWorkerID, String healthWorkerType) {
	    this.imrmmrHealthWorkerID = imrmmrHealthWorkerID;
	    this.healthWorkerType = healthWorkerType;
	}
}
