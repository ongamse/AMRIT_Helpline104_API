package com.iemr.helpline104.controller.organDonation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.iemr.helpline104.data.organDonation.M_DonatableOrgan;
import com.iemr.helpline104.data.organDonation.M_DonationType;
import com.iemr.helpline104.data.organDonation.OrganDonations;
import com.iemr.helpline104.data.organDonation.T_OrganDonation;
import com.iemr.helpline104.service.organDonation.OrganDonationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OrganDonationControllerTest {

	@InjectMocks
	OrganDonationController organDonationController;
	
	@Mock
	OrganDonationServiceImpl organDonationServiceImpl;
	
	@Test
	public void saveOrganDonationDetailsTest()
	{
		OrganDonations organDonations=new OrganDonations();
		T_OrganDonation t_organDonations=new T_OrganDonation();
		t_organDonations.setBeneficiaryRegID(new Long("101"));
		t_organDonations.setDonatableOrganID(102);
		List<T_OrganDonation> list=new ArrayList<T_OrganDonation>();
		list.add(t_organDonations);
		organDonations.setT_organDonations(list);
		try {
			doReturn(list.toString()).when(organDonationServiceImpl).save(Mockito.any());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=organDonationController.saveOrganDonationDetails("{\"organDonationID\":107}");
		assertTrue(response.contains("\"beneficiaryRegID\":101"));
	}
	@Test
	public void saveOrganDonationDetailsExceptionTest()
	{

		try {
			doThrow(Exception.class).when(organDonationServiceImpl).save(Mockito.any());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=organDonationController.saveOrganDonationDetails("{\"organDonationID\":107}");
		assertFalse(response.contains("beneficiaryRegID"));
		assertTrue(response.contains("Failed with null"));
	}
	@Test
	public void getOrganDonationDetailsTest()
	{
		T_OrganDonation t_organDonations=new T_OrganDonation();
		t_organDonations.setBeneficiaryRegID(new Long("101"));
		t_organDonations.setDonatableOrganID(102);
		List<T_OrganDonation> list=new ArrayList<T_OrganDonation>();
		list.add(t_organDonations);
		
		try {
			doReturn(list).when(organDonationServiceImpl).getOrganDonationRequests(Mockito.anyLong(),null,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=organDonationController.getOrganDonationDetails("{\"organDonationID\":107}");
		assertTrue(response.contains("\"beneficiaryRegID\":101"));
	}
	@Test
	public void getOrganDonationDetailsExceptionTest()
	{
		
		try {
			doThrow(Exception.class).when(organDonationServiceImpl).getOrganDonationRequests(Mockito.anyLong(),null,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=organDonationController.getOrganDonationDetails("{\"organDonationID\":107}");
		assertFalse(response.contains("\"beneficiaryRegID\":101"));
		assertTrue(response.contains("Failed with null"));
	}
	@Test
	public void getOrganDonationTypesTest()
	{
		List<M_DonationType> list=Lists.newArrayList();
		M_DonationType m_DonationType=new M_DonationType();
		m_DonationType.setDonationType("donationType");
		list.add(m_DonationType);
		try {
			doReturn(list).when(organDonationServiceImpl).getDonationTypes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=organDonationController.getOrganDonationTypes();
		assertTrue(response.contains("\"donationType\":\"donationType\""));
	}
	@Test
	public void getOrganDonationTypesExceptionTest()
	{
		try {
			doThrow(Exception.class).when(organDonationServiceImpl).getDonationTypes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=organDonationController.getOrganDonationTypes();
		assertFalse(response.contains("\"donationType\":\"donationType\""));
		assertTrue(response.contains("Failed with null"));
	}
	
	@Test
	public void getDonatableOrgansTest()
	{
		List<M_DonatableOrgan> list =Lists.newArrayList();
		M_DonatableOrgan m_DonatableOrgan=new M_DonatableOrgan();
		m_DonatableOrgan.setDonatableOrgan("Kindney");
		list.add(m_DonatableOrgan);
		
		try {
			doReturn(list).when(organDonationServiceImpl).getDonatableOrgans();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=organDonationController.getDonatableOrgans();
		assertTrue(response.contains("\"donatableOrgan\":\"Kindney\""));
	}
	
	@Test
	public void getDonatableOrgansExceptionTest()
	{
		
		try {
			doThrow(Exception.class).when(organDonationServiceImpl).getDonatableOrgans();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=organDonationController.getDonatableOrgans();
		assertFalse(response.contains("\"donatableOrgan\":\"Kindney\""));
		assertTrue(response.contains("Failed with null"));
	}
}
