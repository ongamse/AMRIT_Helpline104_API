package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104precipitatingfactor;

@Repository
public interface M_104precipitatingfactorRepo extends CrudRepository<M_104precipitatingfactor, Integer> {
	List<M_104precipitatingfactor> findByDeleted(Boolean deleted);
}
