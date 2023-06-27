package com.iemr.helpline104.repository.bloodRequest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.bloodRequest.RequestedBloodBank;

@Repository
@RestResource(exported = false)
public interface RequestedBloodBankRepository extends CrudRepository<RequestedBloodBank, Long>
{
	
	public List<RequestedBloodBank> findByBloodReqIDAndDeleted(Long bloodReqID, Boolean deleted);

}
