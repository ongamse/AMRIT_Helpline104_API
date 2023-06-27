package com.iemr.helpline104.service.bloodComponentType;

import java.util.List;

import com.iemr.helpline104.data.bloodComponentType.M_BloodGroup;
import com.iemr.helpline104.data.bloodComponentType.M_ComponentType;

public interface BloodComponentTypeService {
	
	List<M_ComponentType> getBloodComponentTypes() throws Exception;
	
	List<M_BloodGroup> getBloodGroups() throws Exception;
}
