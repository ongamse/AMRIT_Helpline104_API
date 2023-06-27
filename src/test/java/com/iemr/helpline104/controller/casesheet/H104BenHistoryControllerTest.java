package com.iemr.helpline104.controller.casesheet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.iemr.helpline104.data.casesheet.H104BenMedHistory;
import com.iemr.helpline104.service.casesheet.H104BenHistoryServiceImpl;

@RunWith(MockitoJUnitRunner.class)

public class H104BenHistoryControllerTest {

	@InjectMocks
	H104BenHistoryController smpleBenHistoryController;
	
	@Mock
	H104BenHistoryServiceImpl smpleBenHistoryServiceImpl;
	
	
	@Test
	public void saveBenCaseSheetTest()
	{
		/*H104BenMedHistory smpleBenHistory=new H104BenMedHistory();
		smpleBenHistory.setRequestID("101");
		doReturn(smpleBenHistory).when(smpleBenHistoryServiceImpl).saveSmpleBenHistory(Mockito.anyObject());
		String response=smpleBenHistoryController.saveBenCaseSheet(smpleBenHistory.toString());
		assertTrue(response.contains("\"requestID\":\"101\""));	*/
		
	}
	@Test
	public void saveBenCaseSheetExceptionTest()
	{
		/*H104BenMedHistory smpleBenHistory=new H104BenMedHistory();
		smpleBenHistory.setRequestID("101");
		doThrow(Exception.class).when(smpleBenHistoryServiceImpl).saveSmpleBenHistory(Mockito.anyObject());
		String response=smpleBenHistoryController.saveBenCaseSheet(smpleBenHistory.toString());
		assertFalse(response.contains("\"requestID\":\"101\""));*/	
		
	}
	

	@Test
	public void getBenCaseSheetTest1()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		doReturn(list).when(smpleBenHistoryServiceImpl).geSmpleBenHistory(Mockito.anyLong(),null);
		String response=smpleBenHistoryController.getBenCaseSheet("{\"beneficiaryRegID\":101}");
		assertFalse(response.contains("\"benHistoryID\":\"101\""));	
	}
	@Test
	public void getBenCaseSheetTest2()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[15];
		array[0]=101;
		array[1]=102;
		list.add(array);
		
		doReturn(list).when(smpleBenHistoryServiceImpl).geSmpleBenHistory(Mockito.anyLong(),null);
		String response=smpleBenHistoryController.getBenCaseSheet("{\"beneficiaryRegID\":101}");
		assertTrue(response.contains("\"status\":\"Success\""));	
	}
}
