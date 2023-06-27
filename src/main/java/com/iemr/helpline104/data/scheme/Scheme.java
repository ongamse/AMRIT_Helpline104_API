package com.iemr.helpline104.data.scheme;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.helpline104.utils.mapper.OutputMapper;

@Entity
@Table(name = "M_Scheme")
public class Scheme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "SchemeID")
	private Integer schemeID;
	@Expose
	@Column(name = "SchemeName")
	private String schemeName;
	
	@Column(name = "SchemeDesc")
	private String schemeDesc;
	
	@Column(name = "KmFileManagerID")
	private Integer kmFileManagerID;
	/*
	@JoinColumn(name = "KmFileManagerID", insertable = false, updatable = false)
	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@Expose
	private KMFileManager kmFileManager; */

	@Transient	
	private String kmFilePath;	
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;	
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;	
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	public Scheme() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Transient
	OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
