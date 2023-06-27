package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.userbeneficiarydata.M_Status;
import com.iemr.helpline104.repository.userbeneficiarydata.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {
	private StatusRepository statusRepository;

	@Autowired
	public void setTitleServiceImpl(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}

	public List<M_Status> getActiveStatus() {
		List<M_Status> activeStatus = new ArrayList();
		Set<Objects[]> lists = this.statusRepository.findAciveStatus();
		for (Object[] objects : lists) {
			if ((objects != null) && (objects.length == 2)) {
				activeStatus.add(new M_Status(((Integer) objects[0]).intValue(), (String) objects[1]));
			}
		}
		return activeStatus;
	}
}
