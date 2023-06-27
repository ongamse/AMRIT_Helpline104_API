package com.iemr.helpline104.controller.epidemicOutbreak;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.epidemicOutbreak.T_EpidemicOutbreak;
import com.iemr.helpline104.service.epidemicOutbreak.EpidemicOutbreakServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EpidemicOutbreakControllerTest {

	@InjectMocks
	EpidemicOutbreakController EpidemicOutbreakController;

	@Mock
	EpidemicOutbreakServiceImpl epidemicOutbreakServiceImpl;

	@Test
	public void saveEpidemicOutbreakComplaintTest() {
		T_EpidemicOutbreak t_EpidemicOutbreak = new T_EpidemicOutbreak();
		t_EpidemicOutbreak.setOutbreakComplaintID(new Long("101"));
		HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
		try {
			doReturn(t_EpidemicOutbreak).when(epidemicOutbreakServiceImpl).save(Mockito.any(),
					Mockito.any(HttpServletRequest.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = EpidemicOutbreakController.saveEpidemicOutbreakComplaint(t_EpidemicOutbreak.toString(),
				httpServletRequest);
		assertTrue(response.contains("\"outbreakComplaintID\":101"));
	}

	@Test
	public void saveEpidemicOutbreakComplaintExceptionTest() {
		T_EpidemicOutbreak t_EpidemicOutbreak = new T_EpidemicOutbreak();
		t_EpidemicOutbreak.setOutbreakComplaintID(new Long("101"));
		HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
		try {
			doThrow(Exception.class).when(epidemicOutbreakServiceImpl).save(Mockito.any(),
					Mockito.any(HttpServletRequest.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = EpidemicOutbreakController.saveEpidemicOutbreakComplaint(t_EpidemicOutbreak.toString(),
				httpServletRequest);
		assertFalse(response.contains("\"outbreakComplaintID\":101"));
	}

	@Test
	public void getEpidemicOutbreakComplaintTest() {
		T_EpidemicOutbreak t_EpidemicOutbreak = new T_EpidemicOutbreak();
		t_EpidemicOutbreak.setOutbreakComplaintID(new Long("101"));
		List<T_EpidemicOutbreak> list = Lists.newArrayList();
		list.add(t_EpidemicOutbreak);
		try {
			doReturn(list).when(epidemicOutbreakServiceImpl).getEpidemicOutbreakComplaints(Mockito.anyLong(), null,
					null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = EpidemicOutbreakController.getEpidemicOutbreakComplaint(t_EpidemicOutbreak.toString());
		assertTrue(response.contains("\"outbreakComplaintID\":101"));
	}

	@Test
	public void getEpidemicOutbreakComplaintExceptionTest() {
		T_EpidemicOutbreak t_EpidemicOutbreak = new T_EpidemicOutbreak();
		t_EpidemicOutbreak.setOutbreakComplaintID(new Long("101"));
		try {
			doThrow(Exception.class).when(epidemicOutbreakServiceImpl).getEpidemicOutbreakComplaints(Mockito.anyLong(),
					null, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = EpidemicOutbreakController.getEpidemicOutbreakComplaint(t_EpidemicOutbreak.toString());
		assertFalse(response.contains("\"outbreakComplaintID\":101"));
	}
}
