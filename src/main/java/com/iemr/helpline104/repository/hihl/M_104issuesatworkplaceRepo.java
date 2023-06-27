package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104issuesatworkplace;

@Repository
public interface M_104issuesatworkplaceRepo extends CrudRepository<M_104issuesatworkplace, Integer> {
	List<M_104issuesatworkplace> findByDeleted(Boolean deleted);
}
