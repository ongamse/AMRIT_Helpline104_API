package com.iemr.helpline104.data.IMRMMR;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_imrmmrtransittype")
public class m_iMRMMRTransitType {

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imrmmrtransitID ")
	private Integer imrmmrTransitID ;
	
	@Expose
	@Column(name = "TransitType")
	private String transitType ;
	
	public m_iMRMMRTransitType(Integer imrmmrTransitID, String transitType) {
	    this.imrmmrTransitID = imrmmrTransitID;
	    this.transitType = transitType;
	}
}
