package com.iemr.helpline104.data.beneficiarycall;

import java.sql.Date;

/**
 * Author: Neeraj Kumar (298657).
 * Date: 02-06-2017.
 * Purpose: 1097 service taken by Beneficiary pojo.... 
 * 
 * 
 * */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_BenCall104ServicesMapping")
public class BenCallServicesMappingHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BenCall104ServiceMapID")
	@Expose
	private Long benCall104ServiceMapID;

	@Column(name = "BeneficiaryRegID")
	@Expose
	private Long beneficiaryRegID;

	@Column(name = "BenCallID")
	@Expose
	private Long benCallID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BenCallID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private BeneficiaryCall beneficiaryCall;
    /*
	@Column(name = "104ServiceID")
	@Expose
	private Integer serviceID104;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "104ServiceID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private ServicesMaster104 servicesMaster104;  */	

	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	public BenCallServicesMappingHistory() {

	}


//	public BenCallServicesMappingHistory(long beneficiaryRegID, Long benCallID, Integer serviceID1097, Boolean deleted, String createdBy) {
//		// this.benCall97ServiceMapID = benCall97ServiceMapID;
//		this.beneficiaryRegID = beneficiaryRegID;
//		this.benCallID = benCallID;
//		this.serviceID104 = serviceID1097;		
//		this.deleted = deleted;
//		this.createdBy = createdBy;
//	}

	public BenCallServicesMappingHistory(Long beneficiaryRegID, Long benCallID, Integer serviceID1097, Boolean deleted, String createdBy) {
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		//this.serviceID104 = serviceID1097;		
		this.deleted = deleted;
		this.createdBy = createdBy;
	}

	public BenCallServicesMappingHistory(long beneficiaryRegID, Long benCallID, Integer serviceID1097,
			String createdBy, Boolean deleted) {
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		//this.serviceID104 = serviceID1097;		
		this.deleted = deleted;
		this.createdBy = createdBy;
	}

	public BenCallServicesMappingHistory(Long benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer serviceID1097, ServicesMaster104 servicesMaster1097, 			
			String createdBy, Date createdDate) {
		this.benCall104ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		//this.serviceID104 = serviceID1097;
		//this.servicesMaster104 = servicesMaster1097;		
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public BenCallServicesMappingHistory(Long benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer serviceID1097, String createdBy, Date createdDate) {
		this.benCall104ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		//this.serviceID104 = serviceID1097;		
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}	
	

	public Long getBenCall97ServiceMapID() {
		return benCall104ServiceMapID;
	}

	public long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public Long getBenCallID() {
		return benCallID;
	}

	public BeneficiaryCall getBeneficiaryCall() {
		return beneficiaryCall;
	}

	/*
	public Integer getServiceID1097() {
		return serviceID104;
	} */

	

	public Boolean getDeleted() {
		return deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public Date getLastModDate() {
		return lastModDate;
	}

	
	@Override
	public String toString() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		gsonBuilder.serializeNulls().setLongSerializationPolicy(LongSerializationPolicy.STRING);
		String tostring = gsonBuilder.create().toJson(this);
		return tostring;
	}
}
