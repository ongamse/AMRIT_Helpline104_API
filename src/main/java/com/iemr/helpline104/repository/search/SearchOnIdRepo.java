package com.iemr.helpline104.repository.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.epidemicOutbreak.T_EpidemicOutbreak;


@Repository
@RestResource(exported = false)
public interface SearchOnIdRepo extends CrudRepository<T_EpidemicOutbreak, Long>{

	
	
	@Query("select e.outbreakComplaintID, e.requestID, e.beneficiaryRegID, e.natureOfComplaint, e.totalPeopleAffected, "
			+ "e.affectedDistrictID, d.districtName, e.affectedDistrictBlockID, b.blockName, "
			+ "e.affectedVillageID, dbm.villageName, "
			+ "e.remarks, e.createdDate from T_EpidemicOutbreak e " + "LEFT JOIN e.m_district d "
			+ "LEFT JOIN e.m_districtblock b "
			+ "LEFT JOIN e.districtBranchMapping dbm "
			+ "where e.deleted=false order by e.outbreakComplaintID desc")
	public List<Objects[]> getEpidemicOutbreakComplaints(@Param("grievanceId") String grievanceId,@Param("mobileNumber") String mobileNumber
			)
			throws Exception;

	

	

}
