package com.iemr.helpline104.data.location;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name="m_city")
public class CityDetails {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer cityID;
	  private String cityName;
	  private Integer districtID;
	  private Integer stateID;
	  private Boolean deleted;
	  private String createdBy;
	  private Date createdDate;
	  private String modifiedBy;
	  private Date lastModDate;
	  
	  public CityDetails() {}
	  
	  public CityDetails(Integer CityID, String CityName)
	  {
	    this.cityID = CityID;
	    this.cityName = CityName;
	  }
	  
	  public Integer getCityID()
	  {
	    return this.cityID;
	  }
	  
	  public void setCityID(int cityID)
	  {
	    this.cityID = Integer.valueOf(cityID);
	  }
	  
	  public String getCityName()
	  {
	    return this.cityName;
	  }
	  
	  public void setCityName(String cityName)
	  {
	    this.cityName = cityName;
	  }
	  
	  public Integer getDistrictID()
	  {
	    return this.districtID;
	  }
	  
	  public void setDistrictID(int districtID)
	  {
	    this.districtID = Integer.valueOf(districtID);
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
