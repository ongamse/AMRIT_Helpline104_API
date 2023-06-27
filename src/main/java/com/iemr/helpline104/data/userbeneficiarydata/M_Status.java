package com.iemr.helpline104.data.userbeneficiarydata;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.iemr.helpline104.data.users.M_User;

@Entity
@Table(name = "m_status")
public class M_Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer StatusID;
	
	@OneToMany(mappedBy = "m_status", fetch = FetchType.LAZY)
	private Set<M_User> m_user;
	/*
	@OneToMany(mappedBy = "m_status", fetch = FetchType.LAZY)
	private Set<I_Beneficiary> i_beneficiary; */
	
	private String Status;
	private String StatusDesc;
	private Boolean Deleted;
	private String CreatedBy;
	private Timestamp CreatedDate;
	private String ModifiedBy;
	private Timestamp LastModDate;

	protected M_Status() {
	}

	public M_Status(int statusID, String status) {
		this.StatusID = Integer.valueOf(statusID);
		this.Status = status;
	}

	public M_Status(int statusID, String status, String statusDesc, boolean deleted, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate, Set<M_User> m_User) {
		this.StatusID = Integer.valueOf(statusID);
		this.Status = status;
		this.StatusDesc = statusDesc;
		this.Deleted = Boolean.valueOf(deleted);
		this.CreatedBy = createdBy;
		this.CreatedDate = createdDate;
		this.ModifiedBy = modifiedBy;
		this.LastModDate = lastModDate;
		this.m_user = m_User;
	}

	public int getStatusID() {
		return this.StatusID.intValue();
	}

	public void setStatusID(int statusID) {
		this.StatusID = Integer.valueOf(statusID);
	}

	public String getStatus() {
		return this.Status;
	}

	public void setStatus(String status) {
		this.Status = status;
	}

	public String getStatusDesc() {
		return this.StatusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.StatusDesc = statusDesc;
	}

	public boolean isDeleted() {
		return this.Deleted.booleanValue();
	}

	public void setDeleted(boolean deleted) {
		this.Deleted = Boolean.valueOf(deleted);
	}

	public String getCreatedBy() {
		return this.CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		this.CreatedBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.CreatedDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.CreatedDate = createdDate;
	}

	public String getModifiedBy() {
		return this.ModifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.ModifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return this.LastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.LastModDate = lastModDate;
	}

	public Set<M_User> getM_User() {
		return this.m_user;
	}

	public void setM_User(Set<M_User> m_User) {
		this.m_user = m_User;
	}
}
