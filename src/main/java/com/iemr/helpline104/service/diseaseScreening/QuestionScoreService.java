package com.iemr.helpline104.service.diseaseScreening;

import java.util.List;

import com.iemr.helpline104.data.diseaseScreening.M_questionairValues;
import com.iemr.helpline104.data.diseaseScreening.M_Questionnaire;

public interface QuestionScoreService {
	List<M_questionairValues> fetchAnswers(Integer questionID) throws Exception;
}
