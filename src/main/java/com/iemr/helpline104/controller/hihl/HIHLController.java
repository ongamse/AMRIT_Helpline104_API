package com.iemr.helpline104.controller.hihl;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline104.service.hihl.HIHLMastersImpl;
import com.iemr.helpline104.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/hihl", headers = "Authorization")
public class HIHLController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private HIHLMastersImpl hIHLMastersImpl;

	@ApiOperation(value = "Master Data for 104 HIHL", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/get/masters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String getHihlMasters() {

		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(hIHLMastersImpl.getHihlMasters());
		} catch (Exception e) {
			response.setError(5000, e.getLocalizedMessage());
		}

		return response.toString();
	}

	@ApiOperation(value = "saveHihlCasesheet", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/save/casesheet", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public String saveHihlCasesheet(@RequestBody String request) {

		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(hIHLMastersImpl.saveHihlCasesheet(request));
		} catch (Exception e) {
			response.setError(5000, e.getLocalizedMessage());
		}

		return response.toString();
	}

	@ApiOperation(value = "get Hihl Casesheet History Info", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/getHihlCasesheetHistoryInfo/{benRegId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String getHihlCasesheetHistoryInfo(@PathVariable Long benRegId) {

		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(hIHLMastersImpl.getHihlCasesheetHistoryInfo(benRegId));
		} catch (Exception e) {
			response.setError(5000, e.getLocalizedMessage());
		}
		return response.toString();
	}

	@ApiOperation(value = "get Hihl Casesheet Data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/getHihlCasesheetData/{casesheetId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String getHihlCasesheetData(@PathVariable Long casesheetId) {

		OutputResponse response = new OutputResponse();
		try {
			response.setResponse(hIHLMastersImpl.getHihlCasesheetData(casesheetId));
		} catch (Exception e) {
			response.setError(5000, e.getLocalizedMessage());
		}

		return response.toString();
	}
}
