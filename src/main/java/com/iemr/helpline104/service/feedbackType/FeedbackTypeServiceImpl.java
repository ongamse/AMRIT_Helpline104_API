package com.iemr.helpline104.service.feedbackType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.feedbackNature.M_FeedbackNature;
import com.iemr.helpline104.data.feedbackType.M_FeedbackType;
import com.iemr.helpline104.repository.feedbackNature.FeedbackNatureRepository;
import com.iemr.helpline104.repository.feedbackType.FeedbackTypeRepository;

@Service
public class FeedbackTypeServiceImpl implements FeedbackTypeService{

	
	@Autowired
	private FeedbackTypeRepository feedbackTypeRepository;
	
	@Override
	public List<M_FeedbackType> getNatureOfComplaintTypes(Integer serviceLineID, Short feedbackTypeID)
			throws Exception {
		List<M_FeedbackType> natureOfComplaintsList = new ArrayList<M_FeedbackType>();
		List<Objects[]> natureOfComplaints = feedbackTypeRepository.getNatureOfComplaintTypes(serviceLineID, feedbackTypeID);
		
		for (Object[] objects : natureOfComplaints) {
			if (objects!=null && objects.length > 0) {
				
				natureOfComplaintsList.add(new M_FeedbackType((Short)objects[0], (String)objects[1], (String)objects[2], (Integer)objects[3], (Integer)objects[4],
																(String)objects[5], (String)objects[6]));
			}
		}
		return natureOfComplaintsList;
	}
}
