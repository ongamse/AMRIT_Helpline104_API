package com.iemr.helpline104.service.disease;

import com.iemr.helpline104.utils.exception.IEMRException;

public interface DiseaseService {

	String saveDisease(String request);

	String deleteDisease(String request);

	String getDisease(String request) throws IEMRException;

	String updateDisease(String request) throws IEMRException;

	String getAvailableDiseases() throws IEMRException;

	String getDiseasesByID(String request) throws IEMRException;

}
