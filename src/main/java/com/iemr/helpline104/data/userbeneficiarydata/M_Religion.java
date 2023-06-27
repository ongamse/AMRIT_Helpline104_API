package com.iemr.helpline104.data.userbeneficiarydata;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.iemr.helpline104.data.users.M_UserDemographics;

@Entity
@Table(name = "M_Religion")
public class M_Religion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ReligionID;
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_religion")
	private Set<I_BenDemographics> i_bendemographics;*/
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_religion")
	private Set<M_UserDemographics> m_userdemographics;
	private String ReligionType;
	private String ReligionDesc;
	private Boolean Deleted;
	private String CreatedBy;
	private Date CreatedDate;
	private String ModifiedBy;
	private Date LastModDate;

	protected M_Religion() {
	}

	public M_Religion(int ReligionID, String ReligionType, String ReligionDesc) {
		this.ReligionID = Integer.valueOf(ReligionID);
		this.ReligionType = ReligionType;
		this.ReligionDesc = ReligionDesc;
	}

	public String toString() {
		return new Gson().toJson(this);
	}
}
