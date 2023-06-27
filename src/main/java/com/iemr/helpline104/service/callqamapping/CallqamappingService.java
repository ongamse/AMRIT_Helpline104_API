package com.iemr.helpline104.service.callqamapping;

import java.util.List;

import com.iemr.helpline104.data.bloodRequest.T_BloodRequest;
import com.iemr.helpline104.data.callqamapping.CallqaMappings;
import com.iemr.helpline104.data.callqamapping.M_104callqamapping;

public interface CallqamappingService {
	
	public List<M_104callqamapping> save(CallqaMappings callqaMappings) throws Exception;
	
	public List<M_104callqamapping> getCDIQuestionScores(M_104callqamapping m_104callqamapping) throws Exception;
}
