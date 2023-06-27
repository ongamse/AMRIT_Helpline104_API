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

import com.iemr.helpline104.data.users.M_User;

@Entity
@Table(name = "m_maritalstatus")
public class M_MaritalStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer MaritalStatusID;
    /*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_maritalstatus")
	private Set<I_Beneficiary> i_beneficiary; */

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_maritalstatus")
	private Set<M_User> m_user;

	private String Status;
	private String StatusDesc;
	private Boolean Deleted;
	private String CreatedBy;
	private Date CreatedDate;
	private String ModifiedBy;
	private Date LastModDate;

	public M_MaritalStatus() {
	}

	public M_MaritalStatus(int MaritalStatusID, String Status) {
		this.MaritalStatusID = MaritalStatusID;
		this.Status = Status;
	}
}
