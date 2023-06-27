package com.iemr.helpline104.reposotory.IMRMMR;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import com.iemr.helpline104.data.IMRMMR.IMRMMR;

@Repository
@RestResource(exported = false)
public interface IMRMMRRepository extends CrudRepository<IMRMMR, Integer> {
	// TODO Auto-generated constructor stub
	
	@Query("SELECT s.supportServiceID, s.supportServiceName FROM M_supportServices s")
	public ArrayList<Objects[]> findsupportServices();
	
	@Query("SELECT f.facilityID, f.facilityName FROM M_facilities f")
	public ArrayList<Objects[]> findfacilities();
	
	@Query("SELECT imrmmrCommunityID, communityType FROM m_iMRMMRBaseCommunity ")
	public ArrayList<Objects[]> findBaseCommunities();
	
	@Query("SELECT imrmmrHealthWorkerID, healthWorkerType FROM m_iMRMMRHealthworker ")
	public ArrayList<Objects[]> findHealthWorker();
	
	@Query("SELECT imrmmrTransitID, transitType FROM m_iMRMMRTransitType ")
	public ArrayList<Objects[]> findTransitType();

	@Query("SELECT i.benImrMmrID, i.benCallID, i.beneficiaryRegID, i.within42daysOfDelivery, i.duringDelivery, i.duringPregnancy, "
			+ "i.transitType, i.facilityID, i.facilityName, i.noofDelivery, i.reasonOfDeath, i.referenceDate, i.relationshipType, "
			+ "i.relativeMobileNumber, i.supportServicesID_db, i.supportServicesName_db, i.TypeOfDelivery, i.typeOfInfromation, "
			+ "i.userID, i.victimAge, i.victimDistrict, i.victimName, i.victimTaluk, i.victimVillage, i.requestID, "
			+ "i.selectedCategory, i.informerName, i.informerMobileNumber, i.informerDistrictid, i.informerTalukid, "
			+ "i.informerVillageid, i.informerAddress, i.identityType, i.informerIdNo,  i.victimAddress, i.informerCategory, "
			+ "i.baseCommunity, i.deathConfirmed, i.above42daysOfDelivery, i.victimGuardian, i.transitTypeID, i.baseCommunityID, d.districtName "
			+ "FROM IMRMMR i LEFT JOIN i.victimDistrictName d "
			//+ "LEFT JOIN b.state s "
			//+ "LEFT JOIN b.district d " + "LEFT JOIN b.districtBranchMapping db " + "LEFT JOIN b.gender g "
			+ "WHERE i.beneficiaryRegID = :beneficiaryRegID")
	public List<Object[]> findByBeneficiaryID(@Param("beneficiaryRegID") Integer beneficiaryRegID);

	@Query("SELECT i.benImrMmrID, i.benCallID, i.beneficiaryRegID, i.within42daysOfDelivery, i.duringDelivery, i.duringPregnancy, "
			+ "i.transitType, i.facilityID, i.facilityName, i.noofDelivery, i.reasonOfDeath, i.referenceDate, i.relationshipType, "
			+ "i.relativeMobileNumber, i.supportServicesID_db, i.supportServicesName_db, i.TypeOfDelivery, i.typeOfInfromation, "
			+ "i.userID, i.victimAge, i.victimDistrict, i.victimName, i.victimTaluk, i.victimVillage, i.requestID, "
			+ "i.selectedCategory, i.informerName, i.informerMobileNumber, i.informerDistrictid, i.informerTalukid, "
			+ "i.informerVillageid, i.informerAddress, i.identityType, i.informerIdNo,  i.victimAddress, i.informerCategory, "
			+ "i.baseCommunity, i.deathConfirmed, i.above42daysOfDelivery, i.victimGuardian, i.transitTypeID, i.baseCommunityID, d.districtName "
			+ "FROM IMRMMR i LEFT JOIN i.victimDistrictName d "
			//+ "LEFT JOIN b.state s "
			//+ "LEFT JOIN b.district d " + "LEFT JOIN b.districtBranchMapping db " + "LEFT JOIN b.gender g "
			+ "WHERE i.beneficiaryRegID IN :ids")
	public List<Object[]> findByBeneficiaryRegIDs(@Param("ids") List<Integer> list1);

	@Query("SELECT i.benImrMmrID, i.benCallID, i.beneficiaryRegID, i.within42daysOfDelivery, i.duringDelivery, i.duringPregnancy, "
			+ "i.transitType, i.facilityID, i.facilityName, i.noofDelivery, i.reasonOfDeath, i.referenceDate, i.relationshipType, "
			+ "i.relativeMobileNumber, i.supportServicesID_db, i.supportServicesName_db, i.TypeOfDelivery, i.typeOfInfromation, "
			+ "i.userID, i.victimAge, i.victimDistrict, i.victimName, i.victimTaluk, i.victimVillage, i.requestID, "
			+ "i.selectedCategory, i.informerName, i.informerMobileNumber, i.informerDistrictid, i.informerTalukid, "
			+ "i.informerVillageid, i.informerAddress, i.identityType, i.informerIdNo,  i.victimAddress, i.informerCategory, "
			+ "i.baseCommunity, i.deathConfirmed, i.above42daysOfDelivery, i.victimGuardian, i.transitTypeID, i.baseCommunityID, d.districtName "
			+ "FROM IMRMMR i LEFT JOIN i.victimDistrictName d "
			//+ "LEFT JOIN b.state s "
			//+ "LEFT JOIN b.district d " + "LEFT JOIN b.districtBranchMapping db " + "LEFT JOIN b.gender g "
			+ "WHERE i.benImrMmrID = :requestID")
	public List<Object[]> findByRequestID(@Param("requestID") Long requestID);
	
	@Query(" SELECT t FROM IMRMMR t WHERE t.requestID = :requestID ")
    public IMRMMR searchByRequestID(@Param("requestID") String requestID);
	@Query(value = " SELECT SMSTypeID FROM db_iemr.m_smstype " + " WHERE SMSType = :smsType ", nativeQuery = true)
	public Integer getSMSTypeID(@Param("smsType") String smsType);
	
	@Query(value = " SELECT SMSTemplateID FROM db_iemr.m_smstemplate "
			+ " WHERE SMSTypeID = :smsTypeID ", nativeQuery = true)
	public Integer getSMSTemplateID(@Param("smsTypeID") Integer smsTypeID);
	
	@Query(value = "SELECT im.BenRegId FROM "
			+ " db_identity.i_beneficiarycontacts ic INNER JOIN db_identity.i_beneficiarymapping im "
			+ " ON ic.VanSerialNo = im.BenContactsId AND ic.VanID = im.VanID "
			+ " WHERE ic.PreferredPhoneNum = :phoneNum", nativeQuery = true)
	public ArrayList<BigInteger> findByPhoneNum(@Param("phoneNum") String phoneNum);
	
}
