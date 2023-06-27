package com.iemr.helpline104.repository.casesheet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.casesheet.COVIDHistory;

@Repository
@RestResource(exported = false)
public interface COVIDRepository extends CrudRepository<COVIDHistory, Long> {

}
