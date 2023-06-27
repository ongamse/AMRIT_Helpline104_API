package com.iemr.helpline104.data.report;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class MedicalAdviseDiseaseReport {

	private String diseaseSummary;
	private Long count;
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}

	/**
	 * @return the diseaseSummary
	 */
	public String getDiseaseSummary() {
		return diseaseSummary;
	}

	/**
	 * @param diseaseSummary the diseaseSummary to set
	 */
	public void setDiseaseSummary(String diseaseSummary) {
		this.diseaseSummary = diseaseSummary;
	}

	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}
}
