package com.iemr.helpline104.data.users;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_userqualification")
public class M_UserQualification
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer QualificationID;
  private String Name;
  private String UserQualificationDesc;
  private Boolean Deleted;
  private String CreatedBy;
  private Date CreatedDate;
  private String ModifiedBy;
  private Date LastModDate;
  
  public M_UserQualification() {}
  
  public M_UserQualification(int QualificationID, String Name)
  {
    this.QualificationID = Integer.valueOf(QualificationID);
    this.Name = Name;
  }
}
