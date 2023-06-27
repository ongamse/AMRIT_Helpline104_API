package com.iemr.helpline104.repository.bloodComponent;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.bloodComponent.M_Component;

@Repository
@RestResource(exported = false)
public interface BloodComponentRepository extends CrudRepository<M_Component, Long>{
	@Query("select componentID, component, componentDesc from M_Component where deleted=false and componentID=:ComponentID")
	public List<Objects[]> getBloodComponents(@Param("ComponentID") Integer ComponentID) throws Exception;
}
