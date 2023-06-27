package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.List;

import com.iemr.helpline104.data.userbeneficiarydata.M_Religion;

public abstract interface RelegionService {
	public abstract List<M_Religion> getActiveReligions();
}
