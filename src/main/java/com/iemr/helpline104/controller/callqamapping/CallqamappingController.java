package com.iemr.helpline104.controller.callqamapping;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline104.controller.bloodRequest.BloodRequestController;
import com.iemr.helpline104.data.callqamapping.CallqaMappings;
import com.iemr.helpline104.data.callqamapping.M_104callqamapping;
import com.iemr.helpline104.service.callqamapping.CallqamappingServiceImpl;
import com.iemr.helpline104.utils.mapper.InputMapper;
import com.iemr.helpline104.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/beneficiary")
@RestController
public class CallqamappingController {
	
	InputMapper inputMapper = new InputMapper();
	private Logger logger = LoggerFactory.getLogger(CallqamappingController.class);

	@Autowired
	public CallqamappingServiceImpl callqamappingServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/save/callqamapping", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Authorization")
	public String saveCallqamapping(@RequestBody String request) {
		OutputResponse output = new OutputResponse();
		try {
		CallqaMappings  callqaMappings = inputMapper.gson().fromJson(request, CallqaMappings.class);
		logger.info("saveCallqamapping request " + callqaMappings.toString());
		

		List<M_104callqamapping> callqamapping = null;
		
			
			callqamapping = callqamappingServiceImpl.save(callqaMappings);
			output.setResponse(callqamapping.toString());
		} catch (Exception e) {
			logger.error("saveCallqamapping failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		logger.info("saveCallqamapping response: " + output);
		return output.toString();
	}
	
	
	@CrossOrigin
	@ApiOperation(value = "Fetch questions and answers Given by beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/get/CDIqamapping", method = RequestMethod.POST, headers = "Authorization")
	public String getCDIqamapping(
			@ApiParam(value = "{\"beneficiaryRegID\":\"long\",\"benCallID\":\"long\"}") @RequestBody String request) {
		OutputResponse output = new OutputResponse();
		try {
		M_104callqamapping m_104callqamapping = inputMapper.gson().fromJson(request,
				M_104callqamapping.class);
		logger.info("CDIqamapping request " + m_104callqamapping.toString());
		

		List<M_104callqamapping> cdiqaMappings = null;
		
			cdiqaMappings = callqamappingServiceImpl.getCDIQuestionScores(m_104callqamapping);
			
			output.setResponse(cdiqaMappings.toString());
			logger.info("CDIqamapping response size: " + ((cdiqaMappings.size()>0) ? cdiqaMappings.size() : "No Beneficiary Found"));
		} catch (Exception e) {
			logger.error("CDIqamapping failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		
		return output.toString();
	}

	
}
