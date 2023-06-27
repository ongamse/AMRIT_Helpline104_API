package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104relationship;

@Repository
public interface M_104relationshipRepo extends CrudRepository<M_104relationship, Integer> {
	List<M_104relationship> findByDeleted(Boolean deleted);
}
