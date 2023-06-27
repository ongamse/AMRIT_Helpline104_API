package com.iemr.helpline104.repository.beneficiarycall;

import java.util.List;
import java.util.Objects;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.beneficiarycall.M_subservice;
@Repository
@RestResource(exported = false)
public interface ServiceMasterRepository extends CrudRepository<M_subservice, Long>{

	@Query("select s "
			+ "from M_subservice s where s.deleted = false and s.providerServiceMapID = :providerServiceMapID")
	public List<Objects[]> getServices(@Param("providerServiceMapID") Integer providerServiceMapID); 
}
