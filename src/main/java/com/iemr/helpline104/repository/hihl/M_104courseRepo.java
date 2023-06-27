package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104course;

@Repository
public interface M_104courseRepo extends CrudRepository<M_104course, Integer> {
	List<M_104course> findByDeleted(Boolean deleted);
}
