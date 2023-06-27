package com.iemr.helpline104.repository.bloodComponentType;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.bloodComponentType.M_ComponentType;

@Repository
@RestResource(exported = false)
public interface BloodComponentTypeRepository extends CrudRepository<M_ComponentType, Long>{
	@Query("select componentTypeID, componentType, componentTypeDesc from M_ComponentType where deleted=false")
	public List<Objects[]> getComponentTypes() throws Exception;
	
	@Query("select bloodGroupID, bloodGroup, bloodGroupDesc from M_BloodGroup where deleted=false")
	public List<Objects[]> getBloodGroups() throws Exception;
}
