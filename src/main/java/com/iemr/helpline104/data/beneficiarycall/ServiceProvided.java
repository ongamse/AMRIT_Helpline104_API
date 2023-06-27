package com.iemr.helpline104.data.beneficiarycall;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_serviceprovided")
public class ServiceProvided {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private  Long  ServiceID;

	@Expose
	private String InformationService;
	@Expose
	private String CounsellingService;
	@Expose
	private String ReferralService;
	@Expose
	private String FeedbackSystem;
	
	public ServiceProvided() {
		super();
	}
	
	public ServiceProvided( Long  serviceID, String informationService, String counsellingService,
			String referralService, String feedbackSystem) {
		super();
		ServiceID = serviceID;
		InformationService = informationService;
		CounsellingService = counsellingService;
		ReferralService = referralService;
		FeedbackSystem = feedbackSystem;
	}

	public  Long  getServiceID() {
		return ServiceID;
	}

	public void setServiceID( Long  serviceID) {
		ServiceID = serviceID;
	}

	public String getInformationService() {
		return InformationService;
	}

	public void setInformationService(String informationService) {
		InformationService = informationService;
	}

	public String getCounsellingService() {
		return CounsellingService;
	}

	public void setCounsellingService(String counsellingService) {
		CounsellingService = counsellingService;
	}

	public String getReferralService() {
		return ReferralService;
	}

	public void setReferralService(String referralService) {
		ReferralService = referralService;
	}

	public String getFeedbackSystem() {
		return FeedbackSystem;
	}

	public void setFeedbackSystem(String feedbackSystem) {
		FeedbackSystem = feedbackSystem;
	}

	@Override
	public String toString() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		gsonBuilder.serializeNulls().setLongSerializationPolicy(LongSerializationPolicy.STRING);
		String tostring = gsonBuilder.create().toJson(this);
		return tostring;
	}
}
