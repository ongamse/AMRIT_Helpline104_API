package com.iemr.helpline104.data.healthCareWorkerType;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name="M_HealthCareWorker")
public class M_HealthCareWorker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short healthCareWorkerID;
	private String healthCareWorkerType;
	private String healthCareWorkerDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	
	public M_HealthCareWorker(Short healthCareWorkerID, String healthCareWorkerType, String healthCareWorkerDesc,
			Boolean deleted, String createdBy, Timestamp createdDate, String modifiedBy, Timestamp lastModDate) {
		super();
		this.healthCareWorkerID = healthCareWorkerID;
		this.healthCareWorkerType = healthCareWorkerType;
		this.healthCareWorkerDesc = healthCareWorkerDesc;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
	}

	public M_HealthCareWorker(Short healthCareWorkerID, String healthCareWorkerType) {

		this.healthCareWorkerID = healthCareWorkerID;
		this.healthCareWorkerType = healthCareWorkerType;
	}

	public M_HealthCareWorker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Short getHealthCareWorkerID() {
		return healthCareWorkerID;
	}

	public String getHealthCareWorkerType() {
		return healthCareWorkerType;
	}

	public void setHealthCareWorkerType(String healthCareWorkerType) {
		this.healthCareWorkerType = healthCareWorkerType;
	}

	public String getHealthCareWorkerDesc() {
		return healthCareWorkerDesc;
	}

	public void setHealthCareWorkerDesc(String healthCareWorkerDesc) {
		this.healthCareWorkerDesc = healthCareWorkerDesc;
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
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
