package com.iemr.helpline104.service.casesheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.iemr.helpline104.data.casesheet.COVIDHistory;
import com.iemr.helpline104.data.casesheet.H104BenMedHistory;

public interface H104BenHistoryService {
	
	//ArrayList<Objects[]> geSmpleBenHistory(Long beneficiaryId, Long benCallID);	H104BenMedHistory
	
	List<H104BenMedHistory> geSmpleBenHistory(Long beneficiaryId, Long benCallID);	
	
	List<H104BenMedHistory> getPresentCasesheet(Long beneficiaryId, String callID);
	
	H104BenMedHistory saveSmpleBenHistory(H104BenMedHistory smpleBenHistory,COVIDHistory covidHistory);

}
