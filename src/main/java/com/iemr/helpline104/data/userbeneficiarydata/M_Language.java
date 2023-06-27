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

import com.iemr.helpline104.data.users.M_UserStateLanguageMapping;

@Entity
@Table(name = "M_Language")
public class M_Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer LanguageID;
	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_language")
	private Set<I_BenDemographics> i_bendemographics; */
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_language")
	private Set<M_UserStateLanguageMapping> m_userstatelanguagemapping;
	
	private String LanguageName;
	private String LanguageDesc;
	private String PropertyFilePath;
	private String IVRFilePath;
	private Boolean Deleted;
	private String CreatedBy;
	private Date CreatedDate;
	private String ModifiedBy;
	private Date LastModDate;

	protected M_Language() {
	}

	public M_Language(int languageId, String languageName, String languageDesc, String propertyFilePath,
			String IVRFilePath) {
		this.LanguageID = Integer.valueOf(languageId);
		this.LanguageName = languageName;
		this.LanguageDesc = languageDesc;
		this.PropertyFilePath = propertyFilePath;
		this.IVRFilePath = IVRFilePath;
	}

	public M_Language(int languageId, String languageName) {
		this.LanguageID = Integer.valueOf(languageId);
		this.LanguageName = languageName;
	}
}
