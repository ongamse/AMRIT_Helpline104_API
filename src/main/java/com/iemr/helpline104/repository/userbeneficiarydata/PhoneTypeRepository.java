package com.iemr.helpline104.repository.userbeneficiarydata;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.userbeneficiarydata.M_PhoneType;

@Repository
@RestResource(exported = false)
public interface PhoneTypeRepository extends CrudRepository<M_PhoneType, Long>{
	
	@Query("select phoneTypeID, phoneType from M_PhoneType where deleted = false")
	public ArrayList<Objects[]> findAcivePhoneTypes();
}
