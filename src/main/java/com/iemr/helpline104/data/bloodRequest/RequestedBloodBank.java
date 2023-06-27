package com.iemr.helpline104.data.bloodRequest;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.helpline104.utils.mapper.OutputMapper;

@Entity
@Table(name="t_requestedbloodbank")
public class RequestedBloodBank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RequestedBloodBankID")
	@Expose
	private Integer requestedBloodBankID;	
	@Expose
	@Column(name = "BloodReqID")
	private Long bloodReqID;	
	@Expose
	private String bloodBankAddress;
	@Expose
	private String bbPersonName;
	@Expose
	private String bbPersonDesignation;
	@Expose
	private String bbMobileNo;	
	
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "Remarks")
	private String remarks;
	
	@Column(name = "Deleted",insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Column(name = "CreatedDate", insertable=false, updatable=false)
	private Date createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable=false, updatable=false)
	private Date lastModDate;
	
	public RequestedBloodBank()
	{
		super();		
	}
	
	
	public RequestedBloodBank(String address, String name, String designation, String mobile)
	{
		super();
		this.bloodBankAddress = address;
		this.bbPersonName = name;
		this.bbPersonDesignation = designation;
		this.bbMobileNo = mobile;		
	}
	
	public void setBloodReqID(Long bloodReqID)
	{
		this.bloodReqID = bloodReqID;
	}
	
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}
	
	@Transient
	OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}		
	

}
