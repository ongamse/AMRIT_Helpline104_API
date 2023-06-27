package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104bowel;

@Repository
public interface M_104bowelRepo extends CrudRepository<M_104bowel, Integer> {
	List<M_104bowel> findByDeleted(Boolean deleted);
}
