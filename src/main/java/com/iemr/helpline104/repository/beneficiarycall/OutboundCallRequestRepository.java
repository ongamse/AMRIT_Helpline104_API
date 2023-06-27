
package com.iemr.helpline104.repository.beneficiarycall;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.beneficiarycall.OutboundCallRequest;

@Repository
@RestResource(exported = false)
public interface OutboundCallRequestRepository extends CrudRepository<OutboundCallRequest, Long>
{
	
	List <OutboundCallRequest> findByBenCallID (Long benCallID);

}