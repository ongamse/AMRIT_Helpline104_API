package com.iemr.helpline104.repository.scheme;


import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.scheme.T_Schemeservice;

@Repository
@RestResource(exported = false)
public interface SchemeRepository extends CrudRepository<T_Schemeservice, Long>{

	public List<T_Schemeservice> findByBeneficiaryRegID(@Param("BeneficiaryRegID") Long BeneficiaryRegID);
	public List<T_Schemeservice> findByBenCallID(@Param("benCallID") Long benCallID);

}
