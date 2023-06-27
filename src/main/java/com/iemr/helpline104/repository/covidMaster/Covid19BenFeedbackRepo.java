package com.iemr.helpline104.repository.covidMaster;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.covidMaster.Covid19BenFeedback;



@Repository
@RestResource(exported = false)
public interface Covid19BenFeedbackRepo extends CrudRepository<Covid19BenFeedback, Long> {

}
