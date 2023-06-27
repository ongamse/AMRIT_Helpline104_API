package com.iemr.helpline104.repository.grievance;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.grievance.T_Feedbackresponse;

@Repository
@RestResource(exported = false)
public interface T_FeedbackresponseRepo extends CrudRepository<T_Feedbackresponse, Integer>{
	@Query("SELECT tf1.responseSummary,tf1.feedbackRequestID,tf1.comments,tf1.authName,tf1.authDesignation," 
	+ " tfr.feedbackID as FeedbackID,"
	+ " tfr.feedbackSupSummary as FeedbackSupSummary,"
	+ " tfr.comments as Comments,"
	+ " tf.feedback as Feedback"		
	+ " FROM T_Feedbackresponse tf1 "  
	+ " JOIN tf1.tfeedbackr1 tfr " 
	+ " JOIN tf1.tfeedback tf"
	+ " WHERE tf1.feedbackID =:i ")
	ArrayList<Object[]> getdatabyId(@Param("i")int i);

}
