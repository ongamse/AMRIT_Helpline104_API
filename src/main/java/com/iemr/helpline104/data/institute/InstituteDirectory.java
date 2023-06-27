package com.iemr.helpline104.data.institute;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_institutedirectory")
public class InstituteDirectory {

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InstituteDirectoryID")
	private Integer instituteDirectoryID;
	
	@Expose
	@Column(name = "InstituteDirectoryName")
	private String instituteDirectoryName;	
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

	public InstituteDirectory() {
		super();
	}
	

	public InstituteDirectory(String instituteDirectoryName) {
		this.instituteDirectoryName = instituteDirectoryName;
	}


	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
	
}
