package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104progress;

@Repository
public interface M_104progressRepo extends CrudRepository<M_104progress, Integer> {
	List<M_104progress> findByDeleted(Boolean deleted);
}
