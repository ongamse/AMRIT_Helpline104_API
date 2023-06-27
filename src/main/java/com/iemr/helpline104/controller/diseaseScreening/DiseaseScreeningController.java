package com.iemr.helpline104.controller.diseaseScreening;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline104.data.diseaseScreening.M_questionairValues;
import com.iemr.helpline104.data.diseaseScreening.M_Questionnaire;
import com.iemr.helpline104.service.diseaseScreening.QuestionScoreServiceImpl;
import com.iemr.helpline104.service.diseaseScreening.QuestionnaireServiceImpl;
import com.iemr.helpline104.utils.mapper.InputMapper;
import com.iemr.helpline104.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/beneficiary")
@RestController
public class DiseaseScreeningController {

	InputMapper inputMapper = new InputMapper();
	private Logger logger = LoggerFactory.getLogger(DiseaseScreeningController.class);
	
	@Autowired
	private QuestionnaireServiceImpl questionnaireServiceImpl;
	
	@Autowired
	private QuestionScoreServiceImpl questionScoreServiceImpl;
	
	@CrossOrigin
	@ApiOperation(
			value = "fetches disease screening questions",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value = "/get/questions", method = RequestMethod.POST, headers = "Authorization")
	public String fetchQuestions(@ApiParam(
			value = "{\"questionTypeID\":\"integer\",\"providerServiceMapID\":\"integer\"}") @RequestBody String request) {
		OutputResponse output= new OutputResponse();
		try {
		M_Questionnaire m_questionnaire = inputMapper.gson().fromJson(request, M_Questionnaire.class);
		logger.info("getQuestions request " + m_questionnaire.toString());
		
		
		List<Objects[]> Questions = null;
		
			Questions = questionnaireServiceImpl.fetchQuestions(m_questionnaire.getQuestionTypeID(), m_questionnaire.getProviderServiceMapID());
			output.setResponse(Questions.toString());
			logger.info("getQuestions response size: " + ((Questions.size()>0) ? Questions.size() : "No Beneficiary Found"));
		} catch (Exception e) {
			logger.error("getQuestions failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		
		return output.toString();
	}
	
	
	@CrossOrigin
	@ApiOperation(
			value = "fetches disease screening answers",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value = "/get/answers", method = RequestMethod.POST, headers = "Authorization")
	public String fetchAnswers(@ApiParam(
			value = "{\"questionID\":\"integer\"}") @RequestBody String request) {
		OutputResponse output= new OutputResponse();
		try {
		M_questionairValues m_104QuestionScore = inputMapper.gson().fromJson(request, M_questionairValues.class);
		logger.info("fetchAnswers request " + m_104QuestionScore.toString());
		
		
		List<M_questionairValues> Questions = null;
		
			Questions = questionScoreServiceImpl.fetchAnswers(m_104QuestionScore.getQuestionID());
			output.setResponse(Questions.toString());
			logger.info("fetchAnswers response size: " + ((Questions.size()>0) ? Questions.size() : "No Beneficiary Found"));
		} catch (Exception e) {
			logger.error("fetchAnswers failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		
		return output.toString();
	}
}
