package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104sleep;

@Repository
public interface M_104sleepRepo extends CrudRepository<M_104sleep, Integer> {
	List<M_104sleep> findByDeleted(Boolean deleted);
}
