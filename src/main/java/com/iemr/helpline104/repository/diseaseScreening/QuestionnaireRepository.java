package com.iemr.helpline104.repository.diseaseScreening;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.diseaseScreening.M_Questionnaire;

@Repository
@RestResource(exported = false)
public interface QuestionnaireRepository extends CrudRepository<M_Questionnaire, Integer> {

	@Query("select q from M_Questionnaire q " + 
	"LEFT JOIN q.m_104QuestionScore s where q.questionTypeID = :questionTypeID group by q.questionID order by q.questionRank, s.iD")
	public List<Objects[]> fetchQuestionsOnQuestionID(@Param("questionTypeID") Integer questionTypeID);

	@Query("SELECT DISTINCT q from M_Questionnaire q LEFT JOIN q.m_questionairValues s "
			+ "WHERE q.providerServiceMapID = :providerServiceMapID AND q.deleted is false "
			+ "ORDER BY q.questionTypeID ASC, q.questionRank ASC")
	public List<Objects[]> fetchQuestions(@Param("providerServiceMapID") Integer providerServiceMapID);

}
