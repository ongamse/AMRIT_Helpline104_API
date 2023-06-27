package com.iemr.helpline104.service.bloodRequest;

import java.util.List;

import com.iemr.helpline104.data.bloodRequest.BloodBank;
import com.iemr.helpline104.data.bloodRequest.T_BloodRequest;

public interface BloodRequestService {

	List<T_BloodRequest> getBloodRequest(Long benificiaryRegID, String bloodReqID, Long benCallID) throws Exception;
	
	public T_BloodRequest save(T_BloodRequest t_bloodRequest) throws Exception;	
	
	/*public T_BloodOutboundDetails save(T_BloodOutboundDetails t_bloodOutboundDetails) throws Exception; */
	
	/*public Integer updateBloodOutBoundDetails(T_BloodOutboundDetails t_bloodOutboundDetails) throws Exception;*/

	/*public List<T_BloodOutboundDetails> getBloodOutBoundDetails(T_BloodOutboundDetails t_bloodOutboundDetails) throws Exception; */
	
	public BloodBank getBloodBankURL(String bloodBankName) throws Exception;
	
	public BloodBank saveBloodBankURL(BloodBank bloodBank) throws Exception;
	
}
