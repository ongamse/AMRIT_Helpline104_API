package com.iemr.helpline104.service.userbeneficiarydata;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.userbeneficiarydata.M_Gender;
import com.iemr.helpline104.repository.userbeneficiarydata.UserBeneficiaryDataRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserBeneficiaryDataServiceImplTest {
	
	@InjectMocks
	UserBeneficiaryDataServiceImpl userBeneficiaryDataServiceImpl;
	
	@Mock
	UserBeneficiaryDataRepository userBeneficiaryDataRepository;
	
	@Test
	public void getActiveGenderTest()
	{
		HashSet<Object[]> set=Sets.newHashSet();
		Object[] array=new Object[2];
		Short s=101;
		array[0]=s;
		array[1]="Male";
		
		set.add(array);
		try {
			doReturn(set).when(userBeneficiaryDataRepository).findActiveGenders();
			List<M_Gender> m_Gender= userBeneficiaryDataServiceImpl.getActiveGender();
			assertTrue(m_Gender.toString().contains("\"genderName\":\"Male\""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getActiveGenderTest1()
	{
		HashSet<Object[]> set=Sets.newHashSet();
		try {
			doReturn(set).when(userBeneficiaryDataRepository).findActiveGenders();
			List<M_Gender> m_Gender= userBeneficiaryDataServiceImpl.getActiveGender();
			assertFalse(!m_Gender.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getActiveGenderTest2()
	{
		try {
			List<M_Gender> m_Gender= userBeneficiaryDataServiceImpl.getActiveGender();
			assertFalse(!m_Gender.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
