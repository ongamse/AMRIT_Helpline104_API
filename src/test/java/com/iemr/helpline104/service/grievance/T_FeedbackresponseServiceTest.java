package com.iemr.helpline104.service.grievance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.grievance.T_Feedbackresponse;
import com.iemr.helpline104.repository.grievance.T_FeedbackresponseRepo;

@RunWith(MockitoJUnitRunner.class)
public class T_FeedbackresponseServiceTest {

	
	@InjectMocks
	T_FeedbackresponseService t_FeedbackresponseService;
	
	@Mock
	T_FeedbackresponseRepo feedbackresponseRepo;
	
	@Test
	public void updateResponceTest()
	{
		T_Feedbackresponse feedbackresponce=new T_Feedbackresponse();
		feedbackresponce.setFeedbackResponseID(101);
		doReturn(feedbackresponce).when(feedbackresponseRepo).save(feedbackresponce);
		t_FeedbackresponseService.updateResponce(feedbackresponce);
	}
	
	@Test
	public void getdataByIdTest()
	{
		ArrayList<Object[]> resultSet=Lists.newArrayList();
		Object[] array=new Object[25];
		array[0]=12;
		resultSet.add(array);
		doReturn(resultSet).when(feedbackresponseRepo).getdatabyId(Mockito.anyInt());
		ArrayList<Object[]> list=t_FeedbackresponseService.getdataById(Mockito.anyInt());
		Object[] array1=list.get(0);
		assertTrue(array1[0].toString().contains("12"));
	}
	
	@Test
	public void getdataByIdTest1()
	{
		ArrayList<Object[]> list=t_FeedbackresponseService.getdataById(Mockito.anyInt());
		assertFalse(!list.isEmpty());
	}
}
