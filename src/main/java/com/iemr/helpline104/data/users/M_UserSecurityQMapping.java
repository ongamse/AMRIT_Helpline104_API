package com.iemr.helpline104.data.users;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table(name = "m_usersecurityqamapping")
public class M_UserSecurityQMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long UserSecurityQAID;
	private Long UserID;
	
	@Column(name = "QuestionID")
	private String QuestionID;

	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "QuestionID")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "QuestionID", insertable = false, updatable = false)
	private M_LoginSecurityQuestions m_LoginSecurityQuestions;

	private String Answers;
	private String MobileNumber;
	private Boolean Deleted;
	private String CreatedBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date CreatedDate;
	private String ModifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date LastModDate;

	protected M_UserSecurityQMapping() {
	}

	public M_UserSecurityQMapping(Long userSecurityQAID, Long userID, String questionID,
			M_LoginSecurityQuestions m_LoginSecurityQuestions, String answers, String mobileNumber, Boolean deleted,
			String createdBy, Date createdDate, String modifiedBy, Date lastModDate) {
		super();
		UserSecurityQAID = userSecurityQAID;
		UserID = userID;
		QuestionID = questionID;
		this.m_LoginSecurityQuestions = m_LoginSecurityQuestions;
		this.Answers = answers;
		this.MobileNumber = mobileNumber;
		this.Deleted = deleted;
		this.CreatedBy = createdBy;
		this.CreatedDate = createdDate;
		this.ModifiedBy = modifiedBy;
		this.LastModDate = lastModDate;
	}

	public Long getUserSecurityQAID() {
		return this.UserSecurityQAID;
	}

	public Long getUserID() {
		return this.UserID;
	}

	public M_LoginSecurityQuestions getM_LoginSecurityQuestions() {
		return this.m_LoginSecurityQuestions;
	}

	public String getAnswers() {
		return this.Answers;
	}

	public String getMobileNumber() {
		return this.MobileNumber;
	}

	public Boolean getDeleted() {
		return this.Deleted;
	}

	public String getCreatedBy() {
		return this.CreatedBy;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public String getModifiedBy() {
		return this.ModifiedBy;
	}

	public Date getLastModDate() {
		return LastModDate;
	}

	public void setUserSecurityQAID(Long userSecurityQAID) {
		UserSecurityQAID = userSecurityQAID;
	}

	public void setUserID(Long userID) {
		UserID = userID;
	}

	public void setM_LoginSecurityQuestions(M_LoginSecurityQuestions m_LoginSecurityQuestions) {
		this.m_LoginSecurityQuestions = m_LoginSecurityQuestions;
	}

	public void setAnswers(String answers) {
		Answers = answers;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public void setDeleted(Boolean deleted) {
		Deleted = deleted;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}

	public void setLastModDate(Date lastModDate) {
		LastModDate = lastModDate;
	}

	public String getQuestionID() {
		return QuestionID;
	}

	public void setQuestionID(String questionID) {
		QuestionID = questionID;
	}
}
