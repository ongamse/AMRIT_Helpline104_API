package com.iemr.helpline104.service.covidMaster;

public interface CovidMasterService {
	
	public String getMaster(Integer providerServiceMapID);
	
	public String saveCovidData(String requestObj) throws Exception;

}
