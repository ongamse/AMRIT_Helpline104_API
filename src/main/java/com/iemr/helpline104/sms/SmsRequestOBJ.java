package com.iemr.helpline104.sms;

import java.sql.Timestamp;

public class SmsRequestOBJ {
	private Long beneficiaryRegID;
	private Integer smsTemplateID;
 private Integer smsTemplateTypeID;
 private String smsType;
 private String nodalNumber;
 private Integer stateID;
 private String imrDate;
 private String createdBy;
 private String imrID;
 private String informerName;
 public String getInformerName() {
	return informerName;
}
public void setInformerName(String informerName) {
	this.informerName = informerName;
}
public String getSmsType() {
	return smsType;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public void setSmsType(String smsType) {
	this.smsType = smsType;
}
public Long getBeneficiaryRegID() {
	return beneficiaryRegID;
}
public void setBeneficiaryRegID(Long beneficiaryRegID) {
	this.beneficiaryRegID = beneficiaryRegID;
}
public Integer getSmsTemplateID() {
	return smsTemplateID;
}
public void setSmsTemplateID(Integer smsTemplateID) {
	this.smsTemplateID = smsTemplateID;
}
public Integer getSmsTemplateTypeID() {
	return smsTemplateTypeID;
}
public void setSmsTemplateTypeID(Integer smsTemplateTypeID) {
	this.smsTemplateTypeID = smsTemplateTypeID;
}
public String getNodalNumber() {
	return nodalNumber;
}
public void setNodalNumber(String nodalNumber) {
	this.nodalNumber = nodalNumber;
}
public Integer getStateID() {
	return stateID;
}
public void setStateID(Integer stateID) {
	this.stateID = stateID;
}
public String getImrDate() {
	return imrDate;
}
public void setImrDate(String imrDate) {
	this.imrDate = imrDate;
}
public String getImrID() {
	return imrID;
}
public void setImrID(String imrID) {
	this.imrID = imrID;
}

}
