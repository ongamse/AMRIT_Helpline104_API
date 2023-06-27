package com.iemr.helpline104.controller.prescription;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.prescription.Prescription;
import com.iemr.helpline104.service.prescription.PrescriptionServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PrescriptionControllerTest {

	@InjectMocks
	PrescriptionController prescriptionController;
	
	@Mock
	PrescriptionServiceImpl prescriptionServiceImpl;
	
	@Test
	public void savePrescriptionTest()
	{
		Prescription t_Prescription=new Prescription();
		t_Prescription.setPrescriptionID(new Long("101"));
		doReturn(t_Prescription).when(prescriptionServiceImpl).savePrescription(Mockito.anyObject());
		String response=prescriptionController.savePrescription(t_Prescription.toString());
		assertTrue(response.contains("\"prescriptionID\":101"));
		
	}
	@Test
	public void savePrescriptionExceptionTest()
	{
		Prescription t_Prescription=new Prescription();
		t_Prescription.setPrescriptionID(new Long("101"));
		doThrow(Exception.class).when(prescriptionServiceImpl).savePrescription(Mockito.anyObject());
		String response=prescriptionController.savePrescription(t_Prescription.toString());
		assertFalse(response.contains("\"prescriptionID\":101"));
		assertTrue(response.contains("Failed with null"));
		
	}
	
	@Test
	public void getPrescriptionTest()
	{
		Prescription t_Prescription=new Prescription();
		t_Prescription.setPrescriptionID(new Long("101"));
		List<Prescription> list=Lists.newArrayList();
		list.add(t_Prescription);
		doReturn(list).when(prescriptionServiceImpl).getPrescription(Mockito.anyLong(),Mockito.anyLong());
		String response=prescriptionController.getPrescription(t_Prescription.toString());
		assertTrue(response.contains("\"prescriptionID\":101"));
		
	}
	@Test
	public void getPrescriptionTest1()
	{
		Prescription t_Prescription=new Prescription();
		doReturn(null).when(prescriptionServiceImpl).getPrescription(Mockito.anyLong(),Mockito.anyLong());
		String response=prescriptionController.getPrescription(t_Prescription.toString());
		assertFalse(response.contains("prescriptionID"));
		assertTrue(response.contains("prescription not available with that prescription or beneficiary ID"));
		
	}
	@Test
	public void getPrescriptionTestException()
	{
		Prescription t_Prescription=new Prescription();
		doThrow(Exception.class).when(prescriptionServiceImpl).getPrescription(Mockito.anyLong(),Mockito.anyLong());
		String response=prescriptionController.getPrescription(t_Prescription.toString());
		assertFalse(response.contains("prescriptionID"));
		assertTrue(response.contains("Failed with null"));
		
	}
	
	@Test
	public void getPrescriptionListTest()
	{
		Prescription t_Prescription=new Prescription();
		t_Prescription.setPrescriptionID(new Long("101"));
		List<Prescription> list=Lists.newArrayList();
		list.add(t_Prescription);
		doReturn(list).when(prescriptionServiceImpl).getPrescriptionList(Mockito.anyLong(),Mockito.anyObject());
		String response=prescriptionController.getPrescriptionList(t_Prescription.toString());
		assertTrue(response.contains("\"prescriptionID\":101"));
	}
	@Test
	public void getPrescriptionListTest1()
	{
		Prescription t_Prescription=new Prescription();
		t_Prescription.setPrescriptionID(new Long("101"));
		doReturn(null).when(prescriptionServiceImpl).getPrescriptionList(Mockito.anyLong(),Mockito.anyObject());
		String response=prescriptionController.getPrescriptionList(t_Prescription.toString());
		assertFalse(response.contains("\"prescriptionID\":101"));
		assertTrue(response.contains("prescription not available with that prescription or beneficiary ID"));
	}
	@Test
	public void getPrescriptionListExceptionTest()
	{
		Prescription t_Prescription=new Prescription();
		t_Prescription.setPrescriptionID(new Long("101"));
		doThrow(Exception.class).when(prescriptionServiceImpl).getPrescriptionList(Mockito.anyLong(),Mockito.anyObject());
		String response=prescriptionController.getPrescriptionList(t_Prescription.toString());
		assertFalse(response.contains("\"prescriptionID\":101"));
		assertTrue(response.contains("Failed with null"));
	}
	
	@Test
	public void getLatestValidPescriptionTest()
	{
		Prescription t_Prescription=new Prescription();
		t_Prescription.setPrescriptionID(new Long("101"));
		List<Prescription> list=Lists.newArrayList();
		list.add(t_Prescription);
		doReturn(list).when(prescriptionServiceImpl).getLatestValidPescription(Mockito.anyLong(),Mockito.anyObject());
		String response=prescriptionController.getLatestValidPescription(t_Prescription.toString());
		assertTrue(response.contains("\"prescriptionID\":101"));
	}
	
	@Test
	public void getLatestValidPescriptionTest1()
	{
		Prescription t_Prescription=new Prescription();
		t_Prescription.setPrescriptionID(new Long("101"));
		doReturn(null).when(prescriptionServiceImpl).getLatestValidPescription(Mockito.anyLong(),Mockito.anyObject());
		String response=prescriptionController.getLatestValidPescription(t_Prescription.toString());
		assertFalse(response.contains("\"prescriptionID\":101"));
		assertTrue(response.contains("prescription not available with the beneficiaryID"));
	}
	
	@Test
	public void getLatestValidPescriptionExceptionTest()
	{
		Prescription t_Prescription=new Prescription();
		t_Prescription.setPrescriptionID(new Long("101"));
		doThrow(Exception.class).when(prescriptionServiceImpl).getLatestValidPescription(Mockito.anyLong(),Mockito.anyObject());
		String response=prescriptionController.getLatestValidPescription(t_Prescription.toString());
		assertFalse(response.contains("\"prescriptionID\":101"));
		assertTrue(response.contains("Failed with null"));
	}
}
