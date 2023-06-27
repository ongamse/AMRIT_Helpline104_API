package com.iemr.helpline104.controller.bloodComponent;

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

import com.iemr.helpline104.data.bloodComponent.M_Component;
import com.iemr.helpline104.service.bloodComponent.BloodComponentServiceImpl;
import com.iemr.helpline104.utils.mapper.InputMapper;
import com.iemr.helpline104.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/beneficiary")
@RestController
public class BloodComponentController {

	private InputMapper inputMapper = new InputMapper();
	private Logger logger = LoggerFactory.getLogger(BloodComponentController.class);
	
	@Autowired
	private BloodComponentServiceImpl bloodComponentServiceImpl;
	@CrossOrigin
	@ApiOperation(
			value = "stores blood components master data",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value = "/save/bloodComponentDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Authorization")
	public String saveBloodComponentDetails(@ApiParam(
			value = "{\"component\":\"String\",\"componentDesc\":\"String\",\"deleted\":\"boolean\",\"createdBy\":\"String\"}") @RequestBody String request) {
		OutputResponse output= new OutputResponse(); 
		try {
		M_Component m_component = inputMapper.gson().fromJson(request, M_Component.class);
		logger.info("saveBloodComponentDetails request " + m_component.toString());
		
		
		M_Component bloodComponent = bloodComponentServiceImpl.save(m_component);
		output.setResponse(bloodComponent.toString());
		logger.info("saveBloodComponentDetails response: " + output);
        }catch (Exception e) {
			logger.error("saveBloodComponentDetails failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		return output.toString();
	}
	
	@CrossOrigin
	@ApiOperation(
			value = "provides particular component details",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value = "/get/bloodComponentDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Authorization")
	public String getBloodComponentDetails(@ApiParam(
			value = "{\"componentID\":\"Integer\"}") @RequestBody String request) {

		OutputResponse output= new OutputResponse();
		try {
		M_Component m_component = inputMapper.gson().fromJson(request, M_Component.class);
		logger.info("getBloodComponentDetails request " + m_component.toString());
		
		
		List<M_Component> bloodComponent = null;
		
			bloodComponent = bloodComponentServiceImpl.getBloodComponents(m_component.getComponentID());
			output.setResponse(bloodComponent.toString());
			logger.info("getBloodComponentDetails response size: " + ((bloodComponent .size()>0) ? bloodComponent.size() : "No Beneficiary Found"));
		} catch (Exception e) {
			logger.error("getBloodComponentDetails failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		
		return output.toString();
	}
	
}
