package com.iemr.helpline104.service.bloodComponentType;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.bloodComponentType.M_BloodGroup;
import com.iemr.helpline104.data.bloodComponentType.M_ComponentType;
import com.iemr.helpline104.repository.bloodComponentType.BloodComponentTypeRepository;

@RunWith(MockitoJUnitRunner.class)
public class BloodComponentTypeServiceImplTest {

	@InjectMocks
	BloodComponentTypeServiceImpl bloodComponentTypeServiceImpl;
	
	@Mock
	BloodComponentTypeRepository componentTypeRepository;
	
	@Test
	public void getBloodComponentTypes()
	{
		try {
			List<M_ComponentType> componentTypeList=bloodComponentTypeServiceImpl.getBloodComponentTypes();
			assertTrue(componentTypeList.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void getBloodComponentTypes1()
	{
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[3];
		array[0]=101;
		array[1]="componentTypeValue";
		array[2]="componentTypeDescValue";

		list.add(array);
		try {
			doReturn(list).when(componentTypeRepository).getComponentTypes();
			List<M_ComponentType> componentTypeList=bloodComponentTypeServiceImpl.getBloodComponentTypes();
			assertTrue(componentTypeList.toString().contains("\"componentType\":\"componentTypeValue\""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getBloodGroupsTest()
	{
		try {
			List<M_BloodGroup> list=bloodComponentTypeServiceImpl.getBloodGroups();
			assertTrue(list.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void getBloodGroupsTest1()
	{
		
		ArrayList<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[3];
		array[0]=101;
		array[1]="bloodGroupValue";
		array[2]="bloodGroupDescValue";

		list.add(array);
		try {
			doReturn(list).when(componentTypeRepository).getBloodGroups();
			List<M_BloodGroup> list1=bloodComponentTypeServiceImpl.getBloodGroups();
			assertTrue(list1.toString().contains("\"bloodGroupDesc\":\"bloodGroupDescValue\""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
