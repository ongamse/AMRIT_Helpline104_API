package com.iemr.helpline104.repository.users;


import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.users.M_LoginSecurityQuestions;

@Repository
@RestResource(exported = false)
public interface IEMRUserLoginSecurityRepository extends CrudRepository<M_LoginSecurityQuestions, Integer> {


	@Query("select QuestionID, Question from M_LoginSecurityQuestions")
	ArrayList<Objects[]> getAllLoginSecurityQuestions();
}
