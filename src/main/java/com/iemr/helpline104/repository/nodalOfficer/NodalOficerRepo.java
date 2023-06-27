package com.iemr.helpline104.repository.nodalOfficer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.nodalOfficer.AuthorityEmailID;


@Repository
@RestResource(exported = false)
public interface NodalOficerRepo extends CrudRepository<AuthorityEmailID, Long> {
	@Query("SELECT contactNo,emailID from AuthorityEmailID b "
			+ "where b.blockID = :victimTaluk ")

	public List<Object[]> findByTalukID(@Param("victimTaluk") Integer victimTaluk);

}
