package com.iemr.helpline104.repository.userbeneficiarydata;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.userbeneficiarydata.M_Religion;

@Repository
@RestResource(exported = false)
public abstract interface ReligionRepository extends CrudRepository<M_Religion, Long> {
	@Query("select ReligionID, ReligionType, ReligionDesc from M_Religion where Deleted = false")
	public abstract List<Objects[]> getActiveReligions();
}
