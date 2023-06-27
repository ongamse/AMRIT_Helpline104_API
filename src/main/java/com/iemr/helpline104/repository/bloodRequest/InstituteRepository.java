package com.iemr.helpline104.repository.bloodRequest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.bloodRequest.BloodBank;

@Repository
@RestResource(exported = false)
public interface InstituteRepository extends CrudRepository<BloodBank, Long> {
	@Query("select u from BloodBank u where u.institutionName = :institutionName ")
	public BloodBank findBloodBankURL(@Param("institutionName") String institutionName);

	@Query("select institutionName from BloodBank  where institutionID = :institutionID")
	public String getInstituteName(@Param("institutionID") Integer institutionID);

}
