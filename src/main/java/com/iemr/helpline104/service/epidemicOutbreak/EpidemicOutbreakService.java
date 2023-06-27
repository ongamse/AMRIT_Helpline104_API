package com.iemr.helpline104.service.epidemicOutbreak;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iemr.helpline104.data.epidemicOutbreak.T_EpidemicOutbreak;

public interface EpidemicOutbreakService {

	List<T_EpidemicOutbreak> getEpidemicOutbreakComplaints(Long benificiaryRegID, Long benCallID, String requestID,
			String phoneNo) throws Exception;

	public T_EpidemicOutbreak save(T_EpidemicOutbreak t_epidemicOutbreak, HttpServletRequest request) throws Exception;

	public String UpdateEpidemicOutbreakRequest(T_EpidemicOutbreak epidemicOutbreakComplaint) throws Exception;
}
