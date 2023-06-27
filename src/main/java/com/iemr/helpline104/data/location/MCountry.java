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
@Table(name="m_country")
public class MCountry {

	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Expose
	  @Column(name = "CountryID")
	  private Integer countryID;

	  @Expose
	  @Column(name = "CountryName")
	  private String countryName;

	  @Expose
	  @Column(name = "Deleted")
	  private Boolean deleted;
	  
	  @Expose
	  @Column(name = "CreatedBy")
	  private String createdBy;
	  
	  @Expose
	  @Column(name = "CreatedDate",updatable = false, insertable = false)
	  private Date CreatedDate;
	  
	  @Expose
	  @Column(name = "ModifiedBy")
	  private String modifiedBy;
	  
	  @Expose
	  @Column(name = "LastModDate",updatable = false, insertable = false)
	  private Date lastModDate;
	  
	  public MCountry() {}
	  
	  public String toString()
	  {
	    return new Gson().toJson(this);
	  }
}
