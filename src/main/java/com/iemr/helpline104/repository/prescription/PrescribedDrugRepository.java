package com.iemr.helpline104.repository.prescription;


import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.prescription.PrescribedDrug;

@Repository
@RestResource(exported = false)
public interface PrescribedDrugRepository extends CrudRepository<PrescribedDrug, Long>{
	
	@Query("select p.prescribedDrugID,p.drugMapID,d.drugName,p.drugForm,p.drugRoute,p.frequency,p.dosage,p.noOfDays, "
			+ "p.timeToConsume,p.sideEffects,p.validTill "
			+ " from PrescribedDrug p "
			+ " RIGHT JOIN p.m_104drugmapping d "
			+ "where d.deleted = false and p.prescriptionID=:prescriptionID") 	
	public List<Objects[]> getPrescribedDrugs(@Param("prescriptionID") Long prescriptionID);
	
	
	
	
}
