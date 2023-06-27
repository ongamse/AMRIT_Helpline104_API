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

import com.iemr.helpline104.data.userbeneficiarydata.M_Language;
import com.iemr.helpline104.repository.userbeneficiarydata.LanguageRepository;

@RunWith(MockitoJUnitRunner.class)
public class LanguageServiceImplTest {
	
	@InjectMocks
	LanguageServiceImpl languageServiceImpl;
	
	@Mock
	LanguageRepository languageRepository;
	
	@Test
	public void getActiveLanguagesTest()
	{
		Set<Object[]> set=Sets.newHashSet();
		Object[] array=new Object[2];
		array[0]=101;
		array[1]="Language";
		set.add(array);
		try {
			doReturn(set).when(languageRepository).findAciveLanguages();
			List<M_Language> m_Language= languageServiceImpl.getActiveLanguages();
			assertTrue(m_Language.toString().contains("Language"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getActiveLanguagesTest1()
	{
		Set<Object[]> set=Sets.newHashSet();
		try {
			doReturn(set).when(languageRepository).findAciveLanguages();
			List<M_Language> m_Language= languageServiceImpl.getActiveLanguages();
			assertTrue(m_Language.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
