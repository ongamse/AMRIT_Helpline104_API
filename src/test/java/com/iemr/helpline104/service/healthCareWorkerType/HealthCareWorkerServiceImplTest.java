package com.iemr.helpline104.service.healthCareWorkerType;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.healthCareWorkerType.M_HealthCareWorker;
import com.iemr.helpline104.repository.healthCareWorkerType.HealthCareWorkerTypeRepository;

@RunWith(MockitoJUnitRunner.class)
public class HealthCareWorkerServiceImplTest {
	
	@InjectMocks
	HealthCareWorkerServiceImpl t_FeedbackresponseService;
	
	@Mock
	HealthCareWorkerTypeRepository healthCareWorkerTypeRepository;
	
	@Test
	public void getHealthCareWorkerTypesTest()
	{
		ArrayList<Objects[]> resultSet=Lists.newArrayList();
		Objects[] array=new Objects[25];
		resultSet.add(array);
		doReturn(resultSet).when(healthCareWorkerTypeRepository).findAciveHealthCareWorkerTypes();
		List<M_HealthCareWorker> list=t_FeedbackresponseService.getHealthCareWorkerTypes();
		assertFalse(list.toString().contains("\"healthCareWorkerDesc\""));
	}
	
	@Test
	public void getHealthCareWorkerTypesTest1()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[2];
		Short s=15;
		array[0]=s;
		array[1]="NGO";

		list.add(array);
		try {
			doReturn(list).when(healthCareWorkerTypeRepository).findAciveHealthCareWorkerTypes();
			List<M_HealthCareWorker> list1=t_FeedbackresponseService.getHealthCareWorkerTypes();
			assertTrue(list1.toString().contains("\"healthCareWorkerType\":\"NGO\""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
