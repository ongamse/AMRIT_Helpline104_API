package com.iemr.helpline104.service.healthCareWorkerType;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.iemr.helpline104.data.healthCareWorkerType.M_HealthCareWorker;

public interface HealthCareWorkerService {

	//public Iterable<M_HealthCareWorker> getHealthCareWorkerTypes();

	List<M_HealthCareWorker> getHealthCareWorkerTypes();
}
