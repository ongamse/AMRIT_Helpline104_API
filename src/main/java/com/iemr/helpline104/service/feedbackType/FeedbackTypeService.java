package com.iemr.helpline104.service.feedbackType;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.iemr.helpline104.data.feedbackNature.M_FeedbackNature;
import com.iemr.helpline104.data.feedbackType.M_FeedbackType;

public interface FeedbackTypeService {
	List<M_FeedbackType> getNatureOfComplaintTypes(Integer serviceLineID,Short feedbackTypeID) throws Exception;
}
