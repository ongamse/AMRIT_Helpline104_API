package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.List;

import com.iemr.helpline104.data.userbeneficiarydata.M_Status;

public abstract interface StatusService {
	public abstract List<M_Status> getActiveStatus();
}
