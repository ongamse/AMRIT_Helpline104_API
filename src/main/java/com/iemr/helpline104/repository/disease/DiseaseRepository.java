package com.iemr.helpline104.repository.disease;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.disease.Disease;

@Repository
@RestResource(exported = false)
public interface DiseaseRepository extends CrudRepository<Disease, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Disease set deleted = :deleted where diseasesummaryID = :diseasesummaryID")
	public int deleteDisease(@Param("diseasesummaryID") Integer diseasesummaryID,@Param("deleted") Boolean deleted);
	
	@Query("Select count(*) from Disease disease ")
	public Integer getDiseaseCount();
	
	@Transactional
	@Modifying
	@Query("UPDATE Disease set diseaseName = :diseaseName, "
			+ "summary =:summary, couldbedangerous =:couldbedangerous, causes =:causes, dos_donts =:dos_donts, symptoms_Signs =:symptoms_Signs, "
			+ "medicaladvice =:medicaladvice, riskfactors =:riskfactors, treatment =:treatment, self_care =:self_care, investigations =:investigations "
			+ "where diseasesummaryID = :diseasesummaryID")
	public int updateDisease(@Param("diseaseName") String diseaseName, @Param("summary") String summary, @Param("couldbedangerous") String couldbedangerous
			,@Param("causes") String causes, @Param("dos_donts") String dos_donts,
			@Param("symptoms_Signs") String symptoms_Signs, @Param("medicaladvice") String medicaladvice,
			@Param("riskfactors") String riskfactors,@Param("treatment") String treatment,@Param("self_care") String self_care,
						@Param("investigations") String investigations, @Param("diseasesummaryID") Integer diseasesummaryID);
	
	@Query("Select disease.diseasesummaryID, disease.diseaseName from Disease disease where disease.deleted = false")
	public List<Objects[]> getAvailableDiseases();
	
	@Query("Select disease from Disease disease where disease.diseasesummaryID = :diseasesummaryID")
	public Disease getDiseasesByID(@Param("diseasesummaryID") Integer diseasesummaryID);
}
