package com.iemr.helpline104.data.drugGroup;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.iemr.helpline104.data.drugMaster.M_DrugMaster;
import com.iemr.helpline104.data.feedbackNature.M_FeedbackNature;
import com.iemr.helpline104.data.location.M_ProviderServiceMapping;
import com.iemr.helpline104.data.location.M_ServiceProvider;

@Entity
@Table(name="m_104druggroup")
public class M_DrugGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "DrugGroupID")
	private Integer drugGroupID;
	@Expose
	@Column(name = "DrugGroup")
	private String drugGroup;
	@Expose
	@Column(name = "DrugGroupDesc")
	private String drugGroupDesc;
	@Expose
	@Column(name = "ServiceProviderID")
	private Integer serviceProviderID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "ServiceProviderID")
	private M_ServiceProvider m_ServiceProvider;
	
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
	@Column(name = "CreatedDate" ,insertable = false, updatable = false)
	private Date createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy; 
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;
	
	public M_DrugGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public M_DrugGroup(Integer drugGroupID, String drugGroup, String drugGroupDesc) {
		super();
		this.drugGroupID = drugGroupID;
		this.drugGroup = drugGroup;
		this.drugGroupDesc = drugGroupDesc;
		
	}

	public Integer getDrugGroupID() {
		return drugGroupID;
	}
	
	public String getDrugGroup() {
		return drugGroup;
	}

	public void setDrugGroup(String drugGroup) {
		this.drugGroup = drugGroup;
	}

	public String getDrugGroupDesc() {
		return drugGroupDesc;
	}

	public void setDrugGroupDesc(String drugGroupDesc) {
		this.drugGroupDesc = drugGroupDesc;
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
	
	
	
	public String toString() {
		return new Gson().toJson(this);
	}

	public Integer getServiceProviderID() {
		return serviceProviderID;
	}

	private void setServiceProviderID(Integer serviceProviderID) {
		this.serviceProviderID = serviceProviderID;
	}

	
}
