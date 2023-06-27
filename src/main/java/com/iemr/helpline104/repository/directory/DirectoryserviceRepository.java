package com.iemr.helpline104.repository.directory;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.directory.Directoryservice;

@Repository
@RestResource(exported = false)
public interface DirectoryserviceRepository extends CrudRepository<Directoryservice, Long>
{

	/*
	 * @Query("select d.directoryServiceID, i.institutionName, s.instituteDirectoryName, b.instituteSubDirectoryName, st.stateID, st.stateName, dt.districtID, dt.districtName, db.districtBranchID, db.villageName from Directoryservice d left join d.institute i join d.instituteDirectory s join d.instituteSubDirectory b join i.state st join i.district dt join i.districtbranchmapping db where d.deleted=false and d.beneficiaryRegID = :BeneficiaryRegID"
	 * ) public List<Objects[]> getBenSearchHistory(@Param("BeneficiaryRegID") Long BeneficiaryRegID);
	 */

	@Query("select d.directoryServiceID, i.institutionName, i.address, s.instituteDirectoryName, b.instituteSubDirectoryName from Directoryservice d left join d.institute i join d.instituteDirectory s join d.instituteSubDirectory b where d.deleted=false and d.beneficiaryRegID = :BeneficiaryRegID")
	public List<Objects[]> getBenSearchHistory(@Param("BeneficiaryRegID") Long BeneficiaryRegID);

	@Query("select d.directoryServiceID, i.institutionName, i.address, s.instituteDirectoryName, b.instituteSubDirectoryName from Directoryservice d left join d.institute i join d.instituteDirectory s join d.instituteSubDirectory b where d.deleted=false and d.benCallID = :benCallID")
	public List<Objects[]> getBenSearchHistoryByBenCallID(@Param("benCallID") Long benCallID);

}
