package com.iemr.helpline104.controller.feedback;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.feedback.FeedbackDetails;
import com.iemr.helpline104.service.feedback.FeedbackService;
import com.iemr.helpline104.service.feedback.FeedbackServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackControllerTest {

	@InjectMocks
	FeedbackController FeedbackController;
	
	@Mock
	FeedbackServiceImpl feedbackServiceImpl;
	
	@Mock
	FeedbackService feedbackService;
	
	@Test
	public void feedbackReuestTest()
	{
		FeedbackDetails feedbackDetails=new FeedbackDetails();
		feedbackDetails.setFeedbackID(new Long("101"));
		feedbackDetails.setBeneficiaryRegID(new Long("102"));
		List<FeedbackDetails> feedbackList=Lists.newArrayList();
		feedbackList.add(feedbackDetails);
		doReturn(feedbackList).when(feedbackService).getFeedbackRequests(Mockito.anyLong());
		String response=FeedbackController.feedbackReuest(feedbackDetails.toString());
		assertTrue(response.contains("\"feedbackID\":101"));
	}
	@Test
	public void feedbackReuestExceptionTest()
	{
		FeedbackDetails feedbackDetails=new FeedbackDetails();
		feedbackDetails.setFeedbackID(new Long("101"));
		feedbackDetails.setBeneficiaryRegID(new Long("102"));
		doThrow(Exception.class).when(feedbackService).getFeedbackRequests(Mockito.anyLong());
		String response=FeedbackController.feedbackReuest(feedbackDetails.toString());
		assertFalse(response.contains("\"feedbackID\":101"));
	}
	/*@SuppressWarnings("deprecation")
	@Test
	public void feedbackCreateTest()
	{
		FeedbackDetails feedbackDetails=new FeedbackDetails();
		//feedbackDetails.setFeedbackID(new Long("101"));
		feedbackDetails.setBeneficiaryRegID(new Long("102"));
		doReturn(feedbackDetails).when(feedbackService).createFeedback(Mockito.anyObject());
		String response=FeedbackController.feedbackCreate("{\"feedbackID\":101, \"beneficiaryRegID\":102},{\"instituteType\":{},{\"feedbackNatureDetail\":{}");
		assertTrue(response.contains("\"feedbackID\":101"));
	}*/
	@Test
	public void feedbackCreateExceptionTest()
	{
		FeedbackDetails feedbackDetails=new FeedbackDetails();
		feedbackDetails.setFeedbackID(new Long("101"));
		feedbackDetails.setBeneficiaryRegID(new Long("102"));
		doThrow(Exception.class).when(feedbackService).createFeedback(Mockito.anyObject());
		String response=FeedbackController.feedbackCreate(feedbackDetails.toString());
		assertFalse(response.contains("\"feedbackID\":101"));
	}
	@Test
	public void getFeedbackByPostTest()
	{
		FeedbackDetails feedbackDetails=new FeedbackDetails();
		feedbackDetails.setFeedbackID(new Long("101"));
		feedbackDetails.setBeneficiaryRegID(new Long("102"));
		List<FeedbackDetails> feedbackList=Lists.newArrayList();
		feedbackList.add(feedbackDetails);
		doReturn(feedbackList).when(feedbackService).getFeedbackRequests(Mockito.anyInt());
		String response=FeedbackController.getFeedbackByPost(Mockito.anyInt());
		assertTrue(response.contains("\"feedbackID\":101"));
	}
	@Test
	public void getFeedbackByPostExceptionTest()
	{
		doThrow(Exception.class).when(feedbackService).getFeedbackRequests(Mockito.anyInt());
		String response=FeedbackController.getFeedbackByPost(Mockito.anyInt());
		assertFalse(response.contains("\"feedbackID\":101"));
	}
	@Test
	public void updateFeedbackTest() throws Exception
	{
		FeedbackDetails feedbackDetails=new FeedbackDetails();
		feedbackDetails.setFeedbackID(new Long("101"));
		feedbackDetails.setBeneficiaryRegID(new Long("102"));
		doReturn(feedbackDetails.toString()).when(feedbackService).updateFeedback(Mockito.anyObject());
		String response=FeedbackController.updateFeedback(feedbackDetails.toString());
		assertTrue(response.contains("\"feedbackID\":101"));
	}
	@Test
	public void updateFeedbackExceptionTest() throws Exception
	{
		FeedbackDetails feedbackDetails=new FeedbackDetails();
		feedbackDetails.setFeedbackID(new Long("101"));
		feedbackDetails.setBeneficiaryRegID(new Long("102"));
		doThrow(Exception.class).when(feedbackService).updateFeedback(Mockito.anyObject());
		String response=FeedbackController.updateFeedback(feedbackDetails.toString());
		assertFalse(response.contains("\"feedbackID\":101"));
	}

}
