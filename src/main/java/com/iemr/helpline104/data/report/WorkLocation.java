package com.iemr.helpline104.data.report;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.helpline104.utils.mapper.OutputMapper;


@Entity
@Table(name = "m_providerserviceaddmapping")
public class WorkLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PSAddMapID")
	@Expose
	private Integer psAddMapID;

	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer providerServiceMapID;
	@Column(name = "DistrictID")
	@Expose
	private Integer districtID;
	@Column(name = "Deleted")
	@Expose
	private Boolean deleted;
	@Column(name = "LocationName")
	@Expose
	private String locationName;
	@Column(name = "Address")
	@Expose
	private String address;
	@Column(name = "Processed")
	private String processed;
	@Column(name = "createdBy")
	@Expose
	private String CreatedBy;
	@Column(name = "modifiedBy")
	private String ModifiedBy;
	@Column(name = "createdDate")
	@Expose
	private Timestamp CreatedDate;
	@Column(name = "LastModDate")
	private Timestamp lastModDate;

	@Transient
	private OutputMapper mapper = new OutputMapper();

	@Override
	public String toString() {
		return mapper.gson().toJson(this);
	}
}
