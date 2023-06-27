package com.iemr.helpline104.service.casesheet;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.beneficiarycall.OutboundCallRequest;
import com.iemr.helpline104.data.casesheet.COVIDHistory;
import com.iemr.helpline104.data.casesheet.H104BenMedHistory;
import com.iemr.helpline104.repository.beneficiarycall.BeneficiaryCallRepository;
import com.iemr.helpline104.repository.beneficiarycall.OutboundCallRequestRepository;
import com.iemr.helpline104.repository.casesheet.COVIDRepository;
import com.iemr.helpline104.repository.casesheet.H104BenHistoryRepository;
import com.iemr.helpline104.service.prescription.PrescriptionService;

@Service
public class H104BenHistoryServiceImpl implements H104BenHistoryService
{

	@Autowired
	private H104BenHistoryRepository h104BenHistoryRepository;

	@Autowired
	private BeneficiaryCallRepository beneficiaryCallRepository;

	@Autowired
	private OutboundCallRequestRepository outboundCallRequestRepository;

	@Autowired
	private PrescriptionService prescriptionService;	
	
	@Autowired
	private COVIDRepository covidRepository;
	

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	/*
	 * @Override public ArrayList<Objects[]> geSmpleBenHistory(Long beneficiaryId, Long benCallID) {
	 * 
	 * ArrayList<Objects[]> benHistory = null;
	 * 
	 * if(beneficiaryId != null) benHistory = h104BenHistoryRepository.getBenHistory(beneficiaryId); else if(benCallID
	 * != null) benHistory = h104BenHistoryRepository.getHistoryByBenCallID(benCallID);
	 * 
	 * return benHistory; }
	 */

	@Override
	public List<H104BenMedHistory> geSmpleBenHistory(Long beneficiaryId, Long benCallID)
	{

		List<H104BenMedHistory> benHistory = null;

		if (beneficiaryId != null)
			benHistory = h104BenHistoryRepository.getBenHistory(beneficiaryId);
		else if (benCallID != null)
		{
			benHistory = h104BenHistoryRepository.findByBenCallID(benCallID);

			for (H104BenMedHistory benMedHistory : benHistory)
			{
				List<OutboundCallRequest> outboundCallRequests = outboundCallRequestRepository.findByBenCallID(benMedHistory.getBenCallID());
				if (outboundCallRequests.size() > 0)
					benMedHistory.setOutboundCallRequest(outboundCallRequests.get(0));
				/*
				 * else benMedHistory.setOutboundCallRequest(new OutboundCallRequest());
				 */
				if (benMedHistory.getActionByMO() != null || benMedHistory.getActionByPD() != null)
					benMedHistory.setPrescription(prescriptionService.getPrescriptionListByBenCallID(benMedHistory.getBenCallID()));
				
			/*	if (benMedHistory.getBenCallID() != null)
					benMedHistory.setBenCall(benCallRepository.findByBenCallID(benMedHistory.getBenCallID())); */
			}
		}

		return benHistory;
	}

	@Override
	public List<H104BenMedHistory> getPresentCasesheet(Long beneficiaryId, String callID)
	{

		List<H104BenMedHistory> caseSheet = h104BenHistoryRepository.getPresentBenHistory(beneficiaryId, new PageRequest(0, 1));

		if (caseSheet != null && caseSheet.size() > 0)
		{

			H104BenMedHistory smpleBenHistory = caseSheet.get(0);
			Long benCallID = smpleBenHistory.getBenCallID();
			logger.info("benCallID: " + benCallID);

			if (benCallID != null)
			{
				String latestCallID = beneficiaryCallRepository.findCallIDFromBenCallID(benCallID).trim();

				logger.info("latestCallID: " + latestCallID + " callID: " + callID);

				if (!latestCallID.equals(callID))
				{
					logger.info("clearing list");
					caseSheet.clear();
				}

			}
		}

		logger.info("returning casesheet of size: " + (caseSheet!=null ? caseSheet.size():"No data found"));
		return caseSheet;
	}

	@Override
	public H104BenMedHistory saveSmpleBenHistory(H104BenMedHistory smpleBenHistory,COVIDHistory covidHistory)
	{
		H104BenMedHistory benmed = h104BenHistoryRepository.save(smpleBenHistory);
		if(covidHistory.getIsCOVIDAvailable() !=null && covidHistory.getIsCOVIDAvailable()==true)
		{
			covidHistory.setBenHistoryID(benmed.getBenHistoryID());
			covidRepository.save(covidHistory);
		}
		return benmed;
	}

}
