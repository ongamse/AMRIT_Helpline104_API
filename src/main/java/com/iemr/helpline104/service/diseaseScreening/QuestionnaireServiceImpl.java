package com.iemr.helpline104.service.diseaseScreening;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.diseaseScreening.M_Questionnaire;
import com.iemr.helpline104.repository.diseaseScreening.QuestionnaireRepository;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService{

	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	
	@Override
	public List<Objects[]> fetchQuestions(Integer questionTypeID ,Integer providerServiceMapID) throws Exception {
		List<M_Questionnaire> questions = new ArrayList<M_Questionnaire>();
		List<Objects[]> questionsList = null;
		if(questionTypeID != null && (questionTypeID == 1 || questionTypeID == 2 || questionTypeID == 3)) {
			questionsList = questionnaireRepository.fetchQuestionsOnQuestionID(questionTypeID);
		}else {
			questionsList = questionnaireRepository.fetchQuestions(providerServiceMapID);
		}
		
		//List<Objects[]> questionsList = questionnaireRepository.fetchQuestions(questionTypeID, providerServiceMapID);
		
/*		for (Object[] objects : questionsList) {
			if (objects!=null && objects.length > 0) {
							
				questions.add(new M_Questionnaire((Integer)objects[0], (String)objects[1], (String)objects[2], (Integer)objects[3],
						(String)objects[4], (Boolean)objects[5], (String)objects[6], (Integer)objects[7], (Integer)objects[8]));
			}
		}*/
		return questionsList;
	}

}
