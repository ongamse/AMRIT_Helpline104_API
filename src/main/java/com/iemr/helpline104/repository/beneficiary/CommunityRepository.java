package com.iemr.helpline104.repository.beneficiary;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.userbeneficiarydata.M_Community;

@Repository
@RestResource(exported = false)
public abstract interface CommunityRepository extends CrudRepository<M_Community, Long> {
	@Query("select CommunityID, CommunityType from M_Community where Deleted = false")
	public abstract Set<Objects[]> findAciveCommunities();
}
