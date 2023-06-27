package com.iemr.helpline104.data.search;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "i_beneficiarymapping")
public class BeneficiaryMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BenMapId")	
	private Long beneficiaryRegID;
	
	@Expose
	@Column(name = "BenRegID")
	private Long benRegID;
	
	@Expose
	@Column(name = "BenContactsId")
	private Long benContactsId;
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;
	
	public String toString()
	{
		return new Gson().toJson(this);
	}
}
