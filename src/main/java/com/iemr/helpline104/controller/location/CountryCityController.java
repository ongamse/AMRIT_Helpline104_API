package com.iemr.helpline104.controller.location;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline104.controller.feedback.FeedbackController;
import com.iemr.helpline104.service.location.CountryCityService;
import com.iemr.helpline104.utils.response.OutputResponse;

@RequestMapping(value =  "/countryCityController")
@RestController
public class CountryCityController {

	@Autowired
	private CountryCityService countryCityService;
	private Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	@CrossOrigin
	@RequestMapping(value = { "/getCountry" }, method = RequestMethod.GET, 
							produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCountry() 
	{
		OutputResponse response = new OutputResponse();
		try {
		String data = countryCityService.getCountry();
		response.setResponse(data);
	} catch (Exception e) {
		logger.error(e.getMessage());
		response.setError(e);

	}
	/**
	 * sending the response...
	 */
	return response.toString();
	}
	
	@CrossOrigin
	@RequestMapping(value = { "/getCities/{id}" }, method = RequestMethod.GET, 
							produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCities(@PathVariable("id") Integer id) 
	{
		OutputResponse response = new OutputResponse();
		try {
		String data = countryCityService.getCities(id);
		response.setResponse(data);
	} catch (Exception e) {
		logger.error(e.getMessage());
		response.setError(e);

	}
	/**
	 * sending the response...
	 */
	return response.toString();
	}
}
