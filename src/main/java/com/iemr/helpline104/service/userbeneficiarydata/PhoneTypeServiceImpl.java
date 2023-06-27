package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.location.States;
import com.iemr.helpline104.data.userbeneficiarydata.M_PhoneType;
import com.iemr.helpline104.repository.userbeneficiarydata.PhoneTypeRepository;

@Service
public class PhoneTypeServiceImpl implements PhoneTypeService{

	@Autowired
	private PhoneTypeRepository phoneTypeRepository;
	@Override
	public List<M_PhoneType> getActivePhoneTypes() {
		
		List<M_PhoneType> phoneTypesList = new ArrayList<M_PhoneType>();
		List<Objects[]> phoneTypes = phoneTypeRepository.findAcivePhoneTypes();
		
		for(Object[] phoneType:phoneTypes){
			if(null!=phoneType && phoneType.length>0){
				phoneTypesList.add(new M_PhoneType((Short)phoneType[0], (String)phoneType[1]));
			}
		}
		return phoneTypesList;
	}

	
}
