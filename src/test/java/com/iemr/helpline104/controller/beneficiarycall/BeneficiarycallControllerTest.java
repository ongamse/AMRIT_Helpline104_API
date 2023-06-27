package com.iemr.helpline104.controller.beneficiarycall;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

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
import com.iemr.helpline104.service.beneficiarycall.ServicesHistoryService;
import com.iemr.helpline104.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class BeneficiarycallControllerTest {

	@InjectMocks
	BeneficiarycallController beneficiarycallController;
	
	@Mock
	ServicesHistoryService servicesHistoryService;
	
	
	@Test
	public void getServicesTest()
	{
		M_subservice m_subservice=new M_subservice();
		m_subservice.setProviderServiceMapID(101);
		List<Objects[]> services=Lists.newArrayList();
		Objects[] obj=new Objects[3];
		services.add(0, obj);
		doReturn(services).when(servicesHistoryService).getServices(Mockito.anyInt());
		String response=beneficiarycallController.getServices(m_subservice.toString());
		assertTrue(response.contains("\"status\":\"Success\""));
	}
	@Test
	public void getServicesExceptionTest()
	{
		M_subservice m_subservice=new M_subservice();
		m_subservice.setProviderServiceMapID(101);
		doThrow(IEMRException.class).when(servicesHistoryService).getServices(Mockito.any());
		String response=beneficiarycallController.getServices(m_subservice.toString());
		assertTrue(response.contains("User login failed"));
	}
	@Test
	public void setServiceHistoryTest()
	{
		BenCallServicesMappingHistory history=new BenCallServicesMappingHistory(new Long("101"),new Long("102"),103,true,"createdBy");
		doReturn(history).when(servicesHistoryService).createServiceHistory(Mockito.any());
		String response=beneficiarycallController.setServiceHistory(history.toString());
		assertTrue(response.contains("\"beneficiaryRegID\":101"));
	}
	@Test
	public void setServiceHistoryExceptionTest()
	{
		BenCallServicesMappingHistory history=new BenCallServicesMappingHistory(new Long("101"),new Long("102"),103,true,"createdBy");
		doThrow(IEMRException.class).when(servicesHistoryService).createServiceHistory(Mockito.any());
		String response=beneficiarycallController.setServiceHistory(history.toString());
		assertTrue(response.contains("User login failed"));
	}

}
