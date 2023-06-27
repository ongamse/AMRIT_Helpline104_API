package com.iemr.helpline104.data.covidMaster;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;


@Entity
@Table(name = "m_covidmaster")
public class SymptomsMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "CovidmasterID", insertable = false, updatable = false)
	private Integer covidMasterID;
	
	@Expose
	@Column(name = "MasterType")
	private String masterType;
	
	@Expose
	@Column(name = "MasterValues")
	private String masterValues;
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = false)
	private Boolean deleted;
	
	@Expose
	@Column(name = "Processed", insertable = false, updatable = false)
	private Character processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	
	
	
	

	public Character getProcessed() {
		return processed;
	}

	public void setProcessed(Character processed) {
		this.processed = processed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Integer getCovidMasterID() {
		return covidMasterID;
	}

	public void setCovidMasterID(Integer covidMasterID) {
		this.covidMasterID = covidMasterID;
	}

	public String getMasterType() {
		return masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}

	public String getMasterValues() {
		return masterValues;
	}

	public void setMasterValues(String masterValues) {
		this.masterValues = masterValues;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
}
