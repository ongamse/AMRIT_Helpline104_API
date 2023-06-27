package com.iemr.helpline104.repository.feedback;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.feedback.FeedbackDetails;

@Repository
@RestResource(exported = false)
public interface FeedbackRepository extends CrudRepository<FeedbackDetails, Long> {

	@Query("select feedbackID, severityID, feedbackTypeID, feedbackStatusID, feedback, createdBy, feedbackAgainst "
			+ "from FeedbackDetails where beneficiaryRegID = :id")
	public ArrayList<Objects[]> findByBeneficiaryID(@Param("id") long id);

	@Query("select feedbackID, severityID, feedbackTypeID, feedbackStatusID, feedback, createdBy, feedbackAgainst "
			+ "from FeedbackDetails where feedbackID = :id")
	public ArrayList<Objects[]> findByFeedbackID(@Param("id") long id);

//	@Query("SELECT feedbackID, severityID, feedbackTypeID, feedbackStatusID, feedback, createdBy, feedbackAgainst "
//			+ "from FeedbackDetails where feedbackID = :id AND  ")
//	public ArrayList<Objects[]> findByGrievanceID(@Param("id") String id);

//	@Query("SELECT f FROM FeedbackDetails f WHERE feedbackID = :id AND deleted=false ")
//	public ArrayList<FeedbackDetails> findByGrievanceID(@Param("id") String id);

	@Query("SELECT f FROM FeedbackDetails f WHERE feedbackID = :id AND deleted=false ")
	public ArrayList<FeedbackDetails> findByFeedbackIDNew(@Param("id") long id);

	// shubham 29-09-2020
//	@Query("select feedbackID, severityID, feedbackTypeID, feedbackStatusID, feedback, createdBy, feedbackAgainst "
//			+ "from FeedbackDetails f " + " LEFT JOIN BeneficiaryMapping ben ON f.beneficiaryRegID=ben.benRegID "
//			+ "LEFT JOIN BenContactMapping bc ON bc.benContactsID=ben.benContactsId "
//			+ " where f.deleted=false and bc.preferredPhoneNum = :mobile order by f.feedbackID desc")
//	public ArrayList<Objects[]> findByMobile(@Param("mobile") String mobile);

	@Query("SELECT t FROM FeedbackDetails t WHERE t.requestID = :requestID AND deleted=false ")
	public FeedbackDetails searchByRequestID(@Param("requestID") String requestID);

}
