package com.iemr.helpline104.controller.directory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.iemr.helpline104.data.directory.Directoryservice;
import com.iemr.helpline104.service.directory.DirectoryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DirectoryServicesControllerTest {

	@InjectMocks
	DirectoryServicesController directoryServicesController;
	
	@Mock
	DirectoryServiceImpl directoryServiceImpl;
	
	@Test
	public void getBenDirectoryHistoryTest()
	{
		Directoryservice directoryservice=new Directoryservice(new Long("101"),"institutionName","address","instituteDirectoryName","instituteSubDirectoryName");
		List<Directoryservice> list=Lists.newArrayList();
		list.add(directoryservice);
		doReturn(list).when(directoryServiceImpl).getDirectorySearchHistory(Mockito.anyLong(),Mockito.anyLong());
		String response=directoryServicesController.getBenDirectoryHistory(directoryservice.toString());
		assertTrue(response.contains("\"directoryServiceID\":101"));
	}
	@Test
	public void getBenDirectoryHistoryExceptionTest()
	{
		Directoryservice directoryservice=new Directoryservice(new Long("101"),"institutionName","address","instituteDirectoryName","instituteSubDirectoryName");
		doThrow(Exception.class).when(directoryServiceImpl).getDirectorySearchHistory(Mockito.anyLong(),Mockito.anyLong());
		String response=directoryServicesController.getBenDirectoryHistory(directoryservice.toString());
		assertFalse(response.contains("\"directoryServiceID\":101"));
	}
	@Test
	public void directorySearchHistoryTest()
	{
		Directoryservice directoryservice=new Directoryservice(new Long("101"),"institutionName","address","instituteDirectoryName","instituteSubDirectoryName");
		List<Directoryservice> list=Lists.newArrayList();
		list.add(directoryservice);
		doReturn(list.toString()).when(directoryServiceImpl).saveDirectorySearchHistory(Mockito.any(Directoryservice[].class));
		String response=directoryServicesController.directorySearchHistory(list.toString());
		assertTrue(response.contains("\"directoryServiceID\":101"));
	}
	@Test
	public void directorySearchHistoryExceptionTest()
	{
		Directoryservice directoryservice=new Directoryservice(new Long("101"),"institutionName","address","instituteDirectoryName","instituteSubDirectoryName");
		List<Directoryservice> list=Lists.newArrayList();
		list.add(directoryservice);
		doThrow(Exception.class).when(directoryServiceImpl).saveDirectorySearchHistory(Mockito.any(Directoryservice[].class));
		String response=directoryServicesController.directorySearchHistory(list.toString());
		assertFalse(response.contains("\"directoryServiceID\":101"));
	}
}
