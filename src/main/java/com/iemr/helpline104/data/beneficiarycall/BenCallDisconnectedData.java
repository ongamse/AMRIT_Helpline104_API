package com.iemr.helpline104.data.beneficiarycall;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "czentriclog")
public class BenCallDisconnectedData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "CZentricLogid", insertable = false, updatable = false)
	private Long cZentricLogID;
	
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;
	
	@Expose
	@Column(name = "CallID")
	private String callID;
	
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	
	@Expose
	@Column(name = "CallLogResponse")
	private String callLogResponse;
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = false)
	private Boolean deleted;
	
	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;
	
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
	
	

	public Long getcZentricLogID() {
		return cZentricLogID;
	}

	public void setcZentricLogID(Long cZentricLogID) {
		this.cZentricLogID = cZentricLogID;
	}

	public Long getBenCallID() {
		return benCallID;
	}

	public void setBenCallID(Long benCallID) {
		this.benCallID = benCallID;
	}

	public String getCallID() {
		return callID;
	}

	public void setCallID(String callID) {
		this.callID = callID;
	}
	
	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public String getCallLogResponse() {
		return callLogResponse;
	}

	public void setCallLogResponse(String callLogResponse) {
		this.callLogResponse = callLogResponse;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
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
	
	
	

}
