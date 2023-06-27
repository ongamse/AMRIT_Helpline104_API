package com.iemr.helpline104.service.location;


import java.util.List;

import com.iemr.helpline104.data.location.CityDetails;
import com.iemr.helpline104.data.location.DistrictBlock;
import com.iemr.helpline104.data.location.DistrictBranchMapping;
import com.iemr.helpline104.data.location.Districts;
import com.iemr.helpline104.data.location.States;

public interface LocationService {

	public List<States> getStates(int id);

	public List<Districts> getDistricts(int id);
	
	public List<Districts> findStateDistrictBy(int id);

	public List<DistrictBlock> getDistrictBlocks(int id);

	public abstract List<CityDetails> getCities(int id);

	public abstract List<DistrictBranchMapping> getDistrilctBranchs(int id);
	
	//public Iterable<States> getDisricts();
	
	//public Iterable<States> getTalukas();
	
	//public Iterable<States> getVillages();
}
