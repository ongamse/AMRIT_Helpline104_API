package com.iemr.helpline104.repository.report;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.report.FoodsafetyReport;

@Repository
@RestResource(exported = false)
public interface FoodSafetyReportRepository extends CrudRepository<FoodsafetyReport, Long>
{

	@Query("select t.fsComplaintID, t.requestID, t.beneficiaryRegID, t.benCallID, t.typeOfRequest, t.isDiarrhea, t.isVomiting, "
			+ "t.isAbdominalPain, t.isChillsOrRigors, t.isGiddiness, t.isDehydration, t.isRashes, t.fromWhen, t.historyOfDiet, t.isFoodConsumed, t.typeOfFood, t.foodConsumedFrom, t.associatedSymptoms, t.feedbackType, t.remarks, t.isSelf, t.patientName, t.patientAge, t.patientGender, t.createdDate, b.beneficiaryID, b.firstName, b.lastName, b.healthCareWorker, b.gender, b.dob, b.permVillage, b.permSubDistrict, b.permDistrict, "
			+ "c.callTypeName, c.callSubTypeName, c.phoneNo, c.callReceivedUserID, c.callEndUserID, c.agentID, user.firstName "
			+ "from FoodsafetyReport t "
			+ "LEFT JOIN t.beneficiaryReport b " + " LEFT JOIN t.bencallReport c "
			+ "left join c.userReportObj user "	
			+"where t.providerServiceMapID=:providerServiceMapID "
			+ "and t.createdDate > :startDateTime " + "and t.createdDate < :endDateTime " + "order by t.fsComplaintID desc")
	public List<Objects[]> getFoodsafetyReportByDate(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime);

}
