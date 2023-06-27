package com.iemr.helpline104.controller.NKSHPscheme;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.iemr.helpline104.controller.scheme.SchemeController;
import com.iemr.helpline104.data.scheme.T_Schemeservice;
import com.iemr.helpline104.service.scheme.SchemeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class NKSHPschemeControllerTest {

	@InjectMocks
	SchemeController nKSHPschemeController;
	
	@Mock
	SchemeServiceImpl nkshpschemeServiceImpl;
	
	@Test
	public void getNKSHPschemeListTest()
	{
		T_Schemeservice m_scheme=new T_Schemeservice();
		//m_scheme.setSchemeName("scheme");
		
		ArrayList<Object[]> obj=Lists.newArrayList();
		Object[] array=new Object[2];
		array[0]=m_scheme;
		obj.add(array);
		
		try {
			doReturn(obj).when(nkshpschemeServiceImpl).saveSchemeSearchHistory(Mockito.any());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=nKSHPschemeController.saveSchemeSearchHistory(m_scheme.toString());
		assertTrue(response.contains("\"status\":\"Success\""));
	}
	@Test
	public void getNKSHPschemeListTest1()
	{	
		T_Schemeservice m_scheme=new T_Schemeservice();
		try {
			doReturn(null).when(nkshpschemeServiceImpl).saveSchemeSearchHistory(Mockito.any());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=nKSHPschemeController.saveSchemeSearchHistory(m_scheme.toString());
		assertTrue(response.contains("No schemes available"));
	}
	@Test
	public void getNKSHPschemeListExceptionTest()
	{	
		T_Schemeservice m_scheme=new T_Schemeservice();
		try {
			doThrow(Exception.class).when(nkshpschemeServiceImpl).saveSchemeSearchHistory(Mockito.any());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=nKSHPschemeController.saveSchemeSearchHistory(m_scheme.toString());
		assertFalse(response.contains("\"status\":\"Success\""));
	}
}
