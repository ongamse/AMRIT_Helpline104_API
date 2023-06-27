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
@Table(name="m_servicemaster")
public class M_Servicemaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ServiceID")
	private int ServiceID;
	@Column(name="ServiceName")
	private String serviceName;
	@Column(name="ServiceDesc")
	private String serviceDesc;
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
	
	
	@OneToOne(mappedBy="mservicemaster")
	private T_Feedback Feedback;


	public int getServiceID() {
		return ServiceID;
	}


	public void setServiceID(int serviceID) {
		ServiceID = serviceID;
	}


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public String getServiceDesc() {
		return serviceDesc;
	}


	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
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
