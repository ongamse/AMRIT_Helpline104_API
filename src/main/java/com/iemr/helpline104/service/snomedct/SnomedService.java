package com.iemr.helpline104.service.snomedct;

import java.util.List;

import com.iemr.helpline104.data.snomedct.SCTDescription;

public interface SnomedService {
	
	public List<SCTDescription> findSnomedCTRecordFromTerm(String term);

}
