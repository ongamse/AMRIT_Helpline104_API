package com.iemr.helpline104.repository.organDonation;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.organDonation.RequestedInstitution;

@Repository
@RestResource(exported = false)
public interface RequestedInstitutionRepository extends CrudRepository<RequestedInstitution, Long>
{
	
	public List<RequestedInstitution> findByOrganDonationIDAndDeleted(Long organDonationID, Boolean deleted);

}
