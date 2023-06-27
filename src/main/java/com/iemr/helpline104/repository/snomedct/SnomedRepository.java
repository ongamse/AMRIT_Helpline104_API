package com.iemr.helpline104.repository.snomedct;


import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.snomedct.SCTDescription;

@Repository
@RestResource(exported = false)
public interface SnomedRepository extends CrudRepository<SCTDescription, Long> {
	
	
	/*@Query("select u from SCTDescription u where u.term like %:term%")*/
	@Query("select s.conceptID,s.term from SCTDescription s where s.term = :term and s.active = '1'")
	public List<Objects[]> findSnomedCTRecordFromTerm(@Param("term") String term);

}
