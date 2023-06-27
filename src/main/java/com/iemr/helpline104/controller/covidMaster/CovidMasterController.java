package com.iemr.helpline104.controller.covidMaster;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.iemr.helpline104.service.covidMaster.CovidMasterService;
import com.iemr.helpline104.utils.response.OutputResponse;


import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/master", headers = "Authorization")

public class CovidMasterController {
	
	private Logger logger = LoggerFactory.getLogger(CovidMasterController.class);
	@Autowired
	private CovidMasterService covidMasterService;
	
	
	@ApiOperation(value = "Master Data  for covid Patient", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = {
			"/patient/covidDetails/{providerServiceMapID}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String patientAppMasterData(@PathVariable("providerServiceMapID") Integer providerServiceMapID) {
		logger.info("master Data for beneficiary:");

		OutputResponse response = new OutputResponse();
		response.setResponse(covidMasterService.getMaster(providerServiceMapID));
		logger.info("Nurse master Data for beneficiary:" + response.toString());
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Save Covid  data..", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/covidScreeningData" }, method = { RequestMethod.POST })
	public String saveBenCovidDoctorData(@RequestBody String requestObj,
			@RequestHeader(value = "Authorization") String Authorization) {
		OutputResponse response = new OutputResponse();
		try {
			logger.info("Request object for Covid data saving :" + requestObj);

			String s = covidMasterService.saveCovidData(requestObj);

			response.setResponse(s);

		} catch (Exception e) {
			logger.error("Error while saving Covid data :" + e);
			response.setError(5000, "Unable to save data. " + e.getMessage());
		}
		return response.toString();
	}

}
