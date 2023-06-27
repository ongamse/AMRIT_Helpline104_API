package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104gettingwithfamily;

@Repository
public interface M_104gettingwithfamilyRepo extends CrudRepository<M_104gettingwithfamily, Integer> {
	List<M_104gettingwithfamily> findByDeleted(Boolean deleted);
}
