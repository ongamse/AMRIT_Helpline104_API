package com.iemr.helpline104.data.report;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class BloodCompDistrictModel {
	
	private String district;
	private Long totalCount;
	private Long WBC;
	private Long redBloodCells;
	private Long others;
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
	 * @return the wBC
	 */
	public Long getWBC() {
		return WBC;
	}
	/**
	 * @param wBC the wBC to set
	 */
	public void setWBC(Long wBC) {
		WBC = wBC;
	}
	/**
	 * @return the redBloodCells
	 */
	public Long getRedBloodCells() {
		return redBloodCells;
	}
	/**
	 * @param redBloodCells the redBloodCells to set
	 */
	public void setRedBloodCells(Long redBloodCells) {
		this.redBloodCells = redBloodCells;
	}
	/**
	 * @return the others
	 */
	public Long getOthers() {
		return others;
	}
	/**
	 * @param others the others to set
	 */
	public void setOthers(Long others) {
		this.others = others;
	}
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}
}
