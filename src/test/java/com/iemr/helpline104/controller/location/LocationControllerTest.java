package com.iemr.helpline104.controller.location;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.location.DistrictBlock;
import com.iemr.helpline104.data.location.Districts;
import com.iemr.helpline104.data.location.States;
import com.iemr.helpline104.service.location.LocationService;

@RunWith(MockitoJUnitRunner.class)
public class LocationControllerTest {

	@InjectMocks
	LocationController locationController;
	
	@Mock
	LocationService locationService;
	
	@Test
	public void getStatesTest()
	{
		List<States> stateList=Lists.newArrayList();
		States states=new States();
		states.setStateID(101);
		stateList.add(states);
		doReturn(stateList).when(locationService).getStates(Mockito.anyInt());
		String response=locationController.getStates(Mockito.anyInt());
		assertTrue(response.contains("\"stateID\":101"));
	}
	
	@Test
	public void getDistrictsTest()
	{
		List<Districts> districtsList=Lists.newArrayList();
		Districts districts=new Districts();
		districts.setDistrictID(101);
		districtsList.add(districts);
		doReturn(districtsList).when(locationService).getDistricts(Mockito.anyInt());
		String response=locationController.getDistricts(Mockito.anyInt());
		assertTrue(response.contains("\"districtID\":101"));
	}
	
	@Test
	public void geStatetDistrictsTest()
	{
		List<Districts> districtsList=Lists.newArrayList();
		Districts districts=new Districts();
		districts.setDistrictID(101);
		districtsList.add(districts);
		doReturn(districtsList).when(locationService).findStateDistrictBy(Mockito.anyInt());
		String response=locationController.geStatetDistricts(Mockito.anyInt());
		assertTrue(response.contains("\"districtID\":101"));
	}
	
	@Test
	public void getDistrictBlocksTest()
	{
		List<DistrictBlock> districtBlockList=Lists.newArrayList();
		DistrictBlock districtBlock=new DistrictBlock();
		districtBlock.setBlockID(101);
		districtBlockList.add(districtBlock);
		doReturn(districtBlockList).when(locationService).getDistrictBlocks(Mockito.anyInt());
		String response=locationController.getDistrictBlocks(Mockito.anyInt());
		assertTrue(response.contains("\"blockID\":101"));
	}
	
	@Test
	public void getCityTest()
	{
		List<DistrictBlock> districtBlockList=Lists.newArrayList();
		DistrictBlock districtBlock=new DistrictBlock();
		districtBlock.setBlockID(101);
		districtBlockList.add(districtBlock);
		doReturn(districtBlockList).when(locationService).getDistrictBlocks(Mockito.anyInt());
		String response=locationController.getCity(Mockito.anyInt());
		assertTrue(response.contains("\"blockID\":101"));
	}
	
	@Test
	public void getVillagesTest()
	{
		List<DistrictBlock> districtBlockList=Lists.newArrayList();
		DistrictBlock districtBlock=new DistrictBlock();
		districtBlock.setBlockID(101);
		districtBlockList.add(districtBlock);
		doReturn(districtBlockList).when(locationService).getDistrictBlocks(Mockito.anyInt());
		String response=locationController.getVillages(Mockito.anyInt());
		assertTrue(response.contains("\"blockID\":101"));
	}
}
