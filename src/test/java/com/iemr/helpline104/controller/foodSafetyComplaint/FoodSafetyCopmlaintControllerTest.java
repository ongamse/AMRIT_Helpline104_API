package com.iemr.helpline104.controller.foodSafetyComplaint;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.foodSafetyCopmlaint.T_FoodSafetyCopmlaint;
import com.iemr.helpline104.service.foodSafetyCopmlaint.FoodSafetyCopmlaintServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class FoodSafetyCopmlaintControllerTest {

	@InjectMocks
	FoodSafetyCopmlaintController foodSafetyCopmlaintController;

	@Mock
	FoodSafetyCopmlaintServiceImpl foodSafetyCopmlaintServiceImpl;

	@Test
	public void saveFoodComplaintDetailsTest() {
		short a = 2;
		byte b = 0;

		Date date = new Date(2018 - 03 - 20);
		Timestamp timestamp = new Timestamp(2018 - 03 - 20);

		T_FoodSafetyCopmlaint t_FoodSafetyCopmlaint = new T_FoodSafetyCopmlaint(new Long("106"), "", new Long("106"),
				"", b, b, b, b, b, b, b, timestamp, "", b, "", "", "", a, "", "", date, true, 1, "", 1, "", 1, "");
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		try {
			doReturn(t_FoodSafetyCopmlaint).when(foodSafetyCopmlaintServiceImpl).save(Mockito.any(),
					Mockito.any(HttpServletRequest.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String
		// response=foodSafetyCopmlaintController.saveFoodComplaintDetails(t_FoodSafetyCopmlaint.toString(),request);
		// assertTrue(response.contains("\"beneficiaryRegID\":106"));
	}

	@Test
	public void saveFoodComplaintDetailsExceptionTest() {
		T_FoodSafetyCopmlaint t_FoodSafetyCopmlaint = new T_FoodSafetyCopmlaint();
		t_FoodSafetyCopmlaint.setTypeOfFood("food");
		t_FoodSafetyCopmlaint.setBeneficiaryRegID(new Long("106"));
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		try {
			doThrow(Exception.class).when(foodSafetyCopmlaintServiceImpl).save(Mockito.any(),
					Mockito.any(HttpServletRequest.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = foodSafetyCopmlaintController.saveFoodComplaintDetails(t_FoodSafetyCopmlaint.toString(),
				request);
		assertFalse(response.contains("\"beneficiaryRegID\":106"));
	}

	@Test
	public void getFoodComplaintDetailsExceptionTest() {
		T_FoodSafetyCopmlaint t_FoodSafetyCopmlaint = new T_FoodSafetyCopmlaint();
		t_FoodSafetyCopmlaint.setTypeOfFood("food");
		t_FoodSafetyCopmlaint.setBeneficiaryRegID(new Long("106"));
		try {
			doThrow(Exception.class).when(foodSafetyCopmlaintServiceImpl).getFoodSafetyComplaints(Mockito.anyLong(),
					null, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = foodSafetyCopmlaintController.getFoodComplaintDetails(t_FoodSafetyCopmlaint.toString());
		assertFalse(response.contains("\"beneficiaryRegID\":106"));
	}

	@Test
	public void getFoodComplaintDetailsTest() {
		T_FoodSafetyCopmlaint t_FoodSafetyCopmlaint = new T_FoodSafetyCopmlaint();
		t_FoodSafetyCopmlaint.setTypeOfFood("food");
		t_FoodSafetyCopmlaint.setBeneficiaryRegID(new Long("106"));
		List<T_FoodSafetyCopmlaint> foodComplaint = Lists.newArrayList();
		foodComplaint.add(t_FoodSafetyCopmlaint);
		try {
			doReturn(foodComplaint).when(foodSafetyCopmlaintServiceImpl).getFoodSafetyComplaints(Mockito.anyLong(),
					null, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = foodSafetyCopmlaintController.getFoodComplaintDetails(t_FoodSafetyCopmlaint.toString());
		assertTrue(response.contains("\"beneficiaryRegID\":106"));
	}
}
