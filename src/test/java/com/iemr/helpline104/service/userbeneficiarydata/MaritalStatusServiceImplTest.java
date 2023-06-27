package com.iemr.helpline104.service.userbeneficiarydata;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.userbeneficiarydata.M_MaritalStatus;
import com.iemr.helpline104.repository.userbeneficiarydata.MaritalStatusRepository;

@RunWith(MockitoJUnitRunner.class)
public class MaritalStatusServiceImplTest {
	
	@InjectMocks
	MaritalStatusServiceImpl maritalStatusServiceImpl;
	
	@Mock
	MaritalStatusRepository maritalStatusRepository;
	
	@Test
	public void getActiveMaritalStatusTest()
	{
		Set<Object[]> set=Sets.newHashSet();
		Object[] array=new Object[2];
		array[0]=101;
		array[1]="MaritalStatus";
		set.add(array);
		try {
			doReturn(set).when(maritalStatusRepository).findAciveMaritalStatus();
			List<M_MaritalStatus> m_MaritalStatus= maritalStatusServiceImpl.getActiveMaritalStatus();
			assertTrue(m_MaritalStatus.toString().contains("MaritalStatus"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getActiveMaritalStatusTest1()
	{
		Set<Object[]> set=Sets.newHashSet();
		try {
			doReturn(set).when(maritalStatusRepository).findAciveMaritalStatus();
			List<M_MaritalStatus> m_MaritalStatus= maritalStatusServiceImpl.getActiveMaritalStatus();
			assertFalse(!m_MaritalStatus.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
