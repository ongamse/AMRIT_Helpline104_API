package com.iemr.helpline104.repository.grievance;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.grievance.T_FeedbackRequset;
@Repository
@RestResource(exported = false)
public interface FeedbackRequest extends CrudRepository<T_FeedbackRequset, Integer>{

	

	
	/*@Query("SELECT u FROM T_Feedback u WHERE LOWER(u.FeedbackID) = LOWER(:res) ")
	 ServiceProvider_Model getDataById(@Param("res") int res);
	T_Feedback getDataByID(@Param("res") int res);*/
	//@Query("SELECT u FROM T_FeedbackRequset u WHERE LOWER(u.FeedbackID) = LOWER(:feedbackID) ")
	
	
	/*@Query("SELECT tf1.FeedbackID,tf1.FeedbackRequestID,tf1.FeedbackSupSummary," 
			+ " tfr.ResponseSummary as ResponseSummary,tfr.Comments as Comments"
			+ " FROM T_FeedbackRequset tf1 "  
			+ " LEFT JOIN tf1.tfeedbackResponce tfr " 
			+ " WHERE tf1.FeedbackID =:feedbackID ")*/
	@Query("SELECT u FROM T_FeedbackRequset u WHERE LOWER(u.feedbackID) = LOWER(:feedbackID) ")
	ArrayList<Object[]> getAllFeedbackByID(@Param("feedbackID") Integer feedbackID);
	
	
	@Query("SELECT u FROM T_FeedbackRequset u WHERE LOWER(u.feedbackID) = LOWER(:feedbackID) ")
	T_FeedbackRequset getdataById(@Param("feedbackID") int feedbackID);

		
	
	@Query("SELECT u FROM T_FeedbackRequset u WHERE LOWER(u.feedbackID) = LOWER(:res) ")
	T_FeedbackRequset getdataById1(@Param("res") int res);
	
}
