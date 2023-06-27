package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104pastpsychiatriccondition;

@Repository
public interface M_104pastpsychiatricconditionRepo extends CrudRepository<M_104pastpsychiatriccondition, Integer> {
	List<M_104pastpsychiatriccondition> findByDeleted(Boolean deleted);
}
