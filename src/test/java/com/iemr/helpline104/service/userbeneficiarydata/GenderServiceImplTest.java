package com.iemr.helpline104.service.userbeneficiarydata;

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

import com.iemr.helpline104.data.userbeneficiarydata.M_Gender;
import com.iemr.helpline104.repository.userbeneficiarydata.GenderRepository;

@RunWith(MockitoJUnitRunner.class)
public class GenderServiceImplTest {
	
	@InjectMocks
	GenderServiceImpl genderServiceImpl;
	
	@Mock
	GenderRepository genderRepository;
	
	@Test
	public void getActiveGendersTest()
	{
		Set<Object[]> set=Sets.newHashSet();
		Object[] array=new Object[2];
		Short s=12;
		array[0]=s;
		array[1]="Male";
		set.add(array);
		try {
			doReturn(set).when(genderRepository).findAciveGenders();
			List<M_Gender> m_Gender= genderServiceImpl.getActiveGenders();
			assertTrue(m_Gender.toString().contains("\"genderName\":\"Male\""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getActiveGendersTest1()
	{
		Set<Object[]> set=Sets.newHashSet();
		try {
			doReturn(set).when(genderRepository).findAciveGenders();
			List<M_Gender> m_Gender= genderServiceImpl.getActiveGenders();
			assertTrue(m_Gender.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
