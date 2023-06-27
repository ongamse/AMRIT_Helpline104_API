package com.iemr.helpline104.service.drugGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.drugGroup.M_DrugGroup;
import com.iemr.helpline104.data.drugMapping.M_104drugmapping;
import com.iemr.helpline104.data.feedbackType.M_FeedbackType;
import com.iemr.helpline104.repository.drugGroup.DrugFrequencyRepository;
import com.iemr.helpline104.repository.drugGroup.DrugGroupRepository;
import com.iemr.helpline104.repository.drugGroup.DrugStrengthRepository;

@Service
public class DrugGroupServiceImpl implements DrugGroupService{

	@Autowired
	private DrugGroupRepository drugGroupRepository;
	
	@Autowired
	private DrugFrequencyRepository drugFrequencyRepository;
	
	@Autowired
	private DrugStrengthRepository drugStrengthRepository;
	
	/*@Override
	public List<Objects[]> getDrugList(Integer providerServiceMapID) throws Exception {
		List<M_DrugGroup> drugsList = new ArrayList<M_DrugGroup>();
		List<Objects[]> drugs = drugGroupRepository.getDrugsList(providerServiceMapID);
		
		for (Object[] objects : drugs) {
			if (objects!=null && objects.length > 0) {
				
		
				drugsList.add(new M_DrugGroup((Integer)objects[0], (String)objects[1], (String)objects[2], (Integer)objects[3], (String)objects[4], 
						(String)objects[5], (String)objects[6], (String)objects[7], (String)objects[8]));
			}
		}
		return drugs;
	}*/
	
	
	@Override
	public List<M_DrugGroup> getDrugGroups(Integer providerServiceMapID) throws Exception {
		
		List<M_DrugGroup> drugGroups = new ArrayList<M_DrugGroup>();
		List<Objects[]> drugs = drugGroupRepository.getDrugGroups(providerServiceMapID);
		
		for (Object[] objects : drugs) {
			if (objects!=null && objects.length > 0) {
				
		
				drugGroups.add(new M_DrugGroup((Integer)objects[0], (String)objects[1], (String)objects[2]));
			}
		}
		
		return drugGroups;
	}
	@Override
	public List<M_104drugmapping> getDrugList(Integer providerServiceMapID, Integer drugGroupID) throws Exception {
		List<M_104drugmapping> drugsList = new ArrayList<M_104drugmapping>();
		List<Objects[]> drugs = drugGroupRepository.getDrugList(providerServiceMapID, drugGroupID);
		
		for (Object[] objects : drugs) {
			if (objects!=null && objects.length > 0) {
				
				drugsList.add(new M_104drugmapping((Integer)objects[0], (Integer)objects[1], (String)objects[2],
						(Integer)objects[3], (String)objects[4], (String)objects[5],
						(Integer)objects[6]));
			}
		}
		
		return drugsList;
	}
	
	@Override
	public ArrayList<Objects[]> getDrugFrequency() {
		
			
		return  drugFrequencyRepository.getDrugFrequency();
	}
	
	@Override
	public ArrayList<Objects[]> getDrugStrength(Integer serviceProviderID) {
		
			
		return  drugStrengthRepository.getDrugStrength(serviceProviderID);
	}

	@Override
	public List<M_104drugmapping> getDrugDetailList(Integer providerServiceMapID) throws Exception {
		List<M_104drugmapping> drugsList = new ArrayList<M_104drugmapping>();
		List<Objects[]> drugs = drugGroupRepository.getDrugDetailList(providerServiceMapID);
		
		for (Object[] objects : drugs) {
			if (objects!=null && objects.length > 0) {
				
				drugsList.add(new M_104drugmapping((Integer)objects[0], (Integer)objects[1], (String)objects[2],
						(Integer)objects[3], (String)objects[4], (String)objects[5],
						(Integer)objects[6]));
			}
		}
		
		return drugsList;
	}
}
