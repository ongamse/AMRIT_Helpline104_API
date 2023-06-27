package com.iemr.helpline104.repository.userbeneficiarydata;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.userbeneficiarydata.M_Community;
import com.iemr.helpline104.data.userbeneficiarydata.M_Gender;
import com.iemr.helpline104.data.userbeneficiarydata.M_Language;

@Repository
@RestResource(exported = false)
public abstract interface LanguageRepository extends CrudRepository<M_Language, Long> {
	@Query("select LanguageID, LanguageName from M_Language where Deleted = false")
	public abstract Set<Objects[]> findAciveLanguages();
}
