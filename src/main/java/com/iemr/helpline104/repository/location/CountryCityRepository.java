package com.iemr.helpline104.repository.location;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.location.CountryCity;
import com.iemr.helpline104.data.location.MCountry;

@Repository
@RestResource(exported = false)
public interface CountryCityRepository extends CrudRepository<CountryCity, Integer> {

	@Query("select country from MCountry country where country.deleted = false order by country.countryName asc")
	public ArrayList<MCountry> getCountry();
	
	@Query("select city from CountryCity city where city.countryID = :countryID and city.deleted = false order by city.cityName asc")
	public ArrayList<CountryCity> getCities(@Param("countryID") Integer countryID);

}
