package com.iemr.helpline104.data.report;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class BloodGroupDistrictModel {

	private String district;
	private Long totalCount;
	private Long APositive;
	private Long ANegative;
	private Long BPositive;
	private Long BNegative;
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * @return the totalCount
	 */
	public Long getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * @return the aPositive
	 */
	public Long getAPositive() {
		return APositive;
	}
	/**
	 * @param aPositive the aPositive to set
	 */
	public void setAPositive(Long aPositive) {
		APositive = aPositive;
	}
	/**
	 * @return the aNegative
	 */
	public Long getANegative() {
		return ANegative;
	}
	/**
	 * @param aNegative the aNegative to set
	 */
	public void setANegative(Long aNegative) {
		ANegative = aNegative;
	}
	/**
	 * @return the bPositive
	 */
	public Long getBPositive() {
		return BPositive;
	}
	/**
	 * @param bPositive the bPositive to set
	 */
	public void setBPositive(Long bPositive) {
		BPositive = bPositive;
	}
	/**
	 * @return the bNegative
	 */
	public Long getBNegative() {
		return BNegative;
	}
	/**
	 * @param bNegative the bNegative to set
	 */
	public void setBNegative(Long bNegative) {
		BNegative = bNegative;
	}
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}
}
