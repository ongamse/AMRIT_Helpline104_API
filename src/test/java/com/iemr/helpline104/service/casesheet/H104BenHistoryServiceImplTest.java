package com.iemr.helpline104.service.casesheet;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.iemr.helpline104.data.casesheet.H104BenMedHistory;
import com.iemr.helpline104.repository.casesheet.H104BenHistoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class H104BenHistoryServiceImplTest {

	@InjectMocks
	H104BenHistoryServiceImpl smpleBenHistoryServiceImpl;
	
	@Mock
	H104BenHistoryRepository smpleBenHistoryRepositoryRepository;
	

	@Test
	public void geSmpleBenHistoryTest() {
		
		ArrayList<Objects[]> list=Lists.newArrayList();

		doReturn(list).when(smpleBenHistoryRepositoryRepository).getBenHistory(Mockito.anyLong());
		List<H104BenMedHistory> list1=smpleBenHistoryServiceImpl.geSmpleBenHistory(Mockito.anyLong(),null);
		assertTrue(list1.isEmpty());
	}
	
	@Test
	public void saveSmpleBenHistoryTest1()
	{
	/*	H104BenMedHistory smpleBenHistory =new H104BenMedHistory();
		smpleBenHistory.setRequestID("101");
		doReturn(smpleBenHistory).when(smpleBenHistoryRepositoryRepository).save(smpleBenHistory);
		H104BenMedHistory smpleBenHistory2=smpleBenHistoryServiceImpl.saveSmpleBenHistory(smpleBenHistory);
		assertTrue(smpleBenHistory2.toString().contains("\"requestID\":\"101\""));*/
	}
	
	@Test
	public void saveSmpleBenHistoryTest2()
	{
		/*H104BenMedHistory smpleBenHistory =new H104BenMedHistory();
		smpleBenHistory.setRequestID("101");
		H104BenMedHistory smpleBenHistory2=smpleBenHistoryServiceImpl.saveSmpleBenHistory(smpleBenHistory);
		assertTrue(smpleBenHistory2==null);*/
	}
}
