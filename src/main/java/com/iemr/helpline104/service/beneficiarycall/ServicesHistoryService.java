package com.iemr.helpline104.service.beneficiarycall;

import java.util.List;
import java.util.Objects;

import com.iemr.helpline104.data.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.helpline104.data.beneficiarycall.ServicesMaster104;

public interface ServicesHistoryService {

	/**
	 * 
	 * @return service history list
	 */
	//List<BenCallServicesMappingHistory> getServiceHistory(Long id);

	/**
	 * 
	 * @param service104HistoryDetails
	 * @return saved object
	 */
	BenCallServicesMappingHistory createServiceHistory(BenCallServicesMappingHistory service104HistoryDetails);

	//List<BenCallServicesMappingHistory> getCallSummary(Long id);

	//List<BenCallServicesMappingHistory> getReferralsHistory(Long id, int pageNo, int rows);

	//List<BenCallServicesMappingHistory> getFeedbacksHistory(Long id, int pageNo, int rows);

	//List<BenCallServicesMappingHistory> getInformationsHistory(Long id, int pageNo, int rows);
	
	List<Objects[]> getServices(Integer providerServiceMapID);
	
    public String saveCallDisconnectedData(String requestObj) throws Exception;


	
}
