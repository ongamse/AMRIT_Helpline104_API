package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.userbeneficiarydata.M_Community;
import com.iemr.helpline104.repository.beneficiary.CommunityRepository;

@Service
public class CommunityServiceImpl implements CommunityService {
	private CommunityRepository communityRepository;

	@Autowired
	public void setCommunityServiceImpl(CommunityRepository communityRepository) {
		this.communityRepository = communityRepository;
	}

	public List<M_Community> getActiveCommunities() {
		List<M_Community> communitiesList = new ArrayList<M_Community>();
		Set<Objects[]> queryReult = communityRepository.findAciveCommunities();
		for (Object[] objects : queryReult) {
			if (objects!=null && objects.length == 2) {
				communitiesList.add(new M_Community((Integer) objects[0], (String) objects[1]));
			}
		}
		return communitiesList;
	}
}
