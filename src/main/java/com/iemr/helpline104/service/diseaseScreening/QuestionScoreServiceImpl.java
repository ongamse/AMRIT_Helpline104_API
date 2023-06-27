package com.iemr.helpline104.service.diseaseScreening;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.diseaseScreening.M_questionairValues;
import com.iemr.helpline104.repository.diseaseScreening.QuestionScoreRepository;

@Service
public class QuestionScoreServiceImpl implements QuestionScoreService{

	@Autowired
	private QuestionScoreRepository questionScoreRepository;
	@Override
	public List<M_questionairValues> fetchAnswers(Integer questionID) throws Exception {
		List<M_questionairValues> answers = new ArrayList<M_questionairValues>();
		List<Objects[]> answersList = questionScoreRepository.fetchAnswers(questionID);
		
		for (Object[] objects : answersList) {
			if (objects!=null && objects.length > 0) {
							
				answers.add(new M_questionairValues((Integer)objects[0], (Integer)objects[1], (String)objects[2], (Integer)objects[3]));
			}
		}
		
		return answers;
	}

}
