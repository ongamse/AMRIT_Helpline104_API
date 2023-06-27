package com.iemr.helpline104.repository.foodSafetyCopmlaint;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.foodSafetyCopmlaint.T_FoodSafetyCopmlaint;

@Repository
@RestResource(exported = false)
public interface FoodSafetyCopmlaintRepository extends CrudRepository<T_FoodSafetyCopmlaint, Long> {

	@Query("select f.fSComplaintID, f.requestID, f.beneficiaryRegID, f.typeOfRequest, f.isDiarrhea, f.isVomiting, f.isAbdominalPain, f.isChillsOrRigors, f.isGiddiness, f.isDehydration, "
			+ "f.isRashes, f.fromWhen, f.historyOfDiet, f.isFoodConsumed, f.typeOfFood, f.foodConsumedFrom, f.associatedSymptoms, t.feedbackTypeID, t.feedbackTypeName, "
			+ " f.remarks, f.createdDate, f.isSelf, f.districtID, d.districtName, f.districtBlockID, db.blockName, f.villageID, dbm.villageName "
			+ "from T_FoodSafetyCopmlaint f " + " LEFT JOIN f.m_feedbackType t" + " LEFT JOIN f.district d"
			+ " LEFT JOIN f.districtBlock db" + " LEFT JOIN f.districtBranchMapping dbm"
			+ " where  f.deleted=false and  f.beneficiaryRegID=:beneficiaryRegID order by f.fSComplaintID desc")
	public List<Objects[]> getFoodSafetyRequests(@Param("beneficiaryRegID") Long beneficiaryRegID) throws Exception;

	@Query("select f.fSComplaintID, f.requestID, f.beneficiaryRegID, f.typeOfRequest, f.isDiarrhea, f.isVomiting, f.isAbdominalPain, f.isChillsOrRigors, f.isGiddiness, f.isDehydration, "
			+ "f.isRashes, f.fromWhen, f.historyOfDiet, f.isFoodConsumed, f.typeOfFood, f.foodConsumedFrom, f.associatedSymptoms, t.feedbackTypeID, t.feedbackTypeName, "
			+ " f.remarks, f.createdDate, f.isSelf, f.districtID, d.districtName, f.districtBlockID, db.blockName, f.villageID, dbm.villageName "
			+ "from T_FoodSafetyCopmlaint f " + " LEFT JOIN f.m_feedbackType t" + " LEFT JOIN f.district d"
			+ " LEFT JOIN f.districtBlock db" + " LEFT JOIN f.districtBranchMapping dbm"
			+ " where  f.deleted=false and  f.benCallID=:benCallID order by f.fSComplaintID desc")
	public List<Objects[]> getFoodSafetyRequestsByBenCallID(@Param("benCallID") Long benCallID) throws Exception;

	@Query("select f.fSComplaintID, f.requestID, f.beneficiaryRegID, f.typeOfRequest, f.isDiarrhea, f.isVomiting, f.isAbdominalPain, f.isChillsOrRigors, f.isGiddiness, f.isDehydration, "
			+ "f.isRashes, f.fromWhen, f.historyOfDiet, f.isFoodConsumed, f.typeOfFood, f.foodConsumedFrom, f.associatedSymptoms, t.feedbackTypeID, t.feedbackTypeName, "
			+ " f.remarks, f.createdDate, f.isSelf, f.districtID, d.districtName, f.districtBlockID, db.blockName, f.villageID, dbm.villageName "
			+ "from T_FoodSafetyCopmlaint f " + " LEFT JOIN f.m_feedbackType t" + " LEFT JOIN f.district d"
			+ " LEFT JOIN f.districtBlock db" + " LEFT JOIN f.districtBranchMapping dbm"
			+ " where  f.deleted=false and  f.requestID=:requestID order by f.fSComplaintID desc")
	public List<Objects[]> getFoodSafetyRequestsByRequestID(@Param("requestID") String requestID) throws Exception;

	@Query("select f.fSComplaintID, f.requestID, f.beneficiaryRegID, f.typeOfRequest, f.isDiarrhea, f.isVomiting, f.isAbdominalPain, f.isChillsOrRigors, f.isGiddiness, f.isDehydration, "
			+ "f.isRashes, f.fromWhen, f.historyOfDiet, f.isFoodConsumed, f.typeOfFood, f.foodConsumedFrom, f.associatedSymptoms, t.feedbackTypeID, t.feedbackTypeName, "
			+ " f.remarks, f.createdDate, f.isSelf, f.districtID, d.districtName, f.districtBlockID, db.blockName, f.villageID, dbm.villageName "
			+ "from T_FoodSafetyCopmlaint f " + " LEFT JOIN f.m_feedbackType t" + " LEFT JOIN f.district d"
			+ " LEFT JOIN f.districtBlock db" + " LEFT JOIN f.districtBranchMapping dbm"
			+ " where  f.deleted=false and  f.fSComplaintID=:fSComplaintID ")
	public List<Objects[]> getFoodSafetyRequestsByRequestIDNew(@Param("fSComplaintID") Long fSComplaintID)
			throws Exception;

