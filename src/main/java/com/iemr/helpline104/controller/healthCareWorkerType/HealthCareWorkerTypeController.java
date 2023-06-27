package com.iemr.helpline104.controller.healthCareWorkerType;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline104.data.healthCareWorkerType.M_HealthCareWorker;
import com.iemr.helpline104.service.healthCareWorkerType.HealthCareWorkerServiceImpl;
import com.iemr.helpline104.utils.mapper.InputMapper;
import com.iemr.helpline104.utils.response.OutputResponse;

@RequestMapping(value = "/beneficiary")
@RestController
public class HealthCareWorkerTypeController {
	InputMapper inputMapper = new InputMapper();
	private Logger logger = LoggerFactory.getLogger(HealthCareWorkerTypeController.class);
	
	@Autowired
	private HealthCareWorkerServiceImpl healthCareWorkerServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/get/healthCareWorkerTypes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Authorization")
	public String getHealthCareWorkerTypes() {
		logger.info("getHealthCareWorkerTypes request ");
		OutputResponse output= new OutputResponse();

		List<M_HealthCareWorker> i_BeneficiaryTypes = healthCareWorkerServiceImpl.getHealthCareWorkerTypes();
		output.setResponse(i_BeneficiaryTypes.toString());
		logger.info("getHealthCareWorkerTypes response: " + output);
		return output.toString();
	}
}
