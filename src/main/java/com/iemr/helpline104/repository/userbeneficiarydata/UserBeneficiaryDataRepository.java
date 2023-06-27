package com.iemr.helpline104.repository.userbeneficiarydata;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.userbeneficiarydata.M_Gender;

@Repository
@RestResource(exported = false)
public interface UserBeneficiaryDataRepository extends CrudRepository<M_Gender, Long> {
	@Query("select genderID, genderName from M_Gender where deleted = false")
	Set<Objects[]> findActiveGenders();
}
