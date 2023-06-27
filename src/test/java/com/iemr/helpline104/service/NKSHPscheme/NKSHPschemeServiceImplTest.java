package com.iemr.helpline104.service.NKSHPscheme;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.repository.scheme.SchemeRepository;
import com.iemr.helpline104.service.scheme.SchemeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class NKSHPschemeServiceImplTest {
	
	@InjectMocks
	SchemeServiceImpl nKSHPschemeServiceImpl;
	
	@Mock
	SchemeRepository nkshpschemeRepository;
	
	@Test
	public void getNKSHPSchemeListTest()
	{
		/*
		try {
			List<Objects[]> list=nKSHPschemeServiceImpl.saveSchemeSearchHistory(Mockito.anyInt());
			assertFalse(!list.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		
	}
}
