package com.iemr.helpline104.service.prescription;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.iemr.helpline104.data.prescription.Prescription;


public interface PrescriptionService {
	
	Prescription savePrescription(Prescription t_prescription);

	List<Prescription> getPrescription(Long beneficiaryRegID, Long prescriptionID);
	
	List<Prescription> getPrescriptionList(Long beneficiaryRegID,Pageable pageable);
	
	List<Prescription> getPrescriptionListByBenCallID(Long benCallID);	
	
    List<Prescription> getLatestValidPescription(Long beneficiaryRegID,Pageable pageable);
	
}
