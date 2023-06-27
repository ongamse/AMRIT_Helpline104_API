package com.iemr.helpline104.data.location;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.iemr.helpline104.data.users.M_UserDemographics;

@Entity
@Table(name="m_country")
public class Country
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer CountryID;
  //@OneToMany(fetch=FetchType.LAZY, mappedBy="m_country")
  //private Set<I_BenDemographics> i_bendemographics;
  @OneToMany(fetch=FetchType.LAZY, mappedBy="m_country")
  private Set<M_UserDemographics> m_userdemographics;
  private String CountryName;
  private String CountryCode;
  private String Continent;
  private Boolean Deleted;
  private String CreatedBy;
  private Date CreatedDate;
  private String ModifiedBy;
  private Date LastModDate;
  
  protected Country() {}
  
  public Country(int countryID, String countryName, String countryCode, String Continent)
  {
    this.CountryID = Integer.valueOf(countryID);
    this.CountryName = countryName;
    this.CountryCode = countryCode;
    this.Continent = Continent;
  }
  
  public Country(int countryID, String countryName)
  {
    this.CountryID = Integer.valueOf(countryID);
    this.CountryName = countryName;
  }
  
  public String toString()
  {
    return new Gson().toJson(this);
  }
}
