package com.iemr.helpline104.service.userbeneficiarydata;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.userbeneficiarydata.M_Status;
import com.iemr.helpline104.data.userbeneficiarydata.M_Title;
import com.iemr.helpline104.repository.userbeneficiarydata.TitleRepository;

@RunWith(MockitoJUnitRunner.class)
public class TitleServiceImplTest {
	
	@InjectMocks
	TitleServiceImpl titleServiceImpl;
	
	@Mock
	TitleRepository titleRepository;
	
	@Test
	public void getActiveTitlesTest()
	{
		HashSet<Object[]> set=Sets.newHashSet();
		Object[] array=new Object[3];
		array[0]=101;
		array[1]="title";
		array[2]="abc";
		set.add(array);
		try {
			doReturn(set).when(titleRepository).findAciveTitles();
			List<M_Title> m_Title= titleServiceImpl.getActiveTitles();
			//assertTrue(m_Title.toString().contains("title"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void getActiveTitlesTest1()
	{
		Set<Object[]> set=Sets.newHashSet();
		try {
			doReturn(set).when(titleRepository).findAciveTitles();
			List<M_Title> m_Title= titleServiceImpl.getActiveTitles();
			assertFalse(!m_Title.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getActiveTitlesTest2()
	{
		try {
			List<M_Title> m_Title= titleServiceImpl.getActiveTitles();
			assertFalse(!m_Title.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
