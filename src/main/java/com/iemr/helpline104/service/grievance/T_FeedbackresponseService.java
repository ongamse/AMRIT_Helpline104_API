package com.iemr.helpline104.service.grievance;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.grievance.T_Feedbackresponse;
import com.iemr.helpline104.repository.grievance.T_FeedbackresponseRepo;

  @Service
public class T_FeedbackresponseService {
	@Autowired
	private T_FeedbackresponseRepo FeedbackresponseRepo;

	public void updateResponce(T_Feedbackresponse feedbackresponce) {
		FeedbackresponseRepo.save(feedbackresponce);
		
		
	}

	public ArrayList<Object[]> getdataById(int i) {
		// TODO Auto-generated method stub
		return FeedbackresponseRepo.getdatabyId(i);
	}

}
