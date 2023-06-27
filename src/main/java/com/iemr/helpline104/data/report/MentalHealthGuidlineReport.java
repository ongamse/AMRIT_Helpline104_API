package com.iemr.helpline104.data.report;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class MentalHealthGuidlineReport {
	
	private String guidelines;
	private Long count;
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}

	/**
	 * @return the guidelines
	 */
	public String getGuidelines() {
		return guidelines;
	}

	/**
	 * @param guidelines the guidelines to set
	 */
	public void setGuidelines(String guidelines) {
		this.guidelines = guidelines;
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
