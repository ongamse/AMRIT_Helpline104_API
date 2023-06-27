package com.iemr.helpline104.service.cdss;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.cdss.Symptoms;
import com.iemr.helpline104.repository.cdss.DBConnect;

@RunWith(MockitoJUnitRunner.class)
public class CDSSServiceImplTest {

	@InjectMocks
	CDSSServiceImpl cDSSServiceImpl;
	
	@Mock
	DBConnect dbConnect;
	

	@Test
	public void getSymptomsTest()
	{
		List<String> list=Lists.newArrayList();
		String str=new String("connection");
		list.add(str);
		
		doReturn(list).when(dbConnect).getSymptoms();
		List<String> list1=cDSSServiceImpl.getSymptoms();
		assertTrue(list1.toString().contains("connection"));
	}
	
	@Test
	public void getQuestionsTest()
	{
		String response=cDSSServiceImpl.getQuestions(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
		assertTrue(response.contains("No Question Found"));
	}
	
	@Test
	public void getQuestionsTest1()
	{
		Symptoms symptomData  =new Symptoms ();
		symptomData.setSymptom("symtoms-found");
		symptomData.setSymptomId(101);
		//symptomData.setData("{\"Question Set\":\"{\"Question Set\":\"abc\"}");
		symptomData.setData("{\"Question Set\":[{\"status\":\"Success\"}]}");
		doReturn(symptomData).when(dbConnect).getQuestions(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
		
		//String response=cDSSServiceImpl.getQuestions(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
		//assertTrue(response.contains("No Question Found"));
	}
	
	@Test
	public void getResultTest()
	{
		//String response=cDSSServiceImpl.getResult(Mockito.anyInt(), Mockito.anyInt());
		//assertTrue(response.contains("No Question Found"));
	}
}
