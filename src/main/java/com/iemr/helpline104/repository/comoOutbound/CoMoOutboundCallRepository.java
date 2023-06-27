package com.iemr.helpline104.repository.comoOutbound;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.comoOutbound.T_104CoMoOutboundCallDetails;

@Repository
@RestResource(exported = false)
public interface CoMoOutboundCallRepository extends CrudRepository<T_104CoMoOutboundCallDetails, Long>{

	@Transactional
	@Modifying
	@Query("update T_104CoMoOutboundCallDetails set czentrixCallID = :czentrixCallID WHERE iD = :iD")
	public Integer update(@Param("iD") Long iD, @Param("czentrixCallID") String czentrixCallID);
}
