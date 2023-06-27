package com.iemr.helpline104.data.hihl;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_hihlcocasesheet")
public class T_hihlcocasesheet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", insertable = false, updatable = false)
	private Long id;

	@Column(name = "BenCallID")
	private Long benCallID;

	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Column(name = "Providerservicemapid")
	private Integer providerServiceMapID;

	@Column(name = "Cocasesheet")
	private String cocasesheet;

	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Column(name = "CreatedBy")
	private String createdBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBenCallID() {
		return benCallID;
	}

	public void setBenCallID(Long benCallID) {
		this.benCallID = benCallID;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCocasesheet() {
		return cocasesheet;
	}

	public void setCocasesheet(String cocasesheet) {
		this.cocasesheet = cocasesheet;
	}

}