	@Query(value = "SELECT im.BenRegId FROM "
			+ " db_identity.i_beneficiarycontacts ic INNER JOIN db_identity.i_beneficiarymapping im "
			+ " ON ic.VanSerialNo = im.BenContactsId AND ic.VanID = im.VanID "
			+ " WHERE ic.PreferredPhoneNum = :phoneNum", nativeQuery = true)
	public ArrayList<BigInteger> findByPhoneNum(@Param("phoneNum") String phoneNum);

	@Query("select f.fSComplaintID, f.requestID, f.beneficiaryRegID, f.typeOfRequest, f.isDiarrhea, f.isVomiting, f.isAbdominalPain, f.isChillsOrRigors, f.isGiddiness, f.isDehydration, "
			+ "f.isRashes, f.fromWhen, f.historyOfDiet, f.isFoodConsumed, f.typeOfFood, f.foodConsumedFrom, f.associatedSymptoms, t.feedbackTypeID, t.feedbackTypeName, "
			+ " f.remarks, f.createdDate, f.isSelf, f.districtID, d.districtName, f.districtBlockID, db.blockName, f.villageID, dbm.villageName "
			+ "from T_FoodSafetyCopmlaint f " + " LEFT JOIN f.m_feedbackType t" + " LEFT JOIN f.district d"
			+ " LEFT JOIN f.districtBlock db" + " LEFT JOIN f.districtBranchMapping dbm"
			+ " where  f.deleted=false and  f.beneficiaryRegID IN :ids ")
	public List<Objects[]> findByBenRegIDs(@Param("ids") List<Long> ids);

	// shubham 29-02-2020
//	@Query("select f.fSComplaintID, f.requestID, f.beneficiaryRegID, f.typeOfRequest, f.isDiarrhea, f.isVomiting, f.isAbdominalPain, f.isChillsOrRigors, f.isGiddiness, f.isDehydration, "
//			+ "f.isRashes, f.fromWhen, f.historyOfDiet, f.isFoodConsumed, f.typeOfFood, f.foodConsumedFrom, f.associatedSymptoms, t.feedbackTypeID, t.feedbackTypeName, "
//			+ " f.remarks, f.createdDate, f.isSelf, f.districtID, d.districtName, f.districtBlockID, db.blockName, f.villageID, dbm.villageName "
//			+ "from T_FoodSafetyCopmlaint f "
//			+ " LEFT JOIN f.m_feedbackType t"
//			+ " LEFT JOIN f.district d"
//			+ " LEFT JOIN f.districtBlock db"
//			+ " LEFT JOIN f.districtBranchMapping dbm"
//			+ " LEFT JOIN BeneficiaryMapping ben ON f.beneficiaryRegID=ben.benRegID "
//			+ "LEFT JOIN BenContactMapping bc ON bc.benContactsID=ben.benContactsId "
//			+ " where f.deleted=false and bc.preferredPhoneNum = :mobileNumber order by f.fSComplaintID desc")
//	public List<Objects[]> getFoodSafetyComplaintsListByMobile(@Param("mobileNumber") String mobileNumber
//			)
//			throws Exception;

//	@Query("select f.fSComplaintID, f.requestID, f.beneficiaryRegID, f.typeOfRequest, f.isDiarrhea, f.isVomiting, f.isAbdominalPain, f.isChillsOrRigors, f.isGiddiness, f.isDehydration, "
//			+ "f.isRashes, f.fromWhen, f.historyOfDiet, f.isFoodConsumed, f.typeOfFood, f.foodConsumedFrom, f.associatedSymptoms, t.feedbackTypeID, t.feedbackTypeName, "
//			+ " f.remarks, f.createdDate, f.isSelf, f.districtID, d.districtName, f.districtBlockID, db.blockName, f.villageID, dbm.villageName "
//			+ "from T_FoodSafetyCopmlaint f "
//			+ " LEFT JOIN f.m_feedbackType t" 
//			+ " LEFT JOIN f.district d"
//			+ " LEFT JOIN f.districtBlock db"
//			+ " LEFT JOIN f.districtBranchMapping dbm"
//			+ " where  f.deleted=false and  f.fSComplaintID= :ID order by f.fSComplaintID desc")
//	public List<Objects[]> getFoodSafetyComplaintsListByGrievanceID(@Param("ID") Long ID
//			)
//			throws Exception;

}
