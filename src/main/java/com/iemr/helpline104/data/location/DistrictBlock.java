package com.iemr.helpline104.data.location;

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
@Table(name = "m_districtblock")
public class DistrictBlock
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Integer blockID;
	@Expose
	private Integer districtID;
	@Expose
	private String blockName;
	private Integer stateID;
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;

	public DistrictBlock()
	{
	}

	public DistrictBlock(Integer BlockID, String BlockName)
	{
		this.blockID = BlockID;
		this.blockName = BlockName;
	}

	public Integer getBlockID()
	{
		return this.blockID;
	}

	public void setBlockID(int blockID)
	{
		this.blockID = Integer.valueOf(blockID);
	}

	public Integer getDistrictID()
	{
		return this.districtID;
	}

	public void setDistrictID(int districtID)
	{
		this.districtID = Integer.valueOf(districtID);
	}

	public String getBlockName()
	{
		return this.blockName;
	}

	public void setBlockName(String blockName)
	{
		this.blockName = blockName;
	}

	public Integer getStateID()
	{
		return this.stateID;
	}

	public void setStateID(int stateID)
	{
		this.stateID = Integer.valueOf(stateID);
	}

	public Boolean isDeleted()
	{
		return this.deleted;
	}

	public void setDeleted(boolean deleted)
	{
		this.deleted = Boolean.valueOf(deleted);
	}

	public String getCreatedBy()
	{
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Date getCreatedDate()
	{
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getModifiedBy()
	{
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModDate()
	{
		return this.lastModDate;
	}

	public void setLastModDate(Date lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	public String toString()
	{
		return new Gson().toJson(this);
	}
}
