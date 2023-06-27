package com.iemr.helpline104.repository.userbeneficiarydata;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.userbeneficiarydata.M_Community;
import com.iemr.helpline104.data.userbeneficiarydata.M_Gender;
import com.iemr.helpline104.data.userbeneficiarydata.M_MaritalStatus;

@Repository
@RestResource(exported = false)
public abstract interface MaritalStatusRepository extends CrudRepository<M_MaritalStatus, Long> {
	@Query("select MaritalStatusID, Status from M_MaritalStatus where Deleted = false")
	public abstract Set<Objects[]> findAciveMaritalStatus();
}
