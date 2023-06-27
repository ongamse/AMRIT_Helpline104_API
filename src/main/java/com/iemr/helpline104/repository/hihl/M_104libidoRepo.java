package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.M_104libido;

@Repository
public interface M_104libidoRepo extends CrudRepository<M_104libido, Integer> {
	List<M_104libido> findByDeleted(Boolean deleted);
}
