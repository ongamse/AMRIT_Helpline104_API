package com.iemr.helpline104.service.scheme;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iemr.helpline104.data.scheme.T_Schemeservice;
import com.iemr.helpline104.repository.scheme.SchemeRepository;
@Service
public class SchemeServiceImpl implements SchemeService{

	@Autowired 
	private SchemeRepository schemeRepository;	
	
	
	@Override
	public List<T_Schemeservice> getSchemeSearchHistory(Long benificiaryRegID, Long benCallID)
	{

		List<T_Schemeservice> schemeServiceList = new ArrayList<T_Schemeservice>();
		

		if (benificiaryRegID != null)
			schemeServiceList = schemeRepository.findByBeneficiaryRegID(benificiaryRegID);
		else if (benCallID != null)
			schemeServiceList = schemeRepository.findByBenCallID(benCallID);
		
		return schemeServiceList;
	}


	@Override
	public String saveSchemeSearchHistory(T_Schemeservice[] schemeHistory) 
	{
		Iterable<T_Schemeservice> savedSchemeResponse = schemeRepository.save(Arrays.asList(schemeHistory));

		return savedSchemeResponse.toString();
	}

}
