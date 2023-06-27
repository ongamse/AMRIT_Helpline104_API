package com.iemr.helpline104.service.drugGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.iemr.helpline104.data.drugGroup.M_DrugGroup;
import com.iemr.helpline104.data.drugMapping.M_104drugmapping;

public interface DrugGroupService {
	
	public List<M_DrugGroup> getDrugGroups(Integer providerServiceMapID) throws Exception;
	
	public List<M_104drugmapping> getDrugList(Integer providerServiceMapID,Integer drugGroupID) throws Exception;
	
	public ArrayList<Objects[]> getDrugFrequency() throws Exception; 
	
	public ArrayList<Objects[]> getDrugStrength(Integer serviceProviderID) throws Exception;

	List<M_104drugmapping> getDrugDetailList(Integer providerServiceMapID) throws Exception; 
}
