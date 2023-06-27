package com.iemr.helpline104.data.location;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.iemr.helpline104.data.institute.Institute;

@Entity
@Table(name = "m_state")
public class States {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer stateID;
	  private String stateName;
	  private String stateCode;
	  private Integer countryID;
	  private Boolean deleted;
	  private String createdBy;
	  private String modifiedBy;
	  private Date createdDate;
	  private Date lastModDate;
	  @OneToMany(fetch=FetchType.LAZY, mappedBy="states")
	  private List<Districts> districts;
//	  @OneToMany(fetch=FetchType.LAZY, mappedBy="states")
//	  private Set<Institute> institutes;
	  
	  public States() {}
	  
	  public States(int StateID, String StateName)
	  {
	    this.stateID = Integer.valueOf(StateID);
	    this.stateName = StateName;
	  }
	  
	  public int getStateID()
	  {
	    return this.stateID.intValue();
	  }
	  
	  public void setStateID(int stateID)
	  {
	    this.stateID = Integer.valueOf(stateID);
	  }
	  
	  public String getStateIName()
	  {
	    return this.stateName;
	  }
	  
	  public void setStateIName(String stateName)
	  {
	    this.stateName = stateName;
	  }
	  
	  public String getStateCode()
	  {
	    return this.stateCode;
	  }
	  
	  public void setStateCode(String stateCode)
	  {
	    this.stateCode = stateCode;
	  }
	  
	  public int getCountryID()
	  {
	    return this.countryID.intValue();
	  }
	  
	  public void setCountryID(int countryID)
	  {
	    this.countryID = Integer.valueOf(countryID);
	  }
	  
	  public boolean isDeleted()
	  {
	    return this.deleted.booleanValue();
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
	  
	  public String getModifiedBy()
	  {
	    return this.modifiedBy;
	  }
	  
	  public void setModifiedBy(String modifiedBy)
	  {
	    this.modifiedBy = modifiedBy;
	  }
	  
	  public Date getCreatedDate()
	  {
	    return this.createdDate;
	  }
	  
	  public void setCreatedDate(Date createdDate)
	  {
	    this.createdDate = createdDate;
	  }
	  
	  public Date getLastModDate()
	  {
	    return this.lastModDate;
	  }
	  
	  public void setLastModDate(Date lastModDate)
	  {
	    this.lastModDate = lastModDate;
	  }
	  
	  public String getStateName()
	  {
	    return this.stateName;
	  }
	  
	  public void setStateName(String stateName)
	  {
	    this.stateName = stateName;
	  }
	  
	  public String toString()
	  {
	    return new Gson().toJson(this);
	  }
	  
	  public List<Districts> getDistricts() {
		return districts;
	  }

	  public void setDistricts(List<Districts> districts) {
		this.districts = districts;
	  }
}
