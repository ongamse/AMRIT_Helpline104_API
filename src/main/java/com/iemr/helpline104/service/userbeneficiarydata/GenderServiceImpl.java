package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.userbeneficiarydata.M_Gender;
import com.iemr.helpline104.repository.userbeneficiarydata.GenderRepository;

@Service
public class GenderServiceImpl implements GenderService {
	private GenderRepository genderRepository;

	@Autowired
	public void setGenderServiceImpl(GenderRepository genderRepository) {
		this.genderRepository = genderRepository;
	}

	public List<M_Gender> getActiveGenders() {
		List<M_Gender> genderList = new ArrayList<M_Gender>();
		Set<Objects[]> queryResult =  genderRepository.findAciveGenders();
		for (Object[] objects : queryResult) {
			if (objects!=null && objects.length == 2) {
				genderList.add(new M_Gender((Short)objects[0], (String)objects[1]));
			}
		}
		return genderList;
	}
}
