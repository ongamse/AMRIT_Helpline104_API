package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.userbeneficiarydata.M_Gender;
import com.iemr.helpline104.repository.userbeneficiarydata.UserBeneficiaryDataRepository;

/**
 * 
 */
@Service
public class UserBeneficiaryDataServiceImpl implements UserBeneficiaryDataService {
	private UserBeneficiaryDataRepository userBeneficiaryDataRepository;

	@Autowired
	public void setUserBeneficiaryDataRepository(UserBeneficiaryDataRepository userBeneficiaryDataRepository) {
		this.userBeneficiaryDataRepository = userBeneficiaryDataRepository;
	}

	@Override
	public List<M_Gender> getActiveGender() {
		ArrayList<M_Gender> genderList = new ArrayList<M_Gender>();
		Set<Objects[]> queryResult = userBeneficiaryDataRepository.findActiveGenders();
		for (Object[] object : queryResult) {
			if (object != null && object.length == 2) {
				genderList.add(new M_Gender((Short) object[0], (String) object[1]));
			}
		}
		return genderList;
	}

}
