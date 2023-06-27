package com.iemr.helpline104.repository.search;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.feedback.FeedbackDetails;


@Repository
@RestResource(exported = false)
public interface SearchOnFeedbackRepo extends CrudRepository<FeedbackDetails, Long> {

	
	@Query("select feedbackID, severityID, feedbackTypeID, feedbackStatusID, feedback, createdBy, feedbackAgainst "
			+ "from FeedbackDetails ")
	public List<Objects[]> searchOnFeedbackRepo(@Param("grievanceId") String grievanceId,@Param("mobileNumber") String mobileNumber);

	
}
