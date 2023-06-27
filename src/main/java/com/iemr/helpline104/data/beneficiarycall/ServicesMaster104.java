package com.iemr.helpline104.data.beneficiarycall;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_104servicesmaster")
public class ServicesMaster104 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "104ServiceID")
	@Expose
	private Integer serviceID104;
	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "servicesMaster104", fetch = FetchType.LAZY)
	private List<BenCallServicesMappingHistory> benCallServicesMappingHistories;
	
	
	@Column(name = "104ServiceName")
	@Expose
	private String serviceNameFor104;
	
	@Column(name = "104ServiceDesc")
	@Expose
	private String serviceDescFor104;
	
	@Column(name = "Deleted")
	@Expose
	private Boolean deleted;
	
	@Column(name = "CreatedBy")
	private String createdBy;
	
	@Column(name = "CreatedDate")
	private Date createdDate;
	
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	
	@Column(name = "LastModDate")
	private Date lastModDate;

	public ServicesMaster104() {
	}

	public ServicesMaster104(Integer serviceID104, String serviceNameFor104, String serviceDescFor104,
			Boolean deleted) {
		this.serviceID104 = serviceID104;
		this.serviceNameFor104 = serviceNameFor104;
		this.serviceDescFor104 = serviceDescFor104;
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		gsonBuilder.serializeNulls().setLongSerializationPolicy(LongSerializationPolicy.STRING);
		String tostring = gsonBuilder.create().toJson(this).toString();
		return tostring;
	}
	
}
