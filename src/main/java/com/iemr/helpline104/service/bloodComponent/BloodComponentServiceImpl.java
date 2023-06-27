package com.iemr.helpline104.service.bloodComponent;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.bloodComponent.M_Component;
import com.iemr.helpline104.data.bloodRequest.T_BloodRequest;
import com.iemr.helpline104.repository.bloodComponent.BloodComponentRepository;

@Service
public class BloodComponentServiceImpl implements BloodComponentService{

	@Autowired
	private BloodComponentRepository bloodComponentRepository;
	@Override
	public M_Component save(M_Component m_component) {
		return bloodComponentRepository.save(m_component);
	}

	@Override
	public List<M_Component> getBloodComponents(Integer componentID) throws Exception {
		List<M_Component> bloodComponentList = new ArrayList<M_Component>();
		List<Objects[]> bloodComponents = bloodComponentRepository.getBloodComponents(componentID);
		
		for (Object[] objects : bloodComponents) {
			if (objects!=null && objects.length > 0) {

				bloodComponentList.add(new M_Component((Integer)objects[0], (String)objects[1], (String)objects[2]));
			}
		}
		return bloodComponentList;
	}

}
