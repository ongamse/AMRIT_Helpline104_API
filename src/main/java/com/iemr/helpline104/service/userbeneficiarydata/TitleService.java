package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.List;

import com.iemr.helpline104.data.userbeneficiarydata.M_Title;

public abstract interface TitleService {
	public abstract List<M_Title> getActiveTitles();
}
