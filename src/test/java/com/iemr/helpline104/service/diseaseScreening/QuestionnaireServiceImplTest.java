package com.iemr.helpline104.service.diseaseScreening;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.helpline104.repository.diseaseScreening.QuestionnaireRepository;

@RunWith(MockitoJUnitRunner.class)
public class QuestionnaireServiceImplTest {

	@InjectMocks
	QuestionnaireServiceImpl questionnaireServiceImpl;

	@Mock
	QuestionnaireRepository questionnaireRepository;

	@Test
	public void fetchQuestions() {
		try {
			// List<Objects[]> questionsList
			// =questionnaireServiceImpl.fetchQuestions(Mockito.anyInt(), 101);
			// assertTrue(questionsList.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
