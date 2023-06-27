package com.iemr.helpline104.service.feedback;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iemr.helpline104.data.feedback.FeedbackDetails;

public interface FeedbackService {

	public List<FeedbackDetails> getFeedbackRequests(long id);

	public List<FeedbackDetails> getFeedbackRequest(long id);

	public String updateFeedback(FeedbackDetails feedbackDetails) throws Exception;

	public FeedbackDetails createFeedback(FeedbackDetails feedbackDetails);

//	public String saveFeedbackFromCustomer(Iterable<FeedbackDetails> feedbackDetails);
	public String saveFeedbackFromCustomer(String feedbackDetails, HttpServletRequest request) throws Exception;

}
