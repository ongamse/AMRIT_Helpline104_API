package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.userbeneficiarydata.M_Religion;
import com.iemr.helpline104.repository.userbeneficiarydata.ReligionRepository;

@Service
public class RelegionServiceImpl implements RelegionService {
	private ReligionRepository relegionRepository;

	@Autowired
	public void setRelegionServiceImpl(ReligionRepository relegionRepository) {
		this.relegionRepository = relegionRepository;
	}

	public List<M_Religion> getActiveReligions() {
		List<M_Religion> activeReligions = new ArrayList();
		List<Objects[]> lists = this.relegionRepository.getActiveReligions();
		for (Object[] objects : lists) {
			if ((objects != null) && (objects.length == 3)) {
				activeReligions.add(
						new M_Religion(((Integer) objects[0]).intValue(), (String) objects[1], (String) objects[2]));
			}
		}
		return activeReligions;
	}
}
