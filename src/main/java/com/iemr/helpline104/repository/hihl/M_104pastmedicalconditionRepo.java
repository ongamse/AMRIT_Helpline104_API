package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104pastmedicalcondition;

@Repository
public interface M_104pastmedicalconditionRepo extends CrudRepository<M_104pastmedicalcondition, Integer> {
	List<M_104pastmedicalcondition> findByDeleted(Boolean deleted);
}
