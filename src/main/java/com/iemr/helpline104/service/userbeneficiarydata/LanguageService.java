package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.List;

import com.iemr.helpline104.data.userbeneficiarydata.M_Gender;
import com.iemr.helpline104.data.userbeneficiarydata.M_Language;

public interface LanguageService {
	List<M_Language> getActiveLanguages();
}
