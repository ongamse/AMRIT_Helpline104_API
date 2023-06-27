package com.iemr.helpline104.service.userbeneficiarydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline104.data.userbeneficiarydata.M_Title;
import com.iemr.helpline104.repository.userbeneficiarydata.TitleRepository;

@Service
public class TitleServiceImpl implements TitleService {
	private TitleRepository titleRepository;

	@Autowired
	public void setTitleServiceImpl(TitleRepository titleRepository) {
		this.titleRepository = titleRepository;
	}

	public List<M_Title> getActiveTitles() {
		List<M_Title> activeTitles = new ArrayList();
		Set<Objects[]> lists = this.titleRepository.findAciveTitles();
		for (Object[] objects : lists) {
			if ((objects != null) && (objects.length == 3)) {
				activeTitles.add(new M_Title(((Integer) objects[0]).intValue(), (String) objects[1]));
			}
		}
		return activeTitles;
	}
}
