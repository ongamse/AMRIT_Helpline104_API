package com.iemr.helpline104.service.prescription;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.prescription.PrescribedDrug;
import com.iemr.helpline104.data.prescription.Prescription;
import com.iemr.helpline104.repository.prescription.PrescribedDrugRepository;
import com.iemr.helpline104.repository.prescription.PrescriptionRepository;

@RunWith(MockitoJUnitRunner.class)
public class PrescriptionServiceImplTest {
	
	@InjectMocks
	PrescriptionServiceImpl prescriptionServiceImpl;
	
	@Mock
	PrescriptionRepository prescriptionRepository;
	
	@Mock
	PrescribedDrugRepository prescribedDrugRepository;
	
	@Test
	public void savePrescriptionTest()
	{
		Prescription t_prescription =new Prescription ();
		t_prescription.setPrescriptionID(102L);
		List<PrescribedDrug> list=Lists.newArrayList();
		PrescribedDrug prescribedDrug=new PrescribedDrug(1L,101,"","","","","",101,"","",new Timestamp(Calendar.getInstance().getTimeInMillis()));
		prescribedDrug.setPrescriptionID(101L);
		list.add(prescribedDrug);
		t_prescription.setPrescribedDrugs(list);
		doReturn(t_prescription).when(prescriptionRepository).save(t_prescription);
		Prescription prescription= prescriptionServiceImpl.savePrescription(t_prescription);
		assertTrue(prescription.getPrescriptionID()==102L);
	}
	@Test
	public void savePrescriptionTest1()
	{
		Prescription t_prescription =new Prescription ();
		List<PrescribedDrug> list=Lists.newArrayList();
		t_prescription.setPrescribedDrugs(list);
		doReturn(t_prescription).when(prescriptionRepository).save(t_prescription);
		Prescription prescription= prescriptionServiceImpl.savePrescription(t_prescription);
		assertFalse(null!=prescription.getPrescriptionID());
	}
	@Test
	public void getPrescriptionListTest()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[20];
		array[0]=101L;
		array[1]=101L;
		array[2]=101L;
		array[3]="request";
		array[4]="request";
		array[5]=new Date(Calendar.getInstance().getTimeInMillis());
		array[6]="request";
		
		
		list.add(array);
		try {
			doReturn(list).when(prescriptionRepository).getPrescriptionList(Mockito.anyObject(),Mockito.anyObject());
			List<Prescription> t_Prescriptions= prescriptionServiceImpl.getPrescriptionList(Mockito.anyObject(),Mockito.anyObject());
			Prescription t_Prescription=t_Prescriptions.get(0);
			assertTrue(t_Prescription.getPrescriptionID()==101L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getPrescriptionListTest1()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[20];
		array[0]=101L;
		array[1]=101L;
		array[2]=101L;
		array[3]="request";
		array[4]="request";
		array[5]=new Date(Calendar.getInstance().getTimeInMillis());
		array[6]="request";
		
		
		list.add(array);
		
		
		ArrayList<Object[]> list1=Lists.newArrayList();
		Object[] array1=new Object[20];
		array1[0]=101;
		array1[1]="";
		array1[2]="";
		array1[3]="request";
		array1[4]="request";
		array1[5]="";
		array1[6]=101;
		array1[7]="";
		array1[8]="";
		array1[9]=new Timestamp(Calendar.getInstance().getTimeInMillis());
		
		
		list1.add(array1);
		try {
			doReturn(list).when(prescriptionRepository).getPrescriptionList(Mockito.anyObject(),Mockito.anyObject());
			doReturn(list1).when(prescribedDrugRepository).getPrescribedDrugs(Mockito.anyLong());
			
			
			List<Prescription> t_Prescriptions= prescriptionServiceImpl.getPrescriptionList(Mockito.anyObject(),Mockito.anyObject());
			Prescription t_Prescription=t_Prescriptions.get(0);
			assertTrue(t_Prescription.getPrescriptionID()==101L);
			assertTrue(t_Prescription.getPrescribedDrugs().get(0).getNoOfDays()==101);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getLatestValidPescriptionTest()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[20];
		array[0]=101L;
		array[1]=101L;
		array[2]=101L;
		array[3]="request";
		array[4]="request";
		array[5]=new Date(Calendar.getInstance().getTimeInMillis()); 
		array[6]="request";
		
		
		list.add(array);
		
		ArrayList<Object[]> list1=Lists.newArrayList();
		Object[] array1=new Object[20];
		array1[0]=101;
		array1[1]="";
		array1[2]="";
		array1[3]="request";
		array1[4]="request";
		array1[5]="";
		array1[6]=101;
		array1[7]="";
		array1[8]="";
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR,8000);
		array1[9]=new Timestamp(cal.getTimeInMillis());
		
		
		list1.add(array1);
		try {
			doReturn(list).when(prescriptionRepository).getLatestValidPescription(Mockito.anyObject(),Mockito.anyObject());
			
			doReturn(list1).when(prescribedDrugRepository).getPrescribedDrugs(Mockito.anyLong());
			
			List<Prescription> t_Prescriptions= prescriptionServiceImpl.getLatestValidPescription(Mockito.anyObject(),Mockito.anyObject());
			Prescription t_Prescription=t_Prescriptions.get(0);
			assertTrue(t_Prescription.getPrescriptionID()==101L);
			assertTrue(t_Prescription.getPrescribedDrugs().get(0).getNoOfDays()==101);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getLatestValidPescriptionTest1()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[20];
		array[0]=101L;
		array[1]=101L;
		array[2]=101L;
		array[3]="request";
		array[4]="request";
		array[5]=new Date(Calendar.getInstance().getTimeInMillis()); 
		array[6]="request";
		
		
		list.add(array);
		try {
			doReturn(list).when(prescriptionRepository).getLatestValidPescription(Mockito.anyObject(),Mockito.anyObject());
			List<Prescription> t_Prescriptions= prescriptionServiceImpl.getLatestValidPescription(Mockito.anyObject(),Mockito.anyObject());
			assertTrue(t_Prescriptions.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
