package com.iemr.helpline104.repository.report;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.report.BloodrequestReport;
import com.iemr.helpline104.data.report.EpidemicoutbreakReport;
import com.iemr.helpline104.data.report.OrgandonationReport;

@Repository
@RestResource(exported = false)
public interface OrgandonationReportRepository extends CrudRepository<OrgandonationReport, Long>
{

	@Query("select t.organDonationID, t.requestID, t.beneficiaryRegID, t.benCallID, t.donarName, t.donarAge, t.donarGender, t.donationTypeName, "
			+ "t.donatableOrganName, t.acceptorHospitalName, t.acceptorHospitalState, t.acceptorHospitalDistrict, t.acceptorHospitalSubDistrict, t.acceptorHospitalVillage, t.remarks, t.isSelf, t.createdDate, b.beneficiaryID, b.firstName, b.lastName, b.healthCareWorker, b.gender, b.dob, b.permVillage, b.permSubDistrict, b.permDistrict, "
			+ "c.callTypeName, c.callSubTypeName, c.phoneNo, c.callReceivedUserID, c.callEndUserID, c.agentID, user.firstName "
			+ "from OrgandonationReport t "
			+ "LEFT JOIN t.beneficiaryReport b " + " LEFT JOIN t.bencallReport c "
			+ "left join c.userReportObj user "	
			+ "where t.providerServiceMapID=:providerServiceMapID "
			+ "and t.createdDate > :startDateTime " + "and t.createdDate < :endDateTime " + "order by t.createdDate desc")
	public List<Objects[]> getOrgandonationReportByDate(
			@Param("providerServiceMapID") Integer providerServiceMapID, @Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime);

}
