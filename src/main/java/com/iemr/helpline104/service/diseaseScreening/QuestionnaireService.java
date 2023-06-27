package com.iemr.helpline104.service.diseaseScreening;

import java.util.List;
import java.util.Objects;

import com.iemr.helpline104.data.diseaseScreening.M_Questionnaire;

public interface QuestionnaireService {
	
	List<Objects[]> fetchQuestions(Integer questionTypeID, Integer providerServiceMapID) throws Exception;
}
