package com.iemr.helpline104.repository.healthCareWorkerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.healthCareWorkerType.M_HealthCareWorker;

@Repository
@RestResource(exported = false)
public interface HealthCareWorkerTypeRepository extends CrudRepository<M_HealthCareWorker, Long>{
	@Query("select healthCareWorkerID,healthCareWorkerType from M_HealthCareWorker where deleted = false")
	public ArrayList<Objects[]> findAciveHealthCareWorkerTypes();
}
