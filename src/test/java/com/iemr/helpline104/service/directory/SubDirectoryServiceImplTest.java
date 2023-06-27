package com.iemr.helpline104.service.directory;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.directory.Directory;
import com.iemr.helpline104.data.directory.SubDirectory;
import com.iemr.helpline104.repository.directory.SubDirectoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class SubDirectoryServiceImplTest {

	@InjectMocks
	SubDirectoryServiceImpl subDirectoryServiceImpl;
	
	@Mock
	SubDirectoryRepository subDirectoryRepository;
	
	@Test
	public void getSubDirectoriesTest()
	{
		Set<Objects[]> directoryServices=Sets.newHashSet();
		Objects[] array=new Objects[5];
		directoryServices.add(array);
		doReturn(directoryServices).when(subDirectoryRepository).findAciveSubDirectories(Mockito.anyInt());
		List<SubDirectory> list=subDirectoryServiceImpl.getSubDirectories(Mockito.anyInt());
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void getSubDirectoriesTest1()
	{
		List<SubDirectory> list=subDirectoryServiceImpl.getSubDirectories(Mockito.anyInt());
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void getSubDirectoriesTest2()
	{

		Set<Object[]> set=Sets.newHashSet();
		Object[] array=new Object[2];
		array[0]=101;
		array[1]="subDirectory";
		
		set.add(array);
		try {
			doReturn(set).when(subDirectoryRepository).findAciveSubDirectories(Mockito.anyInt());
			List<SubDirectory> directory= subDirectoryServiceImpl.getSubDirectories(Mockito.anyInt());
			assertTrue(directory.toString().contains("\"instituteSubDirectoryName\":\"subDirectory\""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
