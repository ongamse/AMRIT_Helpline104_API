package com.iemr.helpline104.service.feedback;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.drugMapping.M_104drugmapping;
import com.iemr.helpline104.data.feedback.FeedbackDetails;
import com.iemr.helpline104.data.feedback.FeedbackRequestDetails;
import com.iemr.helpline104.repository.beneficiarycall.BeneficiaryCallRepository;
import com.iemr.helpline104.repository.beneficiarycall.ServicesHistoryRepository;
import com.iemr.helpline104.repository.feedback.FeedbackRepository;
import com.iemr.helpline104.repository.feedbackType.FeedbackTypeRepository;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackServiceImplTest {

	@InjectMocks
	FeedbackServiceImpl feedbackServiceImpl;
	
	@Mock
	BeneficiaryCallRepository beneficiaryCallRepository;
	
	@Mock
	FeedbackTypeRepository feedbackRepositorty;
	
	@Mock
	FeedbackRepository feedbackRepository;
	
	@Mock
	ServicesHistoryRepository servicesHistoryRepository;
	
	
	@Test
	public void getFeedbackRequestsTest()
	{
		ArrayList<Objects[]> list=Lists.newArrayList();
		Objects[] array=new Objects[12];
		list.add(array);
		doReturn(list).when(feedbackRepository).findByBeneficiaryID(Mockito.anyLong());
		List<FeedbackDetails> feedbackList=feedbackServiceImpl.getFeedbackRequests(Mockito.anyLong());
		assertTrue(feedbackList.toString().contains("\"feedbackTypeID\":null"));
	}
	
	@Test
	public void getFeedbackRequestsTest1()
	{
		List<FeedbackDetails> feedbackList=feedbackServiceImpl.getFeedbackRequests(12);
		assertTrue(feedbackList.isEmpty());
	}
	
	@Test
	public void getFeedbackRequestsTest2()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[7];
		Short s=12;
		array[0]=101L;
		array[1]=s;
		array[2]=s;
		array[3]=s;
		array[4]="feedback";
		array[5]="remark";
		array[6]="";
		list.add(array);
		try {
			doReturn(list).when(feedbackRepository).findByBeneficiaryID(Mockito.anyLong());
			List<FeedbackDetails> feedbackList=feedbackServiceImpl.getFeedbackRequests(Mockito.anyLong());
			assertTrue(feedbackList.toString().contains("\"feedbackID\":101"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getFeedbackRequestTest()
	{
		ArrayList<Objects[]> list=Lists.newArrayList();
		Objects[] array=new Objects[12];
		list.add(array);
		doReturn(list).when(feedbackRepository).findByFeedbackID(Mockito.anyLong());
		List<FeedbackDetails> feedbackList=feedbackServiceImpl.getFeedbackRequest(Mockito.anyLong());
		assertTrue(feedbackList.toString().contains("\"feedbackTypeID\":null"));
	}
	@Test
	public void getFeedbackRequestTest1()
	{
		List<FeedbackDetails> feedbackList=feedbackServiceImpl.getFeedbackRequest(Mockito.anyLong());
		assertTrue(feedbackList.isEmpty());
	}
	@Test
	public void getFeedbackRequestTest2()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[7];
		Short s=12;
		array[0]=101L;
		array[1]=s;
		array[2]=s;
		array[3]=s;
		array[4]="feedback";
		array[5]="remark";
		array[6]="";
		list.add(array);
		try {
			doReturn(list).when(feedbackRepository).findByFeedbackID(Mockito.anyLong());
			List<FeedbackDetails> feedbackList=feedbackServiceImpl.getFeedbackRequest(Mockito.anyLong());
			assertTrue(feedbackList.toString().contains("\"feedbackID\":101"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void createFeedbackTest()
	{
		List<FeedbackRequestDetails> feedbackRequestList=Lists.newArrayList();
		FeedbackRequestDetails feedbackRequestDetails=new FeedbackRequestDetails();
		feedbackRequestDetails.setFeedbackRequestID(new Long("101"));
		feedbackRequestList.add(feedbackRequestDetails);
		
		FeedbackDetails feedbackDetails=new FeedbackDetails();
		feedbackDetails.setFeedbackRequestDetails(feedbackRequestList);
		
		doReturn(feedbackDetails).when(feedbackRepository).save(feedbackDetails);
		FeedbackDetails feedbackDetail=feedbackServiceImpl.createFeedback(feedbackDetails);
		assertTrue(feedbackDetail.getFeedbackRequestDetails().get(0).getFeedbackRequestID()==101);
	}
	
	@Test
	public void createFeedbackTest1()
	{
		List<FeedbackRequestDetails> feedbackRequestList=Lists.newArrayList();
		
		FeedbackDetails feedbackDetails=new FeedbackDetails();
		feedbackDetails.setFeedbackRequestDetails(feedbackRequestList);
		
		FeedbackDetails feedbackDetail=feedbackServiceImpl.createFeedback(feedbackDetails);
		assertFalse(feedbackDetail!=null);
	}
}
