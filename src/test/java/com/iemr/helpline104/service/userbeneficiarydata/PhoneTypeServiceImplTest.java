package com.iemr.helpline104.service.userbeneficiarydata;

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
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.userbeneficiarydata.M_PhoneType;
import com.iemr.helpline104.repository.userbeneficiarydata.PhoneTypeRepository;
@RunWith(MockitoJUnitRunner.class)
public class PhoneTypeServiceImplTest {
	
	@InjectMocks
	PhoneTypeServiceImpl phoneTypeServiceImpl;
	
	@Mock
	PhoneTypeRepository phoneTypeRepository;
	
	@Test
	public void getActivePhoneTypes()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[20];
		Short s=101;
		array[0]=s;
		array[1]="request";
		
		
		list.add(array);
		try {
			doReturn(list).when(phoneTypeRepository).findAcivePhoneTypes();
			List<M_PhoneType> m_PhoneType= phoneTypeServiceImpl.getActivePhoneTypes();
			M_PhoneType m_Phone=m_PhoneType.get(0);
			assertTrue(m_Phone.getPhoneTypeID()==101);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getActivePhoneTypes1()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		try {
			doReturn(list).when(phoneTypeRepository).findAcivePhoneTypes();
			List<M_PhoneType> m_PhoneType= phoneTypeServiceImpl.getActivePhoneTypes();
			assertFalse(!m_PhoneType.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
