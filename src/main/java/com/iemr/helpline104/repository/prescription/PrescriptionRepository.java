package com.iemr.helpline104.repository.prescription;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.prescription.Prescription;

@Repository
@RestResource(exported = false)
public interface PrescriptionRepository extends CrudRepository<Prescription, Long>{
	
	/*
	@Query("select p.beneficiaryRegID,p.benCallID,p.diagnosisProvided,p.drugID,d.drugName,p.dosage,p.drugUsage,p.noOfDays, "
			+ "p.timeToConsume,p.sideEffects,p.remarks "
			+ " from Prescription p "
			+ " RIGHT JOIN p.m_drugMaster d "
			+ "where d.deleted = false and p.beneficiaryRegID=:beneficiaryRegID and p.prescriptionID=:prescriptionID")
	public List<Objects[]> getPrescription(@Param("beneficiaryRegID") Long beneficiaryRegID, @Param("prescriptionID") Long prescriptionID); 
	
	@Query("select p.beneficiaryRegID,p.benCallID,p.diagnosisProvided,p.drugID,d.drugName,p.dosage,p.drugUsage,p.noOfDays, "
			+ "p.timeToConsume,p.sideEffects,p.remarks "
			+ " from Prescription p "
			+ " RIGHT JOIN p.m_drugMaster d "
			+ "where d.deleted = false and p.beneficiaryRegID=:beneficiaryRegID") */
	
	@Query("select p.prescriptionID,p.beneficiaryRegID,p.benCallID,p.diagnosisProvided,p.remarks,p.createdDate "			
			+ " from Prescription p "			
			+ "where p.deleted = false and p.beneficiaryRegID=:beneficiaryRegID")
	public List<Objects[]> getPrescriptionList(@Param("beneficiaryRegID") Long beneficiaryRegID,Pageable pageable);
	
	@Query("select p.prescriptionID,p.beneficiaryRegID,p.benCallID,p.diagnosisProvided,p.remarks,p.createdDate "			
			+ " from Prescription p "			
			+ "where p.deleted = false and p.benCallID=:benCallID")
	public List<Objects[]> getPrescriptionListByBenCallID(@Param("benCallID") Long benCallID);
	
	/*
	@Query("select p.beneficiaryRegID,p.benCallID,p.diagnosisProvided,p.drugID,d.drugName,p.dosage,p.drugUsage,p.noOfDays, "
			+ "p.timeToConsume,p.sideEffects,p.remarks "
			+ " from Prescription p "
			+ " RIGHT JOIN p.m_drugMaster d "
			+ "where d.deleted = false and p.beneficiaryRegID=:beneficiaryRegID and DATE(p.createdDate) between adddate(now(),-5) and now() order by p.prescriptionID DESC")
	public List<Objects[]> getLatestValidPescription(@Param("beneficiaryRegID") Long beneficiaryRegID,Pageable pageable); */
	
	@Query("select p.prescriptionID,p.beneficiaryRegID,p.benCallID,p.diagnosisProvided,p.remarks,p.createdDate "			
			+ " from Prescription p "			
			+ "where p.deleted = false and p.beneficiaryRegID=:beneficiaryRegID and DATE(p.createdDate) between adddate(now(),-30) and now() order by p.prescriptionID DESC")
	public List<Objects[]> getLatestValidPescription(@Param("beneficiaryRegID") Long beneficiaryRegID,Pageable pageable);
	
	
	
}
