package com.iemr.helpline104.service.bloodComponent;

import java.util.List;
import com.iemr.helpline104.data.bloodComponent.M_Component;


public interface BloodComponentService {

	public M_Component save(M_Component m_component);
	
	List<M_Component> getBloodComponents(Integer componentID) throws Exception;
	
}
