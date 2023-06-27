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

import com.google.gson.Gson;
import com.iemr.helpline104.data.users.M_UserDemographics;

@Entity
@Table(name="m_community")
public class M_Community
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer CommunityID;
  /*@OneToMany(fetch=FetchType.LAZY, mappedBy="m_community")
  private Set<I_BenDemographics> i_bendemographics;*/
  @OneToMany(fetch=FetchType.LAZY, mappedBy="m_community")
  private Set<M_UserDemographics> m_userdemographics;
  private String CommunityType;
  private String CommunityDesc;
  private Boolean Deleted;
  private String CreatedBy;
  private Date CreatedDate;
  private String ModifiedBy;
  private Date LastModDate;
  
  protected M_Community() {}
  
  public M_Community(int communityID, String communityType, String communityDesc)
  {
    this.CommunityID = Integer.valueOf(communityID);
    this.CommunityType = communityType;
    this.CommunityDesc = communityDesc;
  }
  
  public M_Community(int communityID, String communityType)
  {
    this.CommunityID = Integer.valueOf(communityID);
    this.CommunityType = communityType;
  }
  
  public String toString()
  {
    return new Gson().toJson(this);
  }
}
