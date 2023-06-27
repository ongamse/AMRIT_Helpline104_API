package com.iemr.helpline104.data.userbeneficiarydata;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.helpline104.utils.mapper.OutputMapper;

@Entity
@Table(name = "m_gender")
public class M_Gender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
/*	
 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "m_gender")
	private Set<I_Beneficiary> i_beneficiary;*/
	
/*	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "GenderID")
	private I_Beneficiary i_beneficiary;*/
	
	@Expose
	private Short genderID;
	
	@Expose
	private String genderName;
	private Boolean deleted;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date lastModDate;

	public M_Gender() {
	}

	public M_Gender(Short GenderID, String GenderName) {
		this.genderID = GenderID;
		this.genderName=GenderName;
	}
	
	
	
	

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
