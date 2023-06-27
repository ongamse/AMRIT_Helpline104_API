package com.iemr.helpline104.repository.drugGroup;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.drugMaster.DrugFrequency;

@Repository
@RestResource(exported = false)
public interface DrugFrequencyRepository extends CrudRepository<DrugFrequency, Long> {
	
	/* @Query("select u.drugFrequencyID, u.frequency from DrugFrequency u where u.deleted=false") */
	@Query("select u from DrugFrequency u where u.deleted=false")
	public ArrayList<Objects[]> getDrugFrequency();

}
