package com.iemr.helpline104.repository.userbeneficiarydata;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.userbeneficiarydata.M_Status;

@Repository
@RestResource(exported = false)
public abstract interface StatusRepository extends CrudRepository<M_Status, Long> {
	@Query("select StatusID, Status from M_Status where Deleted = false")
	public abstract Set<Objects[]> findAciveStatus();
}
