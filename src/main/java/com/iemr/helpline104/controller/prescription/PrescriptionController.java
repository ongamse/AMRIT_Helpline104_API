package com.iemr.helpline104.controller.prescription;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline104.data.prescription.Prescription;
import com.iemr.helpline104.service.prescription.PrescriptionServiceImpl;
import com.iemr.helpline104.utils.mapper.InputMapper;
import com.iemr.helpline104.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/beneficiary")
@RestController
public class PrescriptionController {

	InputMapper mapper = new InputMapper();
	private Logger logger = LoggerFactory.getLogger(PrescriptionController.class);
	
	@Autowired
	private PrescriptionServiceImpl prescriptionServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/save/prescription", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Authorization")
	public String savePrescription(@RequestBody String createRequest) {
		OutputResponse output = new OutputResponse();
		try {
		Prescription t_Prescription = mapper.gson().fromJson(createRequest, Prescription.class);
		logger.info("savePrescription request " + t_Prescription.toString());
		
		Prescription prescription = null;
		
			prescription = prescriptionServiceImpl.savePrescription(t_Prescription);
			output.setResponse(prescription.toString());
		} catch (Exception e) {
			logger.error("savePrescription failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		logger.info("savePrescription response: " + output);
		return output.toString();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/get/prescription", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Authorization")
	public String getPrescription(@RequestBody String createRequest) {
		OutputResponse output= new OutputResponse();
		try {
		Prescription t_Prescription = mapper.gson().fromJson(createRequest, Prescription.class);
		logger.info("getPrescription request " + t_Prescription.toString());
		
		List<Prescription> prescription = null;
		
			prescription = prescriptionServiceImpl.getPrescription(t_Prescription.getBeneficiaryRegID(), t_Prescription.getPrescriptionID());
			if(prescription!=null){
				output.setResponse(prescription.toString());
			}else{
				output.setError(5000, "prescription not available with that prescription or beneficiary ID");
			}
			
		} catch (Exception e) {
			logger.error("getPrescription failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		logger.info("getPrescription response: " + output);
		return output.toString();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/get/prescriptionList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Authorization")
	public String getPrescriptionList(@RequestBody String createRequest) {
		OutputResponse output= new OutputResponse();
		try {
		Prescription t_Prescription = mapper.gson().fromJson(createRequest, Prescription.class);
		logger.info("getPrescriptionList request " + t_Prescription.toString());
		
		List<Prescription> prescription = null;
		
			JSONObject requestObj = new JSONObject(createRequest);
			int page = requestObj.has("page") ? (requestObj.getInt("page") - 1) : 0;
			int size = requestObj.has("size") ? requestObj.getInt("size") : 1000;
			
			prescription = prescriptionServiceImpl.getPrescriptionList(t_Prescription.getBeneficiaryRegID(),new PageRequest(page, size));
			if(prescription!=null){
				output.setResponse(prescription.toString());
			}else{
				output.setError(5000, "prescription not available with that prescription or beneficiary ID");
			}
			logger.info("getPrescriptionList response size: " + (prescription != null ? prescription.size() : "No Beneficiary Found"));
			
		} catch (Exception e) {
			logger.error("getPrescriptionList failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		
		return output.toString();
	}	
	
	
	@CrossOrigin
	@RequestMapping(value = "/get/latestValidPescription", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Authorization")
	public String getLatestValidPescription(@ApiParam(
			value = "{\"beneficiaryRegID\":\"Integer\"}") @RequestBody String createRequest) {
		OutputResponse output= new OutputResponse();
		try {
		Prescription t_Prescription = mapper.gson().fromJson(createRequest, Prescription.class);
		logger.info("latestValidPescription request " + t_Prescription.toString());
		
		List<Prescription> prescription = null;
		
			JSONObject requestObj = new JSONObject(createRequest);
			int page = requestObj.has("page") ? (requestObj.getInt("page") - 1) : 0;
			int size = requestObj.has("size") ? requestObj.getInt("size") : 1000;
			
			prescription = prescriptionServiceImpl.getLatestValidPescription(t_Prescription.getBeneficiaryRegID(),new PageRequest(page, size));
			if(prescription!=null){
				output.setResponse(prescription.toString());
			}else{
				output.setError(5000, "prescription not available with the beneficiaryID");
			}
			
		} catch (Exception e) {
			logger.error("getPrescriptionList failed with error " + e.getMessage(), e);
			output.setError(e);
		}
		logger.info("getPrescriptionList response: " + output);
		return output.toString();
	}
	
}
