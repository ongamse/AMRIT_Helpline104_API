package com.iemr.helpline104.data.userbeneficiarydata;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_title")
public class M_Title {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer TitleID;
	private String TitleName;
	private String TitleDesc;
	private Boolean Deleted;
	private String CreatedBy;
	private Date CreatedDate;
	private String ModifiedBy;
	private Date LastModDate;

	public M_Title() {
	}

	public M_Title(int titleID, String titleName) {
		this.TitleID = Integer.valueOf(titleID);
		this.TitleName = titleName;
	}
}
