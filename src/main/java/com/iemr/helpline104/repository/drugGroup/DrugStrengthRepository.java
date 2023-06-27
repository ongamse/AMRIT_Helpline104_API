package com.iemr.helpline104.repository.drugGroup;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.drugMaster.DrugStrength;

@Repository
@RestResource(exported = false)
public interface DrugStrengthRepository extends CrudRepository<DrugStrength, Long> {	
	
	@Query("select u from DrugStrength u where u.deleted=false and u.serviceProviderID=:serviceProviderID")
	public ArrayList<Objects[]> getDrugStrength(@Param("serviceProviderID") Integer serviceProviderID);

}
