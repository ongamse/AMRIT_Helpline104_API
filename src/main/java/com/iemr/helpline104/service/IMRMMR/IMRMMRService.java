package com.iemr.helpline104.service.IMRMMR;

import java.util.List;

import com.iemr.helpline104.data.IMRMMR.IMRMMR;
import com.iemr.helpline104.data.IMRMMR.M_facilities;
import com.iemr.helpline104.data.IMRMMR.M_supportServices;

public interface IMRMMRService {

	public String saveIMRMMR(String request,String Authorization) throws Exception;
	
	public List<M_supportServices> getsupportServices() throws Exception;
	
	public List<M_facilities> getFacilities() throws Exception;

	String updateImrMmrRequest(IMRMMR complaint) throws Exception;
}
