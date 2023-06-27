package com.iemr.helpline104.service.balVivah;

import javax.servlet.http.HttpServletRequest;

import com.iemr.helpline104.data.balVivah.BalVivahComplaint;

public interface BalVivahComplaintService {

//	public String saveBalVivahComplaint(HttpServletRequest httpRequest) throws Exception;

	String getWorklistRequests(Long beneficiaryRegID, String phoneNo, String requestID) throws Exception;

	public String save(BalVivahComplaint balVivahComplaint, HttpServletRequest httpRequest) throws Exception;

	public String updateBalVivahRequest(BalVivahComplaint balVivahComplaint) throws Exception;
}
