package com.iemr.helpline104.repository.report;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.report.BencallReport;

@Repository
@RestResource(exported = false)
public interface BencallReportRepository extends CrudRepository<BencallReport, Long>
{

	@Query("select b.beneficiaryID, b.title,  b.firstName, b.lastName, b.gender, b.maritalStatus, b.dob, b.spouseName, b.emergencyRegistration, b.healthCareWorker, b.education, "
			+ "b.occupation, b.community, b.emailId, b.permVillage, b.permSubDistrict, b.permDistrict, b.createdDate, "
			+ "c.callTypeName, c.callSubTypeName, c.phoneNo, c.callReceivedUserID, c.callEndUserID, c.agentID, user.firstName "
			+ "from BencallReport c "
			+ "LEFT JOIN c.beneficiaryReport b "
			+ "left join c.userReportObj user "
			+ "where c.providerServiceMapID=:providerServiceMapID " + "and c.isCalledEarlier = false "+ "and c.beneficiaryRegID IS NOT NULL "
			+ "and b.createdDate > :startDateTime " + "and b.createdDate < :endDateTime " + "group by b.beneficiaryID " + "order by b.createdDate desc ")
	public List<Objects[]> getROSummaryReportByDate(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime);
	
	@Query("select b.beneficiaryID, b.title,  b.firstName, b.lastName, b.gender, b.maritalStatus, b.dob, b.spouseName, b.emergencyRegistration, b.healthCareWorker, b.education, "
			+ "b.occupation, b.community, b.emailId, b.permVillage, b.permSubDistrict, b.permDistrict, b.createdDate, "
			+ "c.callTypeName, c.callSubTypeName, c.phoneNo, c.callReceivedUserID, c.callEndUserID, c.agentID, user.firstName "
			+"from BencallReport c "  
			+"LEFT JOIN c.beneficiaryReport b "  
			+"left join c.userReportObj user "
			+ "where c.providerServiceMapID=:providerServiceMapID " + "and c.agentID =:agentID "+ "and c.isCalledEarlier = false "+ "and c.beneficiaryRegID IS NOT NULL "
			+ "and b.createdDate > :startDateTime " + "and b.createdDate < :endDateTime " + "group by b.beneficiaryID " + "order by b.createdDate desc")
	public List<Objects[]> getROSummaryReportByAgentIDAndDate(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("agentID") String agentID, @Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime);
	
}
