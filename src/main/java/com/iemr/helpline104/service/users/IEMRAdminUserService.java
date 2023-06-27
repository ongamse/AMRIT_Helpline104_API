package com.iemr.helpline104.service.users;

import java.util.ArrayList;
import java.util.List;

import com.iemr.helpline104.data.users.M_LoginSecurityQuestions;
import com.iemr.helpline104.data.users.M_User;
import com.iemr.helpline104.data.users.M_UserSecurityQMapping;

public interface IEMRAdminUserService {
	List<M_User> userAuthenticate(String userName, String password);

	M_User userExitsCheck(String userName);

	List<M_UserSecurityQMapping> userSecurityQuestion(Long userId);

	int setForgetPassword(Long userId, String password);

	M_User userWithOldPassExitsCheck(String userName, String Password);

	int saveUserSecurityQuesAns(Iterable<M_UserSecurityQMapping> m_UserSecurityQMapping);

//	Iterable<M_UserSecurityQMapping> saveUserSecurityQuesAns(Iterable<M_UserSecurityQMapping> m_UserSecurityQMapping);
	
	/**
	 * 
	 * @return login security questions
	 */
	ArrayList<M_LoginSecurityQuestions> getAllLoginSecurityQuestions();

}
