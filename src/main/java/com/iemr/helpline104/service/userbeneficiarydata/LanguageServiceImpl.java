package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.userbeneficiarydata.M_Gender;
import com.iemr.helpline104.data.userbeneficiarydata.M_Language;
import com.iemr.helpline104.repository.userbeneficiarydata.GenderRepository;
import com.iemr.helpline104.repository.userbeneficiarydata.LanguageRepository;

@Service
public class LanguageServiceImpl implements LanguageService {
	private LanguageRepository languageRepository;

	@Autowired
	public void setGenderServiceImpl(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	public List<M_Language> getActiveLanguages() {
		List<M_Language> genderList = new ArrayList<M_Language>();
		Set<Objects[]> queryResult =  languageRepository.findAciveLanguages();
		for (Object[] objects : queryResult) {
			if (objects!=null && objects.length == 2) {
				genderList.add(new M_Language((Integer)objects[0], (String)objects[1]));
			}
		}
		return genderList;
	}
}
