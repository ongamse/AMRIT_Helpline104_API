package com.iemr.helpline104.controller.IMRMMR;

import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.iemr.helpline104.data.IMRMMR.IMRMMR;
import com.iemr.helpline104.data.IMRMMR.M_facilities;
import com.iemr.helpline104.data.IMRMMR.M_supportServices;
import com.iemr.helpline104.data.IMRMMR.m_iMRMMRBaseCommunity;
import com.iemr.helpline104.data.IMRMMR.m_iMRMMRHealthworker;
import com.iemr.helpline104.data.IMRMMR.m_iMRMMRTransitType;
import com.iemr.helpline104.service.IMRMMR.IMRMMRServiceImpl;
import com.iemr.helpline104.utils.mapper.InputMapper;
import com.iemr.helpline104.utils.response.OutputResponse;

@RequestMapping(value = "/beneficiary")
@RestController
public class IMRMMRController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private IMRMMRServiceImpl imrmmrService;

	@CrossOrigin()
	@RequestMapping(value = "/saveIMRMMR", headers = "Authorization", method = { RequestMethod.POST }, produces = {
	"application/json" })
	public String saveIMRMMR(@RequestBody String request,@RequestHeader(value = "Authorization") String Authorization) {
		logger.info("saveIMRMMR request " + request);
		OutputResponse response = new OutputResponse();
		try {
			if (request != null) {
				String res = imrmmrService.saveIMRMMR(request,Authorization);
				if (res != null)
					response.setResponse(res);
				else
					response.setError(5000, "error in saving IMR/MMR data");
			} else
				logger.error("saveIMRMMR failed as request is empty");
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/fetchimrmmrmasters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String fetchSupportServices() {
		OutputResponse response = new OutputResponse();
		try {
			List<M_supportServices> supportServicesList = imrmmrService.getsupportServices();
			List<M_facilities> facilityList = imrmmrService.getFacilities();
			List<m_iMRMMRBaseCommunity> baseCommunity = imrmmrService.getBaseCommunities();
			List<m_iMRMMRTransitType> transitType = imrmmrService.getTransitType();
			List<m_iMRMMRHealthworker> healthWorker = imrmmrService.getHealthWorker();
			
			HashMap<String, Object> hmap = new HashMap<String, Object>();
			hmap.put("supportServicesList", supportServicesList);
			hmap.put("facilityList", facilityList);
			hmap.put("baseCommunityList",baseCommunity);
			hmap.put("transitTypeList",transitType);
			hmap.put("healthWorkerList",healthWorker);
			

			response.setResponse(new Gson().toJson(hmap));	
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);
		}
		return response.toString();
	}	

	@CrossOrigin()
	@RequestMapping(value = "/getIMRMMRList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String feedbackReuest(@RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {

			IMRMMR imrmmr = InputMapper.gson().fromJson(request, IMRMMR.class);
			String imrmmrdeatchtList = imrmmrService.getWorklistRequests(
					imrmmr.getBeneficiaryRegID(), imrmmr.getPhoneNum(),
					imrmmr.getRequestID());
			response.setResponse(imrmmrdeatchtList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
    @RequestMapping(value = "/update/ImrMmrComplaint", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
    public String updateImrMmrComplaint(@RequestBody String request) {
        OutputResponse output = new OutputResponse();
        try {
            logger.info("update immrmmr request " + request);
            IMRMMR complaint = InputMapper.gson().fromJson(request, IMRMMR.class);
            if (complaint != null && complaint.getRequestID() != null) {
                String result = imrmmrService.updateImrMmrRequest(complaint);
                if (result != null)
                    output.setResponse(result);
                else
                    output.setError(5000, "Error in data update");
            } else
                output.setError(5000, "Invalid request. Request ID is mandatory to update details");
        } catch (Exception e) {
            logger.error("update complaint failed with error " + e.getMessage());
            output.setError(5000, e.getMessage());
        }
        return output.toString();
    }
	
}
