package com.iemr.helpline104.repository.report;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.report.BeneficiaryReport;

@Repository
@RestResource(exported = false)
public interface BeneficiaryReportRepository extends CrudRepository<BeneficiaryReport, Long>
{
	/*@Query("select b.beneficiaryID, b.title,  b.firstName, b.lastName, b.gender, b.maritalStatus, b.dob, b.spouseName, b.emergencyRegistration, b.healthCareWorker, b.education, "
			+ "b.occupation, b.community, b.emailId, b.permVillage, b.permSubDistrict, b.permDistrict, "
			+ "c.callTypeName, c.callSubTypeName, c.phoneNo, c.callReceivedUserID, c.callEndUserID " + "from bencallReport c "
			+ " LEFT JOIN c.BeneficiaryReport b " + "where c.providerServiceMapID=:providerServiceMapID " + "and c.isCalledEarlier = 0 "
			+ "and c.lodadedDate > :startDateTime " + "and c.lodadedDate < :endDateTime " + "order by c.lodadedDate desc")
	public List<Objects[]> getROSummaryReportByDate(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime);*/

}
