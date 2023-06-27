package com.iemr.helpline104.repository.beneficiarycall;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.beneficiarycall.BenCall;

@Repository
@RestResource(exported = false)
public interface BenCallRepository extends CrudRepository<BenCall, Long>
{

	public BenCall findByBenCallID(@Param("benCallID") Long benCallID);

}
