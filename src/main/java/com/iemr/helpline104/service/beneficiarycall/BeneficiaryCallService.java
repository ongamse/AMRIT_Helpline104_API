package com.iemr.helpline104.service.beneficiarycall;

import java.util.List;


import com.iemr.helpline104.data.beneficiarycall.BeneficiaryCall;

public interface BeneficiaryCallService {
	//List<BeneficiaryCall> addCalltype(Long benificiaryCallId);
	
	//List<BeneficiaryCall> getBeneficiaryCallsHistory (Long benificiaryCallId, Integer pageNo, Integer rows);
	
	//List<BeneficiaryCall> getCallSummaryByCallID (Long benCallID);

	BeneficiaryCall createCall(BeneficiaryCall beneficiaryCall);

	//Integer closeCall(String beneficiaryCall);
	
	Integer updateBeneficiaryIDInCall(Long benCallID,Long beneficiaryRegID);
	
	// List<BeneficiaryCall> findBeneficiaryByCallID (String benCallID, Integer pageNo, Integer rows);
}
