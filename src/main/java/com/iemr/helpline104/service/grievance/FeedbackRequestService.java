package com.iemr.helpline104.service.grievance;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.grievance.T_FeedbackRequset;
import com.iemr.helpline104.repository.grievance.FeedbackRequest;

@Service
public class FeedbackRequestService {
	
	@Autowired 
	private FeedbackRequest feedbackrequest;

	public int update(T_FeedbackRequset feedbackrequest1) {
		feedbackrequest.save(feedbackrequest1);  
		
		return feedbackrequest1.getFeedbackRequestID();
	}

	public ArrayList<Object[]> getAllFeedback(Integer feedbackID) {
		// TODO Auto-generated method stub
		return feedbackrequest.getAllFeedbackByID(feedbackID);
	}

	
	public T_FeedbackRequset getdataById(int feedbackID) {
		// TODO Auto-generated method stub
		return feedbackrequest.getdataById(feedbackID);
	}

	public T_FeedbackRequset getdataById1(int res) {
		// TODO Auto-generated method stub
		return feedbackrequest.getdataById1(res);
	}

	

}
