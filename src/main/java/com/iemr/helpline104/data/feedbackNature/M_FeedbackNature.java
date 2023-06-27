package com.iemr.helpline104.data.feedbackNature;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

@Entity
@Table(name="M_FeedbackNature")
public class M_FeedbackNature {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedbackNatureID;
	@Expose
	private String feedbackNature;
	@Expose
	private String feedbackNatureDesc;
	@Expose
	private Short feedbackTypeID;
	private Boolean deleted;
	private String modifiedBy;
	private String createdBy;
	
	public M_FeedbackNature(Integer feedbackNatureID, String feedbackNature, String feedbackNatureDesc) {
		super();
		this.feedbackNatureID = feedbackNatureID;
		this.feedbackNature = feedbackNature;
		this.feedbackNatureDesc = feedbackNatureDesc;
	}

	public M_FeedbackNature() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFeedbackNature() {
		return feedbackNature;
	}

	public void setFeedbackNature(String feedbackNature) {
		this.feedbackNature = feedbackNature;
	}

	public String getFeedbackNatureDesc() {
		return feedbackNatureDesc;
	}

	public void setFeedbackNatureDesc(String feedbackNatureDesc) {
		this.feedbackNatureDesc = feedbackNatureDesc;
	}

	public Short getFeedbackTypeID() {
		return feedbackTypeID;
	}

	public void setFeedbackTypeID(Short feedbackTypeID) {
		this.feedbackTypeID = feedbackTypeID;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getFeedbackNatureID() {
		return feedbackNatureID;
	}
	
	public String toString() {
		return new Gson().toJson(this);
	}
}
