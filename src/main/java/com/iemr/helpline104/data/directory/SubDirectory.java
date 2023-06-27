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
@Table(name = "m_institutesubdirectory")
public class SubDirectory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InstituteSubDirectoryID")
	private Integer instituteSubDirectoryID;
	// m_institutedirectorymapping
	// m_instituteroutedirectory
	@Column(name = "InstituteDirectoryID")
	private Integer instituteDirectoryID;
	// m_institutedirectory
	// m_institutesubdirectory
	@Column(name = "InstituteSubDirectoryName")
	private String instituteSubDirectoryName;
	@Column(name = "InstituteSubDirectoryDesc")
	private String instituteSubDirectoryDesc;
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

	public Integer getInstituteSubDirectoryID() {
		return instituteSubDirectoryID;
	}

	public Integer getInstituteDirectoryID() {
		return instituteDirectoryID;
	}

	public String getInstituteSubDirectoryName() {
		return instituteSubDirectoryName;
	}

	public String getInstituteSubDirectoryDesc() {
		return instituteSubDirectoryDesc;
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

	protected SubDirectory() {
	}

	public SubDirectory(int institutionSubDirectoryID, int institutionDirectoryID, String instituteSubDirectoryName) {
		this.instituteSubDirectoryID = institutionSubDirectoryID;
		this.instituteDirectoryID = institutionDirectoryID;
		this.instituteSubDirectoryName = instituteSubDirectoryName;
	}

	public SubDirectory(int institutionSubDirectoryID, String instituteSubDirectoryName) {
		this.instituteSubDirectoryID = institutionSubDirectoryID;
		this.instituteSubDirectoryName = instituteSubDirectoryName;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
