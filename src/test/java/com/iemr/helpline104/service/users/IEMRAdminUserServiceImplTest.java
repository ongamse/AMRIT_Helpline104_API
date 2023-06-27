package com.iemr.helpline104.service.users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.data.users.M_LoginSecurityQuestions;
import com.iemr.helpline104.data.users.M_UserSecurityQMapping;
import com.iemr.helpline104.repository.users.IEMRUserLoginSecurityRepository;
import com.iemr.helpline104.repository.users.IEMRUserRepositoryCustom;
import com.iemr.helpline104.repository.users.IEMRUserSecurityQuesAnsRepository;

@RunWith(MockitoJUnitRunner.class)
public class IEMRAdminUserServiceImplTest {
	
	@InjectMocks
	IEMRAdminUserServiceImpl iEMRAdminUserServiceImpl;
	
	@Mock
	IEMRUserRepositoryCustom iEMRUserRepositoryCustom;
	
	@Mock
	IEMRUserSecurityQuesAnsRepository iEMRUserSecurityQuesAnsRepository;
	
	@Mock
	 IEMRUserLoginSecurityRepository iEMRUserLoginSecurityRepository;
	
	@Test
	public void saveUserSecurityQuesAnsTest()
	{
		List<M_UserSecurityQMapping> list=Lists.newArrayList();
		M_UserSecurityQMapping userSecurityQMapping=Mockito.mock(M_UserSecurityQMapping.class,Mockito.CALLS_REAL_METHODS);
		userSecurityQMapping.setUserID(101L);
		list.add(userSecurityQMapping);
		doReturn(list).when(iEMRUserSecurityQuesAnsRepository).save(Mockito.anyList());
		doReturn(102).when(iEMRUserRepositoryCustom).updateSetUserStatusActive(Mockito.anyLong());
		int x=iEMRAdminUserServiceImpl.saveUserSecurityQuesAns(list);
		assertTrue(x==102);
		
	}
	@Test
	public void saveUserSecurityQuesAnsTest1()
	{
		List<M_UserSecurityQMapping> list=Lists.newArrayList();
		doReturn(list).when(iEMRUserSecurityQuesAnsRepository).save(Mockito.anyList());
		int x=iEMRAdminUserServiceImpl.saveUserSecurityQuesAns(list);
		assertFalse(x==102);
		
	}
	
	@Test
	public void getAllLoginSecurityQuestionsTest()
	{
		List<Object[]> list=Lists.newArrayList();
		Object[] array=new Object[9];
		array[0]=101;
		array[1]="Questions";
		list.add(array);
		try {
			doReturn(list).when(iEMRUserLoginSecurityRepository).getAllLoginSecurityQuestions();
			ArrayList<M_LoginSecurityQuestions> questions= iEMRAdminUserServiceImpl.getAllLoginSecurityQuestions();
			M_LoginSecurityQuestions m_LoginSecurityQuestions=questions.get(0);
			assertTrue(m_LoginSecurityQuestions.getQuestionID()==101);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getAllLoginSecurityQuestionsTest1()
	{
		List<Object[]> list=Lists.newArrayList();
		try {
			doReturn(list).when(iEMRUserLoginSecurityRepository).getAllLoginSecurityQuestions();
			ArrayList<M_LoginSecurityQuestions> questions= iEMRAdminUserServiceImpl.getAllLoginSecurityQuestions();
			assertFalse(!questions.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
