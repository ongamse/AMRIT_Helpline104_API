package com.iemr.helpline104.data.report;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;


public class BloodOnRequestCountModel {

	private String componentType;
	private Long count;

	/**
	 * @return the componentType
	 */
	public String getComponentType() {
		return componentType;
	}


	/**
	 * @param componentType the componentType to set
	 */
	public void setComponentType(String componentType) {
		this.componentType = componentType;
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
	
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}

}
