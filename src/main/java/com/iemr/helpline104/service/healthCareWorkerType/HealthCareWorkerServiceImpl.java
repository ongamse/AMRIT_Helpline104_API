package com.iemr.helpline104.service.healthCareWorkerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.healthCareWorkerType.M_HealthCareWorker;
import com.iemr.helpline104.data.location.Districts;
import com.iemr.helpline104.data.location.States;
import com.iemr.helpline104.repository.healthCareWorkerType.HealthCareWorkerTypeRepository;

@Service
public class HealthCareWorkerServiceImpl implements HealthCareWorkerService{

	@Autowired
	private HealthCareWorkerTypeRepository healthCareWorkerTypeRepository;
	@Override
	public List<M_HealthCareWorker> getHealthCareWorkerTypes() {
	
		
		 List<M_HealthCareWorker> healthCareTypesList = new ArrayList<M_HealthCareWorker>();
			Iterable<Objects[]> healthCareTypes = healthCareWorkerTypeRepository.findAciveHealthCareWorkerTypes();
		
			System.out.println(healthCareTypes);
			for (Object[] objects : healthCareTypes) {
				if (objects!=null && objects.length > 0) {
					healthCareTypesList.add(new M_HealthCareWorker((Short)objects[0], (String)objects[1]));
				}
			}
			
		return healthCareTypesList;
	}
	
}
