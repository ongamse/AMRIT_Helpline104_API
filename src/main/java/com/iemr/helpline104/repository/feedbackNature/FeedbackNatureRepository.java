package com.iemr.helpline104.repository.feedbackNature;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.feedbackNature.M_FeedbackNature;

@Repository
@RestResource(exported = false)
public interface FeedbackNatureRepository extends CrudRepository<M_FeedbackNature, Long>{

	@Query("select n.feedbackNatureID, n.feedbackNature, n.feedbackNatureDesc "
			+ "from M_FeedbackType t"
			+ " INNER JOIN t.m_feedbackNature n "
			+ "where n.deleted=false and t.providerServiceMapID=:serviceLineID and t.feedbackTypeID=:feedbackTypeID")
	public List<Objects[]> getNatureOfComplaintTypes(@Param("serviceLineID") Integer serviceLineID,@Param("feedbackTypeID") Short feedbackTypeID) throws Exception;
}
