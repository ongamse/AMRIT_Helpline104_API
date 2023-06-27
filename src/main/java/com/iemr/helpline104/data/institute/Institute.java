package com.iemr.helpline104.data.institute;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.iemr.helpline104.data.location.DistrictBranchMapping;
import com.iemr.helpline104.data.location.Districts;
import com.iemr.helpline104.data.location.States;


@Entity
@Table(name = "m_institution")
public class Institute {

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InstitutionID")
	private Integer institutionID;
	// m_bencall1097servicesmapping
	// m_institutedirectorymapping
	// t_feedback
	@Expose
	@Column(name = "InstitutionName")
	private String institutionName;
	@Expose
	@Column(name = "StateID")
	private Integer stateID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stateID", insertable = false, updatable = false)
	private States state;
	@Expose
	@Column(name = "DistrictID")
	private Integer districtID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "districtID", insertable = false, updatable = false)
	private Districts district;
	@Expose
	@Column(name = "DistrictBranchMappingID")
	private Integer districtBranchMappingID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DistrictBranchMappingID", insertable = false, updatable = false)
	private DistrictBranchMapping districtbranchmapping;
	@Expose
	@Column(name = "Address")
	private String address;
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "CreatedDate")
	private Date createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate")
	private Date lastModDate;

	protected Institute() {
	}

	public Institute(int institutionID, String institutionName) {
		this.institutionID = institutionID;
		this.institutionName = institutionName;
	}
	
	public Institute(String institutionName, String address) {
		
		this.institutionName = institutionName;
		this.address = address;
	}

	public Institute(int institutionID, String institutionName, int stateID, int districtID,
			int districtBranchMappingID) {
		this.institutionID = institutionID;
		this.institutionName = institutionName;
		this.stateID = stateID;
		this.districtID = districtID;
		this.districtBranchMappingID = districtBranchMappingID;
	}

	public Institute(String institutionName, int stateID, String stateName, Integer districtID, String districtName,
			Integer districtBranchID, String subDistrictName) {
		this.institutionName = institutionName;
		this.district = new Districts(districtID, districtName);
		this.state = new States(stateID, stateName);
		this.districtbranchmapping = new DistrictBranchMapping(districtBranchID, subDistrictName);
	}

	public Integer getInstitutionID() {
		return institutionID;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public Integer getStateID() {
		return stateID;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public Integer getDistrictBranchMappingID() {
		return districtBranchMappingID;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public Date getLastModDate() {
		return lastModDate;
	}
	
	

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
