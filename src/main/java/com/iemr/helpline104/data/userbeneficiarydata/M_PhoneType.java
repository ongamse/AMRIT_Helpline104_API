package com.iemr.helpline104.data.userbeneficiarydata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "M_PhoneType")
public class M_PhoneType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short phoneTypeID;
	private String phoneType;
	private Boolean deleted;
	private String createdBy;
	private String modifiedBy;
	
	public M_PhoneType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public M_PhoneType(Short phoneTypeID, String phoneType) {
		this.phoneTypeID = phoneTypeID;
		this.phoneType = phoneType;
	}
	
	public Short getPhoneTypeID() {
		return phoneTypeID;
	}

	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
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
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public String toString() {
		return new Gson().toJson(this);
	}
}
