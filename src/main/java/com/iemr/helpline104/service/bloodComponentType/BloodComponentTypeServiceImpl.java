package com.iemr.helpline104.service.bloodComponentType;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.bloodComponentType.M_BloodGroup;
import com.iemr.helpline104.data.bloodComponentType.M_ComponentType;
import com.iemr.helpline104.data.bloodRequest.T_BloodRequest;
import com.iemr.helpline104.repository.bloodComponentType.BloodComponentTypeRepository;

@Service
public class BloodComponentTypeServiceImpl implements BloodComponentTypeService {

	@Autowired
	private BloodComponentTypeRepository componentTypeRepository;
	@Override
	public List<M_ComponentType> getBloodComponentTypes() throws Exception{
		List<M_ComponentType> componentTypeList = new ArrayList<M_ComponentType>();
		List<Objects[]> componentTypes = componentTypeRepository.getComponentTypes();
		
		for (Object[] objects : componentTypes) {
			if (objects!=null && objects.length > 0) {

				componentTypeList.add(new M_ComponentType((Integer)objects[0], (String)objects[1], (String)objects[2]));
			}
		}
		return componentTypeList;
	}

	@Override
	public List<M_BloodGroup> getBloodGroups() throws Exception {
		List<M_BloodGroup> bloodGroupsList = new ArrayList<M_BloodGroup>();
		List<Objects[]> bloodgroups = componentTypeRepository.getBloodGroups();
		
		for (Object[] objects : bloodgroups) {
			if (objects!=null && objects.length > 0) {

				bloodGroupsList.add(new M_BloodGroup((Integer)objects[0], (String)objects[1], (String)objects[2]));
			}
		}
		return bloodGroupsList;
	}
	
}
