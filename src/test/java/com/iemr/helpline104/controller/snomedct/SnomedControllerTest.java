package com.iemr.helpline104.controller.snomedct;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.iemr.helpline104.data.snomedct.SCTDescription;
import com.iemr.helpline104.service.snomedct.SnomedService;

@RunWith(MockitoJUnitRunner.class)
public class SnomedControllerTest {

	@InjectMocks
	SnomedController snomedController;
	
	@Mock
	SnomedService snomedService;
	
	@Test
	public void getSnomedCTRecordTest()
	{
		SCTDescription sctdescription =new SCTDescription();
		sctdescription.setCaseSignificanceID("101");
		List<SCTDescription> list=Lists.newArrayList();
		list.add(sctdescription);
		doReturn(list).when(snomedService).findSnomedCTRecordFromTerm(Mockito.anyString());
		String response=snomedController.getSnomedCTRecord(sctdescription.toString());
		assertTrue(response.contains("\"caseSignificanceID\":\"101\""));
	}
	
	@Test
	public void getSnomedCTRecordTest1()
	{
		SCTDescription sctdescription =new SCTDescription();
		sctdescription.setCaseSignificanceID("900000000000448009");
		List<SCTDescription> list=Lists.newArrayList();
		list.add(sctdescription);
		doReturn(list).when(snomedService).findSnomedCTRecordFromTerm(Mockito.anyString());
		String response=snomedController.getSnomedCTRecord(sctdescription.toString());
		assertTrue(response.contains("\"caseSignificanceID\":\"900000000000448009\""));
	}
	
	@Test
	public void getSnomedCTRecordTestException()
	{
		SCTDescription sctdescription =new SCTDescription();
		sctdescription.setCaseSignificanceID("900000000000448009");
		doThrow(Exception.class).when(snomedService).findSnomedCTRecordFromTerm(Mockito.anyString());
		String response=snomedController.getSnomedCTRecord(sctdescription.toString());
		assertFalse(response.contains("\"caseSignificanceID\""));
	}
	
	@Test
	public void getSnomedCTRecordsTest()
	{
		SCTDescription sctdescription =new SCTDescription();
		sctdescription.setCaseSignificanceID("101");
		List<SCTDescription> list=Lists.newArrayList();
		list.add(sctdescription);
		doReturn(list).when(snomedService).findSnomedCTRecordFromTerm(Mockito.anyString());
		String response=snomedController.getSnomedCTRecords(sctdescription.toString());
		assertTrue(response.contains("\"caseSignificanceID\":\"101\""));
	}
	
	@Test
	public void getSnomedCTRecordsExceptionTest()
	{
		SCTDescription sctdescription =new SCTDescription();
		sctdescription.setCaseSignificanceID("101");
		doThrow(Exception.class).when(snomedService).findSnomedCTRecordFromTerm(Mockito.anyString());
		String response=snomedController.getSnomedCTRecords(sctdescription.toString());
		assertFalse(response.contains("\"caseSignificanceID\""));
	}
}
