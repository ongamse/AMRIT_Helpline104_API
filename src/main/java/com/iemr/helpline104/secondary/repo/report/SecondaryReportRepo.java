package com.iemr.helpline104.secondary.repo.report;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.secondary.data.BencallReport;




@Repository
@RestResource(exported = false)
public interface SecondaryReportRepo extends CrudRepository<BencallReport, Long> {




	@Query(value="call Pr_104BeneficiaryReport(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getRegisterationReport(@Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
			@Param("providerServiceMapID") Integer providerServiceMapID);
	

	@Query(value="call Pr_104HAOReport(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getHAOReport(@Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
			@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query(value="call Pr_104MOReport(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getMOReport(@Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
			@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query(value="call Pr_104MODetailsReport(:startDateTime,:endDateTime,"
			+ ":districtID,:subDistrictID,:villageID,:roleID,:locationID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getMODetailsReport(@Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime,
			@Param("providerServiceMapID") Integer providerServiceMapID,@Param("districtID") Long districtID,
			@Param("subDistrictID") Long subDistrictID,@Param("villageID") Long villageID,
			@Param("roleID") Long roleID,@Param("locationID") Long locationID);
	
	@Query(value="call Pr_104COReport(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getCOReport(@Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
			@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query(value="call Pr_104FoodsafetyComplaint(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getFoodSafetyReport(@Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
			@Param("providerServiceMapID") Integer providerServiceMapID);
	
	
	@Query(value="call Pr_104CODetailGuidelinesReport(:startDateTime,:endDateTime,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getGuidelinesReport(@Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime,
			@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query(value="call Pr_104CODetailGCategoryReport(:startDateTime,:endDateTime,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getCategoryReport(@Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime,
			@Param("providerServiceMapID") Integer providerServiceMapID);
	

	@Query(value="call Pr_104GrievanceReport(:startDateTime,:endDateTime,:feedbackTypeID,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getGrievanceReport(@Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
			@Param("providerServiceMapID") Integer providerServiceMapID,@Param("feedbackTypeID") Short feedbackTypeID);
    
	@Query(value="call Pr_104SurveyorReport(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getCDIResponseReport(@Param("startDateTime") Timestamp startDateTime,
	@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
	@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query(value="call Pr_104HealthSchemes(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getSchemeServiceReport(@Param("startDateTime") Timestamp startDateTime, 
			@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
			@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query(value="call Pr_104DirectoryServiceReport(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getDirectoryserviceReport(@Param("startDateTime") Timestamp startDateTime, 
			@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
			@Param("providerServiceMapID") Integer providerServiceMapID);
	

	@Query(value="call Pr_104PrescriptionReport(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getPrescriptionReport(@Param("startDateTime") Timestamp startDateTime,
	@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
	@Param("providerServiceMapID") Integer providerServiceMapID);

	@Query(value="call Pr_104BoodRequest(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getBloodRequestReport(@Param("startDateTime") Timestamp startDateTime,
	@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
	@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query(value="call Pr_104BoodRequestDetails_Componentwise(:startDateTime,:endDateTime,:districtID,:subDistrictID,:villageID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getComponentReport(@Param("startDateTime") Timestamp startDateTime,
	@Param("endDateTime") Timestamp endDateTime,@Param("districtID") Integer districtID, @Param("subDistrictID") Integer subDistrictID,
	@Param("villageID") Integer villageID, @Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query(value="call Pr_104BoodRequestDetails_Groupwise(:startDateTime,:endDateTime,:districtID,:subDistrictID,:villageID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getGroupReport(@Param("startDateTime") Timestamp startDateTime,
	@Param("endDateTime") Timestamp endDateTime,@Param("districtID") Integer districtID, @Param("subDistrictID") Integer subDistrictID,
	@Param("villageID") Integer villageID,@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query(value="call Pr_104BoodRequestDetails_Componentwise_Pivot(:startDateTime,:endDateTime,:districtID,:subDistrictID,:villageID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getDistrictComponentReport(@Param("startDateTime") Timestamp startDateTime,
	@Param("endDateTime") Timestamp endDateTime,@Param("districtID") Integer districtID, @Param("subDistrictID") Integer subDistrictID,
	@Param("villageID") Integer villageID,@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query(value="call Pr_104BoodRequestDetails_Groupwise_Pivot(:startDateTime,:endDateTime,:districtID,:subDistrictID,:villageID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getDistrictGroupReport(@Param("startDateTime") Timestamp startDateTime,
	@Param("endDateTime") Timestamp endDateTime,@Param("districtID") Integer districtID, @Param("subDistrictID") Integer subDistrictID,
	@Param("villageID") Integer villageID,@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query(value="call Pr_104Epidemicoutbreak(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getEpidemicoutbreakReport(@Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
			@Param("providerServiceMapID") Integer providerServiceMapID);
			
	@Query(value="call Pr_104OrganDonation(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getOrgandonationReport(@Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
			@Param("providerServiceMapID") Integer providerServiceMapID);
	
	@Query(value="call Pr_104psychiatrist(:startDateTime,:endDateTime,:agentID,:providerServiceMapID)", nativeQuery=true)
	public List<Objects[]> getPDSummaryReport(@Param("startDateTime") Timestamp startDateTime,
			@Param("endDateTime") Timestamp endDateTime,@Param("agentID") String agentID,
			@Param("providerServiceMapID") Integer providerServiceMapID);
}

