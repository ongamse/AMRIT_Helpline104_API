package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104familycondition;

@Repository
public interface M_104familyconditionRepo extends CrudRepository<M_104familycondition, Integer> {
	List<M_104familycondition> findByDeleted(Boolean deleted);
}
