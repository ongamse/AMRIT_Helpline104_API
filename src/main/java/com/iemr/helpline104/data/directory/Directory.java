package com.iemr.helpline104.data.directory;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "m_institutedirectory")
public class Directory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InstituteDirectoryID")
	private Integer instituteDirectoryID;
	// m_institutedirectorymapping
	// m_institutesubdirectory
	@Column(name = "InstituteDirectoryName")
	private String instituteDirectoryName;
	@Column(name = "InstituteDirectoryDesc")
	private String instituteDirectoryDesc;
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

	protected Directory() {
	}

	public Directory(int institutionID, String directoryName) {
		this.instituteDirectoryID = institutionID;
		this.instituteDirectoryName = directoryName;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
