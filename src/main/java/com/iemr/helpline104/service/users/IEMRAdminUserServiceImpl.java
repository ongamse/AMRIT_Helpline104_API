package com.iemr.helpline104.service.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.users.M_LoginSecurityQuestions;
import com.iemr.helpline104.data.users.M_Role;
import com.iemr.helpline104.data.users.M_User;
import com.iemr.helpline104.data.users.M_UserSecurityQMapping;
import com.iemr.helpline104.repository.users.IEMRUserLoginSecurityRepository;
import com.iemr.helpline104.repository.users.IEMRUserRepositoryCustom;
import com.iemr.helpline104.repository.users.IEMRUserSecurityQuesAnsRepository;
import com.iemr.helpline104.repository.users.RoleRepo;

/**
 * 
 */
@Service
public class IEMRAdminUserServiceImpl implements IEMRAdminUserService {

	private IEMRUserRepositoryCustom iEMRUserRepositoryCustom;
	private IEMRUserSecurityQuesAnsRepository iEMRUserSecurityQuesAnsRepository;

	@Autowired
	public void setIemrUserRepositoryImpl(IEMRUserRepositoryCustom iEMRUserRepositoryCustom) {
		this.iEMRUserRepositoryCustom = iEMRUserRepositoryCustom;
	}

	@Autowired
	public void setIemrUserRepositoryImpl(IEMRUserSecurityQuesAnsRepository iemrLoginSecurityQuesAnsRepository) {
		this.iEMRUserSecurityQuesAnsRepository = iemrLoginSecurityQuesAnsRepository;
	}

	@Override
	public List<M_User> userAuthenticate(String userName, String password) {
		return iEMRUserRepositoryCustom.findByUserNamePassword(userName, password);
	}

	@Override
	public M_User userExitsCheck(String userName) {
		return iEMRUserRepositoryCustom.findByUserName(userName);
	}

	@Override
	public List<M_UserSecurityQMapping> userSecurityQuestion(Long userId) {
		return iEMRUserRepositoryCustom.getUserSecurityQues(userId);
	}

	@Override
	public int setForgetPassword(Long userId, String password) {
		return iEMRUserRepositoryCustom.updateSetForgetPassword(userId, password);

	}

	@Override
	public M_User userWithOldPassExitsCheck(String userName, String password) {
		return iEMRUserRepositoryCustom.findUserForChangePass(userName, password);
	}

	@Override
	public int saveUserSecurityQuesAns(
			Iterable<M_UserSecurityQMapping> m_UserSecurityQMapping) {
		int x = 0;
		Iterable<M_UserSecurityQMapping> obj = iEMRUserSecurityQuesAnsRepository.save(m_UserSecurityQMapping);
		for (M_UserSecurityQMapping usq : obj) {
			x  = iEMRUserRepositoryCustom.updateSetUserStatusActive(usq.getUserID());
		}
		return x;

	}

	/*
	 * (non-Javadoc)
	 * @see com.iemr.helpline104.service.users.IEMRAdminUserService#getAllLoginSecurityQuestions()
	 */
	@Override
	public ArrayList<M_LoginSecurityQuestions> getAllLoginSecurityQuestions() {
		
		ArrayList<M_LoginSecurityQuestions> result = new ArrayList<M_LoginSecurityQuestions>();
		ArrayList<Objects[]> lists = iEMRUserLoginSecurityRepository.getAllLoginSecurityQuestions();
		for (Object[] objects : lists) {
			if (objects!=null && objects.length > 0) {
				result.add(new M_LoginSecurityQuestions((Integer)objects[0], (String)objects[1]));
			}
		}
		return result;
	}
	
	/**
	 * IemrUserLoginSecurityRepository repository
	 */
	private IEMRUserLoginSecurityRepository iEMRUserLoginSecurityRepository;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	public void setIEMRUserLoginSecurityRepository(IEMRUserLoginSecurityRepository iEMRUserLoginSecurityRepository){
		
		this.iEMRUserLoginSecurityRepository = iEMRUserLoginSecurityRepository;
	}

	public M_Role getrolewrapuptime(int roleID) {
		// TODO Auto-generated method stub
		return roleRepo.findOne(roleID);
	}

}
