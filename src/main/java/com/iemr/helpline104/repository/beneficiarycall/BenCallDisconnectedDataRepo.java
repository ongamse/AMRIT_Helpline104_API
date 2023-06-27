package com.iemr.helpline104.repository.beneficiarycall;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.beneficiarycall.BenCallDisconnectedData;



@Repository
@RestResource(exported = false)
public interface BenCallDisconnectedDataRepo extends CrudRepository<BenCallDisconnectedData, Long> {

}
