package com.iemr.helpline104.controller.diseaseScreening;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.diseaseScreening.M_questionairValues;
import com.iemr.helpline104.service.diseaseScreening.QuestionScoreServiceImpl;
import com.iemr.helpline104.service.diseaseScreening.QuestionnaireServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DiseaseScreeningControllerTest {

	@InjectMocks
	DiseaseScreeningController DiseaseScreeningController;
	
	@Mock
	QuestionnaireServiceImpl questionnaireServiceImpl;
	
	@Mock
	QuestionScoreServiceImpl questionScoreServiceImpl;
	
	@Test
	public void fetchQuestionsTest()
	{
		
		ArrayList<Object[]> list=Lists.newArrayList();
		try {
			//doReturn(list).when(questionnaireServiceImpl).fetchQuestions(Mockito.anyInt(),Mockito.anyInt());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=DiseaseScreeningController.fetchQuestions("{\"questionTypeID\":101, \"providerServiceMapID\":102}");
		assertFalse(response.contains("\"questionTypeID\":\"101\""));	
		
	}
	
	@Test
	public void fetchQuestionsTest1()
	{
		
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[15];
		array[0]=101;
		array[1]=102;
		list.add(array);
		try {
		//	doReturn(list).when(questionnaireServiceImpl).fetchQuestions(Mockito.anyInt(),Mockito.anyInt());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=DiseaseScreeningController.fetchQuestions("{\"questionTypeID\":101, \"providerServiceMapID\":102}");
		assertTrue(response.contains("\"status\":\"Success\""));	
		
		
	}
	@Test
	public void fetchAnswersTest()
	{
		M_questionairValues m_104QuestionScore=new M_questionairValues();
		m_104QuestionScore.setAnswer("answer");
		List<M_questionairValues> list=Lists.newArrayList();
		list.add(m_104QuestionScore);
		try {
			doReturn(list).when(questionScoreServiceImpl).fetchAnswers(Mockito.anyInt());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=DiseaseScreeningController.fetchAnswers(m_104QuestionScore.toString());
		assertTrue(response.contains("\"answer\":\"answer\""));
	}
	@Test
	public void fetchAnswersExceptionTest()
	{
		M_questionairValues m_104QuestionScore=new M_questionairValues();
		m_104QuestionScore.setAnswer("answer");
		List<M_questionairValues> list=Lists.newArrayList();
		list.add(m_104QuestionScore);
		try {
			doThrow(Exception.class).when(questionScoreServiceImpl).fetchAnswers(Mockito.anyInt());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=DiseaseScreeningController.fetchAnswers(m_104QuestionScore.toString());
		assertFalse(response.contains("\"answer\":\"answer\""));
	}
	
	
}
