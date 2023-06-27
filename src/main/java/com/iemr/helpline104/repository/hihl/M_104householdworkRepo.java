package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104householdwork;

@Repository
public interface M_104householdworkRepo extends CrudRepository<M_104householdwork, Integer> {
	List<M_104householdwork> findByDeleted(Boolean deleted);
}
