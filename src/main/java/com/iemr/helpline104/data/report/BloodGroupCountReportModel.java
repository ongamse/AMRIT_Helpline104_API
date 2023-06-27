package com.iemr.helpline104.data.report;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class BloodGroupCountReportModel {

	private String group;
	private Long count;
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}
	
}
