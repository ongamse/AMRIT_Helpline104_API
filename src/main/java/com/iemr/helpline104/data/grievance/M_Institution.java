package com.iemr.helpline104.data.grievance;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="m_institution")
public class M_Institution {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="InstitutionID")
	private int InstitutionID;
	@Column(name="InstitutionName")
	private String institutionName;
	@Column(name="StateID")
	private int stateID; 
	@Column(name="DistrictID")
	private int districtID;
	@Column(name="DistrictBranchMappingID")
	private int districtBranchMappingID;
	@Column(name="Deleted", insertable=false, updatable=true)
	private Boolean deleted;
	@Column(name="CreatedBy")
	private String createdBy; 
	@Column(name="CreatedDate", insertable=false, updatable=false)
	private Date createdDate;
	@Column(name="ModifiedBy")
	private String modifiedBy;
	@Column(name="LastModDate")
	private Date lastModDate;
	
	
	
	
	@OneToOne(mappedBy="minstitution")
	private T_Feedback Feedback;
	
	public M_Institution() {
		// TODO Auto-generated constructor stub
	}

	public int getInstitutionID() {
		return InstitutionID;
	}

	public void setInstitutionID(int institutionID) {
		InstitutionID = institutionID;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public int getStateID() {
		return stateID;
	}

	public void setStateID(int stateID) {
		this.stateID = stateID;
	}

	public int getDistrictID() {
		return districtID;
	}

	public void setDistrictID(int districtID) {
		this.districtID = districtID;
	}

	public int getDistrictBranchMappingID() {
		return districtBranchMappingID;
	}

	public void setDistrictBranchMappingID(int districtBranchMappingID) {
		this.districtBranchMappingID = districtBranchMappingID;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}

	public T_Feedback getFeedback() {
		return Feedback;
	}

	public void setFeedback(T_Feedback feedback) {
		Feedback = feedback;
	}

	

}
