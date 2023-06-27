package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104bladder;

@Repository
public interface M_104bladderRepo extends CrudRepository<M_104bladder, Integer> {
	List<M_104bladder> findByDeleted(Boolean deleted);
}
