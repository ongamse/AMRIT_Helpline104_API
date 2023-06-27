package com.iemr.helpline104.controller.healthCareWorkerType;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.healthCareWorkerType.M_HealthCareWorker;
import com.iemr.helpline104.service.healthCareWorkerType.HealthCareWorkerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class HealthCareWorkerTypeControllerTest {

	@InjectMocks
	HealthCareWorkerTypeController healthCareWorkerTypeController;
	
	@Mock
	HealthCareWorkerServiceImpl healthCareWorkerServiceImpl;
	
	@Test
	public void getHealthCareWorkerTypesTest()
	{
		List<M_HealthCareWorker> i_BeneficiaryTypes=Lists.newArrayList();
		M_HealthCareWorker m_HealthCareWorker=new M_HealthCareWorker();
		m_HealthCareWorker.setHealthCareWorkerType("Asha");
		i_BeneficiaryTypes.add(m_HealthCareWorker);
		doReturn(i_BeneficiaryTypes).when(healthCareWorkerServiceImpl).getHealthCareWorkerTypes();
		String response=healthCareWorkerTypeController.getHealthCareWorkerTypes();
		assertTrue(response.contains("\"healthCareWorkerType\":\"Asha\""));
	}
}
