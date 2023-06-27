package com.iemr.helpline104.repository.beneficiarycall;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.beneficiarycall.BenCallServicesMappingHistory;

@Repository
@RestResource(exported = false)
public interface ServicesHistoryRepository extends CrudRepository<BenCallServicesMappingHistory, Integer> {

	/*
	@Query("select " + "benCall104ServiceMapID, beneficiaryRegID, benCallID, serviceID104, "
			+ "createdBy, createdDate "
			+ "from BenCallServicesMappingHistory " + "where beneficiaryRegID = :beneficiaryRegID")
	public Set<Objects[]> findBy(@Param("beneficiaryRegID") Long beneficiaryRegID);  */

	/*
	@Query("select " + "b.benCall104ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.serviceID104, b.servicesMaster104, "			
			+ "b.createdBy, b.createdDate  " + "from BenCallServicesMappingHistory b "
			+ "join b.servicesMaster104 sm " 			
			+ "where b.benCallID = :benCallID ")
	public List<Objects[]> getCallSummary(@Param("benCallID") Long benCallID); */

	/*
	@Query("select " + "b.benCall104ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.serviceID104, b.servicesMaster104, "			
			+ "b.createdBy, b.createdDate " + "from BenCallServicesMappingHistory b "
			+ "left join b.servicesMaster104 sm " 			
			+ "where b.beneficiaryRegID = :beneficiaryRegID ")
	public List<Objects[]> findCallDetailsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID); */

	/*
	@Query("select " + "b.benCall104ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.serviceID104, b.servicesMaster104, "
			+ "b.createdBy, b.createdDate " + "from BenCallServicesMappingHistory b "
			+ "left join b.servicesMaster104 sm "			
			+ "where b.beneficiaryRegID = :beneficiaryRegID ")
	public List<Objects[]> findReferralsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID, Pageable page); */

	/*
	@Query("select " + "b.benCall104ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.serviceID104, b.servicesMaster104, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b " + "left join b.servicesMaster104 sm "
			+ "join b.feedbackDetails f " + "where b.beneficiaryRegID = :beneficiaryRegID ")
	public List<Objects[]> findFeedbacksForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID, Pageable page); */

	/*
	@Query("select " + "b.benCall104ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.serviceID104, b.servicesMaster104, "
			+ "b.createdBy, b.createdDate " + "from BenCallServicesMappingHistory b "
			+ "join b.servicesMaster104 sm " 
			+ "where b.beneficiaryRegID = :beneficiaryRegID ")
	public List<Objects[]> findInformationsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			Pageable page); */
	
}
