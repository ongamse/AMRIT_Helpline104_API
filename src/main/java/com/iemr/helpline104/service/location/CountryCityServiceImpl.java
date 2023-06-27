package com.iemr.helpline104.service.location;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.location.CountryCity;
import com.iemr.helpline104.data.location.MCountry;
import com.iemr.helpline104.repository.location.CountryCityRepository;
@Service
public class CountryCityServiceImpl implements CountryCityService{

	@Autowired
	private CountryCityRepository countryCityRepository;
	
	@Override
	public String getCountry() {

		List<MCountry> list = new ArrayList<MCountry>();
		list = countryCityRepository.getCountry();
		
		return list.toString();
	}
	
	@Override
	public String getCities(Integer countryID) {

		List<CountryCity> list = new ArrayList<CountryCity>();
		list = countryCityRepository.getCities(countryID);
		
		return list.toString();
	}
	
}
