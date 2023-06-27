package com.iemr.helpline104.service.callqamapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.callqamapping.CallqaMappings;
import com.iemr.helpline104.data.callqamapping.M_104callqamapping;
import com.iemr.helpline104.data.diseaseScreening.M_questionairValues;
import com.iemr.helpline104.data.diseaseScreening.M_Questionnaire;
import com.iemr.helpline104.repository.callqamapping.CallqamappingRepository;


@Service
public class CallqamappingServiceImpl implements CallqamappingService{

	@Autowired
	public CallqamappingRepository callqamappingRepository;
	
	@Override
	public List<M_104callqamapping> save(CallqaMappings callqaMappings) throws Exception {
		List<M_104callqamapping> m_104callqamappings = new ArrayList<M_104callqamapping>();
		
		
		for(M_104callqamapping m_104callqamapping :callqaMappings.getM_104callqamapping()){
			m_104callqamappings.add(callqamappingRepository.save(m_104callqamapping));
		}
		return m_104callqamappings;
	}

	@Override
	public List<M_104callqamapping> getCDIQuestionScores(M_104callqamapping m_104callqamapping) throws Exception {
		List<M_104callqamapping> callqamappings = new ArrayList<M_104callqamapping>();
		Iterable<Objects[]> questionScores = callqamappingRepository.getCDIQuestionScores(m_104callqamapping.getBeneficiaryRegID(),m_104callqamapping.getBenCallID());
		for (Object[] objects : questionScores)
		{
		
		/*	M_104callqamapping callqamapping = new M_104callqamapping((Long)objects[0], (Integer)objects[1], (String)objects[2],
					(String)objects[3], (M_Questionnaire)objects[4]);*/
			
		/*	M_104callqamapping callqamapping = new M_104callqamapping((Long)objects[0], (Integer)objects[1], (String)objects[2],
					(String)objects[3], (M_104QuestionScore)objects[4], (String)objects[5]); */
			
			M_104callqamapping callqamapping = new M_104callqamapping((Long)objects[0], (String)objects[1], (Integer)objects[2],
					(String)objects[3], (String)objects[4], (String)objects[5], (String)objects[6], (String)objects[7]);
				
			callqamappings.add(callqamapping);
		}
		return callqamappings;
	
	}
	

}
