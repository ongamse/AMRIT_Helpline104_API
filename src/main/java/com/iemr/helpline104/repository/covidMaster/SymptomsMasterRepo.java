package com.iemr.helpline104.repository.covidMaster;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.covidMaster.SymptomsMaster;


@Repository
@RestResource(exported = false)
public interface SymptomsMasterRepo extends CrudRepository<SymptomsMaster, Integer>{
//	ArrayList<SymptomsMaster> findByDeleted(Boolean deleted);
	
	@Query("SELECT c FROM SymptomsMaster c where c.deleted != 1 and c.masterType= :covidId")
	
	public SymptomsMaster getMaster(@Param("covidId") String covidId);

} 