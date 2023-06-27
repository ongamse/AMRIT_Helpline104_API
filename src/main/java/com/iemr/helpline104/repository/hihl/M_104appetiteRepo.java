package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104appetite;

@Repository
public interface M_104appetiteRepo extends CrudRepository<M_104appetite, Integer> {
	List<M_104appetite> findByDeleted(Boolean deleted);
}
