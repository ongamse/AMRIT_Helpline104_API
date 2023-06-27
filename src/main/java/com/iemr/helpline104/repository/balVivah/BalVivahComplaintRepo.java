package com.iemr.helpline104.repository.balVivah;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.balVivah.BalVivahComplaint;

@Repository
@RestResource(exported = false)
public interface BalVivahComplaintRepo extends CrudRepository<BalVivahComplaint, Long> {

	@Query("SELECT b.balVivaComplaintID, b.requestID, b.childName, b.childAge, b.marriageDate, b.childFatherName, b.createdBy, b.subjectOfComplaint, "
			+ "b.ComplaintDate, b.childState, s.stateName, b.childDistrict, d.districtName, b.childVillage, db.villageName, "
			+ "b.childGender, g.genderName " + "FROM BalVivahComplaint b " + "LEFT JOIN b.state s "
			+ "LEFT JOIN b.district d " + "LEFT JOIN b.districtBranchMapping db " + "LEFT JOIN b.gender g "

			+ "where b.beneficiaryRegID = :beneficiaryRegID ")

	public List<Object[]> findByBeneficiaryID(@Param("beneficiaryRegID") long beneficiaryRegID);

	@Query("SELECT b.balVivaComplaintID, b.requestID, b.childName, b.childAge, b.marriageDate, b.childFatherName, b.createdBy, b.subjectOfComplaint, "
			+ "b.ComplaintDate, b.childState, s.stateName, b.childDistrict, d.districtName, b.childVillage, db.villageName, "
			+ "b.childGender, g.genderName " + "FROM BalVivahComplaint b " + "LEFT JOIN b.state s "
			+ "LEFT JOIN b.district d " + "LEFT JOIN b.districtBranchMapping db " + "LEFT JOIN b.gender g "

			+ "where b.beneficiaryRegID IN :ids ")

	public List<Object[]> findByBeneficiaryRegIDs(@Param("ids") List<Long> ids);

	@Query("SELECT b.balVivaComplaintID, b.requestID, b.childName, b.childAge, b.marriageDate, b.childFatherName, b.createdBy, b.subjectOfComplaint, "
			+ "b.ComplaintDate, b.childState, s.stateName, b.childDistrict, d.districtName, b.childVillage, db.villageName, "
			+ "b.childGender, g.genderName " + "FROM BalVivahComplaint b " + "LEFT JOIN b.state s "
			+ "LEFT JOIN b.district d " + "LEFT JOIN b.districtBranchMapping db " + "LEFT JOIN b.gender g "

			+ "where b.balVivaComplaintID =:requestID ")

	public List<Object[]> findByRequestID(@Param("requestID") Long requestID);

	@Query(" SELECT t FROM BalVivahComplaint t WHERE t.requestID = :requestID ")
	public BalVivahComplaint searchByRequestID(@Param("requestID") String requestID);
}
