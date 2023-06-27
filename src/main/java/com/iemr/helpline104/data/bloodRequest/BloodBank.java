package com.iemr.helpline104.data.bloodRequest;

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
@Table(name="m_institution")
public class BloodBank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InstitutionID")
	@Expose
	private Integer institutionID;
	
	@Expose
	@Column(name = "Website")
	private String website;
	
	@Column(name = "InstitutionName")	
	private String institutionName;
	
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	
	@Column(name = "Deleted")
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
	
	@Transient
	OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

}
