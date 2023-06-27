package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.userbeneficiarydata.M_MaritalStatus;
import com.iemr.helpline104.repository.userbeneficiarydata.MaritalStatusRepository;

@Service
public class MaritalStatusServiceImpl implements MaritalStatusService {
	private MaritalStatusRepository maritalStatusRepository;

	@Autowired
	public void setMaritalStatusServiceImpl(MaritalStatusRepository maritalStatusRepository) {
		this.maritalStatusRepository = maritalStatusRepository;
	}

	public List<M_MaritalStatus> getActiveMaritalStatus() {
		List<M_MaritalStatus> genderList = new ArrayList<M_MaritalStatus>();
		Set<Objects[]> queryResult = maritalStatusRepository.findAciveMaritalStatus();
		for (Object[] objects : queryResult) {
			if (objects != null && objects.length == 2) {
				genderList.add(new M_MaritalStatus((Integer) objects[0], (String) objects[1]));
			}
		}
		return genderList;
	}
}
