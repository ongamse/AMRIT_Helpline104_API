package com.iemr.helpline104.data.users;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.iemr.helpline104.data.userbeneficiarydata.M_Language;

@Entity
@Table(name = "M_UserStateLanguageMapping")
public class M_UserStateLanguageMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer USLMappingID;
	
	private Integer USRMappingID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true, insertable = false, referencedColumnName = "USRMappingID")
	private M_UserServiceRoleMapping m_userservicerolemapping;
	
	private Integer LanguageID;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true, insertable = false, referencedColumnName = "LanguageID")
	private M_Language m_language;
	
	private Boolean Deleted;
	private String CreatedBy;
	private Date CreatedDate;
	private String ModifiedBy;
	private Date LastModDate;

	protected M_UserStateLanguageMapping() {
	}

	public M_UserStateLanguageMapping(int USLMappingID, int USRMappingID, int languageID, String languageName) {
		this.USLMappingID = Integer.valueOf(USLMappingID);
		this.m_userservicerolemapping = new M_UserServiceRoleMapping(Integer.valueOf(USRMappingID));
		this.m_language = new M_Language(languageID, languageName);
	}

	public String toString() {
		return new Gson().toJson(this);
	}
}
