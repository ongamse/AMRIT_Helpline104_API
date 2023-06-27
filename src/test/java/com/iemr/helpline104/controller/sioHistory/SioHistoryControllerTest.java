package com.iemr.helpline104.controller.sioHistory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.List;

import org.assertj.core.util.Lists;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.bloodComponentType.M_ComponentType;
import com.iemr.helpline104.service.bloodComponentType.BloodComponentTypeServiceImpl;
import com.iemr.helpline104.service.bloodRequest.BloodRequestServiceImpl;
import com.iemr.helpline104.service.directory.DirectoryServiceImpl;
import com.iemr.helpline104.service.epidemicOutbreak.EpidemicOutbreakServiceImpl;
import com.iemr.helpline104.service.foodSafetyCopmlaint.FoodSafetyCopmlaintServiceImpl;
import com.iemr.helpline104.service.organDonation.OrganDonationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SioHistoryControllerTest {

	@InjectMocks
	SioHistoryController sioHistoryController;
	
	@Mock
	BloodRequestServiceImpl bloodRequestServiceImpl;
	
	@Mock
	BloodComponentTypeServiceImpl bloodComponentTypeServiceImpl;
	
	@Mock
	EpidemicOutbreakServiceImpl epidemicOutbreakServiceImpl;
	
	@Mock
	OrganDonationServiceImpl organDonationServiceImpl;
	
	@Mock
	DirectoryServiceImpl directoryServiceImpl;
	
	@Mock
	FoodSafetyCopmlaintServiceImpl foodSafetyCopmlaintServiceImpl;
	
	
	@Test
	public void getSioHistoryTest()
	{
		List<M_ComponentType> list=Lists.newArrayList();
		M_ComponentType m_ComponentType=new M_ComponentType();
		m_ComponentType.setComponentType("type");
		list.add(m_ComponentType);
		try {
			doReturn(list).when(bloodComponentTypeServiceImpl).getBloodComponentTypes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=sioHistoryController.getSioHistory("{\"benificiaryRegID\":101}");
		assertTrue(response.contains("\"componentType\":\"type\""));
	}
	
	@Test
	public void getSioHistoryExceptionTest()
	{
		List<M_ComponentType> list=Lists.newArrayList();
		M_ComponentType m_ComponentType=new M_ComponentType();
		m_ComponentType.setComponentType("type");
		list.add(m_ComponentType);
		try {
			doThrow(Exception.class).when(bloodComponentTypeServiceImpl).getBloodComponentTypes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=sioHistoryController.getSioHistory("{\"benificiaryRegID\":101}");
		assertFalse(response.contains("\"componentType\":\"type\""));
	}
	@Test
	public void getSioHistoryJSONExceptionTest()
	{
		List<M_ComponentType> list=Lists.newArrayList();
		M_ComponentType m_ComponentType=new M_ComponentType();
		m_ComponentType.setComponentType("type");
		list.add(m_ComponentType);
		try {
			doThrow(JSONException.class).when(bloodComponentTypeServiceImpl).getBloodComponentTypes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=sioHistoryController.getSioHistory("{\"benificiaryRegID\":101}");
		assertTrue(response.contains("Invalid object conversion"));
	}
}
