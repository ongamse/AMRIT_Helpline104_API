package com.iemr.helpline104.service.userbeneficiarydata;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.userbeneficiarydata.M_Status;
import com.iemr.helpline104.repository.userbeneficiarydata.StatusRepository;

@RunWith(MockitoJUnitRunner.class)
public class StatusServiceImplTest {
	
	@InjectMocks
	StatusServiceImpl statusServiceImpl;
	
	@Mock
	StatusRepository statusRepository;
	
	@Test
	public void getActiveStatusTest()
	{
		HashSet<Object[]> set=Sets.newHashSet();
		Object[] array=new Object[2];
		array[0]=101;
		array[1]="Status";
		set.add(array);
		try {
			doReturn(set).when(statusRepository).findAciveStatus();
			List<M_Status> m_Status= statusServiceImpl.getActiveStatus();
			assertTrue(m_Status.toString().contains("Status"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getActiveStatusTest1()
	{
		Set<Object[]> set=Sets.newHashSet();
		try {
			doReturn(set).when(statusRepository).findAciveStatus();
			List<M_Status> m_Status= statusServiceImpl.getActiveStatus();
			assertFalse(!m_Status.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getActiveStatusTest2()
	{
		try {
			List<M_Status> m_Status= statusServiceImpl.getActiveStatus();
			assertFalse(!m_Status.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
