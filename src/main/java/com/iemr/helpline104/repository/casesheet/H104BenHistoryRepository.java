package com.iemr.helpline104.repository.casesheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.casesheet.H104BenMedHistory;

@Repository
@RestResource(exported = false)
public interface H104BenHistoryRepository extends CrudRepository<H104BenMedHistory, Long> {
	
	/*
	@Query("select u from H104BenMedHistory u where u.beneficiaryRegID = :BeneficiaryRegID")
	public ArrayList<Objects[]> getBenHistory(@Param("BeneficiaryRegID") Long BeneficiaryRegID); */
	
	/*
	@Query("select u from H104BenMedHistory LEFT JOIN u.m_gender g where u.benCallID = :benCallID")
	public ArrayList<Objects[]> getHistoryByBenCallID(@Param("benCallID") Long benCallID); */
	
	@Query("select u from H104BenMedHistory u where u.beneficiaryRegID = :BeneficiaryRegID order by u.benHistoryID desc")
	public List<H104BenMedHistory> getBenHistory(@Param("BeneficiaryRegID") Long BeneficiaryRegID); 
	
	
	public List<H104BenMedHistory> findByBenCallID(@Param("benCallID") Long benCallID);
	
	@Query("select u from H104BenMedHistory u where u.beneficiaryRegID = :BeneficiaryRegID order by u.benHistoryID desc")
	List<H104BenMedHistory> getPresentBenHistory(@Param("BeneficiaryRegID") Long BeneficiaryRegID,Pageable pageable);
	            
}
