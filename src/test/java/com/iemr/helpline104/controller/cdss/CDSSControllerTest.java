package com.iemr.helpline104.controller.cdss;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.gson.stream.JsonReader;
import com.iemr.helpline104.data.cdss.SymptomsWrapper;
import com.iemr.helpline104.service.cdss.CDSSServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CDSSControllerTest {

	@InjectMocks
	CDSSController cDSSController;
	
	@Mock
	CDSSServiceImpl cDSSServiceImpl;
	
	@Test
	public void getSymptomsTest()
	{
		String response=cDSSController.getSymptoms();
		assertTrue(response.contains("No Symptoms Found"));	
	}
	
	@Test
	public void getSymptomsTest1()
	{
		List<String> symptoms =new ArrayList<String>();
		symptoms.add("fever");
		symptoms.add("headache");
		doReturn(symptoms).when(cDSSServiceImpl).getSymptoms();
		String response=cDSSController.getSymptoms();
		assertTrue(response.contains("fever\",\"headache"));	
	}
	@Test
	public void getSymptomsExceptionTest()
	{
		doThrow(Exception.class).when(cDSSServiceImpl).getSymptoms();
		String response=cDSSController.getSymptoms();
		assertTrue(response.contains("Failed with null"));	
	}
	@Test
	public void getQuestionTest()
	{
		SymptomsWrapper symptomsDetail=Mockito.mock(SymptomsWrapper.class,Mockito.CALLS_REAL_METHODS);
		symptomsDetail.setSymptom("101");
		String response=cDSSController.getQuestion(symptomsDetail);
		assertTrue(response.contains("Failed with generic error"));
	}
	@Test
	public void getQuestionTest1()
	{
		SymptomsWrapper symptomsDetail=Mockito.mock(SymptomsWrapper.class,Mockito.CALLS_REAL_METHODS);
		symptomsDetail.setSymptom("101");
		symptomsDetail.setGender("Male");
		symptomsDetail.setAge(47);
		doReturn("Message").when(cDSSServiceImpl).getQuestions(Mockito.anyString(),Mockito.anyInt(),Mockito.anyString());
		String response=cDSSController.getQuestion(symptomsDetail);
		assertTrue(response.contains("\"status\":\"Success\""));
	}
	@Test
	public void getResultTest()
	{
		//JsonReader.setLenient(true);
		//cDSSController.getResult("\"complaintId\":101".toString());
		//assertTrue(response.contains("\"beneficiaryRegID\":201"));
	}
	@Test
	public void saveSymptomTest()
	{
		doReturn("Sucess").when(cDSSServiceImpl).saveSymptom(Mockito.anyString());
		String response=cDSSController.saveSymptom(Mockito.anyString());
		assertTrue(response.contains("Sucess"));
	}
	@Test
	public void saveSymptomExceptionTest()
	{
		doThrow(Exception.class).when(cDSSServiceImpl).saveSymptom(Mockito.anyString());
		String response=cDSSController.saveSymptom(Mockito.anyString());
		assertFalse(response.contains("Sucess"));
	}
}
