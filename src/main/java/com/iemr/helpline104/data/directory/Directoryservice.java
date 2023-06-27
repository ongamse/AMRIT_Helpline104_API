package com.iemr.helpline104.data.directory;

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
import com.iemr.helpline104.data.beneficiarycall.BenCall;
import com.iemr.helpline104.data.institute.Institute;
import com.iemr.helpline104.data.institute.InstituteDirectory;
import com.iemr.helpline104.data.institute.InstituteSubDirectory;
import com.iemr.helpline104.utils.mapper.OutputMapper;


@Entity
@Table(name = "t_directoryservice")
public class Directoryservice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "DirectoryServiceID")
	private Long directoryServiceID;	
	@Expose
	@Column(name = "RequestID")
	private String requestID;
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;	
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "benCallID")
	private BenCall benCall;
	@Expose
	@Column(name = "InstitutionID")	
	private Integer institutionID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institutionID", insertable = false, updatable = false)		
	private Institute institute;
	@Expose
	@Column(name = "InstituteDirectoryID")	
	private Integer instituteDirectoryID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instituteDirectoryID", insertable = false, updatable = false)		
	private InstituteDirectory instituteDirectory;
	@Expose
	@Column(name = "InstituteSubDirectoryID")	
	private Integer instituteSubDirectoryID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instituteSubDirectoryID", insertable = false, updatable = false)		
	private InstituteSubDirectory instituteSubDirectory;
	@Expose
	@Column(name = "Remarks")
	private String remarks;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;	
	@Expose
	@Column(name = "Deleted",insertable = false, updatable = true)
	private Boolean deleted; 
	@Expose
	@Column(name = "Processed",insertable = false, updatable = true)
	private String processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable=false, updatable=false)
	private Date createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable=false, updatable=false)
	private Date lastModDate;
	
	public Directoryservice() {
		super();
		
	}
	public Directoryservice(Long directoryServiceID, String institutionName,String address,String instituteDirectoryName, String instituteSubDirectoryName) {
		super();
		
		this.directoryServiceID = directoryServiceID;
		this.institute = new Institute(institutionName,address);
		this.instituteDirectory = new InstituteDirectory(instituteDirectoryName);
		this.instituteSubDirectory = new InstituteSubDirectory(instituteSubDirectoryName);
		
		
	}
	public Directoryservice(Long directoryServiceID, String institutionName,String instituteDirectoryName, String instituteSubDirectoryName, int stateID, String stateName,Integer districtID, String districtName,Integer districtBranchID, String subDistrictName) {
		super();
		
		this.directoryServiceID = directoryServiceID;
		this.institute = new Institute(institutionName,stateID,stateName,districtID,districtName,districtBranchID,subDistrictName);
		this.instituteDirectory = new InstituteDirectory(instituteDirectoryName);
		this.instituteSubDirectory = new InstituteSubDirectory(instituteSubDirectoryName);
		
	}
	
	public Long getBenCallID()
	{
		return benCallID;
	}
	
	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}
	
	public void setBenCall(BenCall benCall)
	{
		this.benCall = benCall;
	}

	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
	
	


}
