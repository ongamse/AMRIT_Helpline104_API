package com.iemr.helpline104.service.cdss;

import java.util.List;

import com.iemr.helpline104.data.cdss.SymptomsWrapper;

public interface CDSSService {
	List<String> getSymptoms();

	List<String> getSymptoms(SymptomsWrapper symptomsDetails);

	
}
