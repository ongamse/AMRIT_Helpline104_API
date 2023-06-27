package com.iemr.helpline104.service.beneficiarycall;

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
import com.iemr.helpline104.data.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.helpline104.data.beneficiarycall.M_subservice;
import com.iemr.helpline104.repository.beneficiarycall.ServiceMasterRepository;
import com.iemr.helpline104.repository.beneficiarycall.ServicesHistoryRepository;
@RunWith(MockitoJUnitRunner.class)
public class ServicesHistoryServiceImplTest {

	@InjectMocks
	ServicesHistoryServiceImpl servicesHistoryServiceImpl;
	
	@Mock
	ServicesHistoryRepository serviceHistoryRepository;
	
	@Mock
	ServiceMasterRepository serviceMasterRepository;
	
	@Test
	public void createServiceHistoryTest()
	{
		BenCallServicesMappingHistory MappingHistory=new BenCallServicesMappingHistory(101L,102L,103,true,"createdBy");
		BenCallServicesMappingHistory MappingHistory1=new BenCallServicesMappingHistory(101L,102L,103,true,"createdBy");
		
		doReturn(MappingHistory1).when(serviceHistoryRepository).save(MappingHistory);
		BenCallServicesMappingHistory response=servicesHistoryServiceImpl.createServiceHistory(MappingHistory);
		assertTrue(response.getBenCallID()==102);
	}
	
	@Test
	public void createServiceHistoryTest1()
	{
		BenCallServicesMappingHistory MappingHistory=new BenCallServicesMappingHistory(101L,102L,103,true,"createdBy");
		BenCallServicesMappingHistory response=servicesHistoryServiceImpl.createServiceHistory(MappingHistory);
		assertTrue(response==null);
	}
	
	@Test
	public void getServicesTest()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[1];
		M_subservice subservice=new M_subservice();
		subservice.setSubServiceID(101);
		array[0]=subservice;
		list.add(array);
		try {
			doReturn(list).when(serviceMasterRepository).getServices(Mockito.anyInt());
			List<Objects[]> m_Religion=servicesHistoryServiceImpl.getServices(Mockito.anyInt());
			//assertTrue(m_Religion.toString().contains("subServiceID"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
