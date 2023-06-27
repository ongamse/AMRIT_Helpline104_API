package com.iemr.helpline104.controller.disease;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline104.service.disease.DiseaseService;
import com.iemr.helpline104.utils.response.OutputResponse;

@RequestMapping(value = "/diseaseController")
@RestController
public class DiseaseController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	DiseaseService diseaseService;
	
	@CrossOrigin()
	@RequestMapping(value = "/saveDisease", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String saveDisease(@RequestBody String request)
	{
		logger.info("saveDisease request "+request);
		OutputResponse response = new OutputResponse();
		try {
			String res= diseaseService.saveDisease(request);
			response.setResponse(res);
		} catch (Exception e) {
			response.setError(e);
			logger.error("saveDisease failed with error " + e.getMessage(), e);
		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/deleteDisease", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String deleteDisease(@RequestBody String request)
	{
		logger.info("deleteDisease request "+request);
		OutputResponse response = new OutputResponse();
		try {
			String res= diseaseService.deleteDisease(request);
			response.setResponse(res);
		} catch (Exception e) {
			response.setError(e);
			logger.error("deleteDisease failed with error " + e.getMessage(), e);
		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/getDisease", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String getDisease(@RequestBody String request)
	{
		logger.info("getDisease request "+request);
		OutputResponse response = new OutputResponse();
		try {
			String res= diseaseService.getDisease(request);
			response.setResponse(res);
		} catch (Exception e) {
			response.setError(e);
			logger.error("getDisease failed with error " + e.getMessage(), e);
		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/updateDisease", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String updateDisease(@RequestBody String request)
	{
		logger.info("updateDisease request "+request);
		OutputResponse response = new OutputResponse();
		try {
			String res= diseaseService.updateDisease(request);
			response.setResponse(res);
		} catch (Exception e) {
			response.setError(e);
			logger.error("updateDisease failed with error " + e.getMessage(), e);
		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/getAvailableDiseases", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String getAvailableDiseases()
	{
		logger.info("getAvailableDiseases request ");
		OutputResponse response = new OutputResponse();
		try {
			String res= diseaseService.getAvailableDiseases();
			response.setResponse(res);
		} catch (Exception e) {
			response.setError(e);
			logger.error("getAvailableDiseases failed with error " + e.getMessage(), e);
		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/getDiseasesByID", headers = "Authorization", method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String getDiseasesByID(@RequestBody String request)
	{
		logger.info("getDiseasesByID request "+request);
		OutputResponse response = new OutputResponse();
		try {
			String res= diseaseService.getDiseasesByID(request);
			response.setResponse(res);
		} catch (Exception e) {
			response.setError(e);
			logger.error("getDiseasesByID failed with error " + e.getMessage(), e);
		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}
}
