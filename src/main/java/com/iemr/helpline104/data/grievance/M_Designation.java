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
 @Table(name="m_designation")
 public class M_Designation {
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="DesignationID")
	 private int DesignationID; 
	 @Column(name="DesignationName")
	 private String designationName;
	 @Column(name="DesignationDesc")
	 private String designationDesc;
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
	 
	 
	 @OneToOne(mappedBy="mdesignation")
		private T_Feedback Feedback;
	 
	 public M_Designation() {
		// TODO Auto-generated constructor stub
	}

	public int getDesignationID() {
		return DesignationID;
	}

	public void setDesignationID(int designationID) {
		DesignationID = designationID;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getDesignationDesc() {
		return designationDesc;
	}

	public void setDesignationDesc(String designationDesc) {
		this.designationDesc = designationDesc;
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
