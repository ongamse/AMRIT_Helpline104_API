package com.iemr.helpline104.service.userbeneficiarydata;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.userbeneficiarydata.M_Community;
import com.iemr.helpline104.repository.beneficiary.CommunityRepository;

@RunWith(MockitoJUnitRunner.class)
public class CommunityServiceImplTest {
	
	@InjectMocks
	CommunityServiceImpl communityServiceImpl;
	
	@Mock
	CommunityRepository communityRepository;
	
	@Test
	public void getActiveCommunitiesTest()
	{
		Set<Object[]> set=Sets.newHashSet();
		Object[] array=new Object[2];
		array[0]=101;
		array[1]="community";
		set.add(array);
		try {
			doReturn(set).when(communityRepository).findAciveCommunities();
			List<M_Community> M_Communitys= communityServiceImpl.getActiveCommunities();
			assertTrue(M_Communitys.toString().contains("\"CommunityType\":\"community\""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getActiveCommunitiesTest1()
	{
		Set<Object[]> set=Sets.newHashSet();
		try {
			doReturn(set).when(communityRepository).findAciveCommunities();
			List<M_Community> M_Communitys= communityServiceImpl.getActiveCommunities();
			assertTrue(M_Communitys.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
