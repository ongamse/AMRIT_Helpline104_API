package com.iemr.helpline104.service.snomedct;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.snomedct.SCTDescription;
import com.iemr.helpline104.repository.snomedct.SnomedRepository;

@RunWith(MockitoJUnitRunner.class)
public class SnomedServiceImplTest {
	
	@InjectMocks
	SnomedServiceImpl snomedServiceImpl;
	
	@Mock
	SnomedRepository snomedRepository;
	
	@Test
	public void findSnomedCTRecordFromTermTest()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[20];
		array[0]="sigID";
		array[1]="term";
		
		list.add(array);
		try {
			doReturn(list).when(snomedRepository).findSnomedCTRecordFromTerm(Mockito.anyString());
			List<SCTDescription> sCTDescription= snomedServiceImpl.findSnomedCTRecordFromTerm(Mockito.anyString());
			SCTDescription description=sCTDescription.get(0);
			assertTrue(description.getTerm().equals("term"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void findSnomedCTRecordFromTermTest1()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		try {
			doReturn(list).when(snomedRepository).findSnomedCTRecordFromTerm(Mockito.anyString());
			List<SCTDescription> sCTDescription= snomedServiceImpl.findSnomedCTRecordFromTerm(Mockito.anyString());
			assertFalse(!sCTDescription.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
