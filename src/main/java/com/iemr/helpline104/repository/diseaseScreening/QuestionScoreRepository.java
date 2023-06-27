package com.iemr.helpline104.repository.diseaseScreening;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.diseaseScreening.M_questionairValues;

@Repository
@RestResource(exported = false)
public interface QuestionScoreRepository extends CrudRepository<M_questionairValues, Integer>{
	
	@Query("select iD, questionID, answer, score "
			+ "from M_questionairValues where questionID = :questionID order by iD")
	public ArrayList<Objects[]> fetchAnswers(@Param("questionID") Integer questionID);
	
}
