package com.iemr.helpline104.repository.location;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.location.States;

@Repository
@RestResource(exported = false)
public interface LocationStateRepository extends CrudRepository<States, Integer> {

	@Query("select stateID, stateName from States where countryID = :id")
	public ArrayList<Objects[]> findBy(@Param("id") int id);

}
