package com.iemr.helpline104.repository.userbeneficiarydata;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.userbeneficiarydata.M_Title;

@Repository
@RestResource(exported = false)
public abstract interface TitleRepository extends CrudRepository<M_Title, Long> {
	@Query("select TitleID, TitleName from M_Title where Deleted = false")
	public abstract Set<Objects[]> findAciveTitles();
}
