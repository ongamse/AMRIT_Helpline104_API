package com.iemr.helpline104.repository.organDonation;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.organDonation.T_OrganDonation;

@Repository
@RestResource(exported = false)
public interface OrganDonationRepository extends CrudRepository<T_OrganDonation, Long>{
	
	@Query("select o.organDonationID, o.requestID, o.beneficiaryRegID, o.donarName, o.donarAge, o.donarGenderID, g.genderName, dt.donationTypeID, dt.donationType, dt.donationTypeDesc, do.donatableOrganID,"
			+ " do.donatableOrgan, do.donatableOrganDesc, o.acceptorHospitalID, o.remarks "
			+ "from T_OrganDonation o "
			+ " LEFT JOIN o.m_donationType dt "
			+ " LEFT JOIN o.m_donatableOrgan do "
			+ " LEFT JOIN o.m_gender g "
			+ " where o.deleted=false and o.beneficiaryRegID=:beneficiaryRegID order by o.organDonationID desc")
	public List<Objects[]> getOrganDonationRequests(@Param("beneficiaryRegID") Long beneficiaryRegID) throws Exception;
	
	@Query("select o.organDonationID, o.requestID, o.beneficiaryRegID, o.donarName, o.donarAge, o.donarGenderID, g.genderName, dt.donationTypeID, dt.donationType, dt.donationTypeDesc, do.donatableOrganID,"
			+ " do.donatableOrgan, do.donatableOrganDesc, o.acceptorHospitalID, o.remarks "
			+ "from T_OrganDonation o "
			+ " LEFT JOIN o.m_donationType dt "
			+ " LEFT JOIN o.m_donatableOrgan do "
			+ " LEFT JOIN o.m_gender g " 
			+ " where o.deleted=false and o.benCallID=:benCallID order by o.organDonationID desc")
	public List<Objects[]> getOrganDonationRequestsByBenCallID(@Param("benCallID") Long benCallID) throws Exception;
	
	@Query("select o.organDonationID, o.requestID, o.beneficiaryRegID, o.donarName, o.donarAge, o.donarGenderID, g.genderName, dt.donationTypeID, dt.donationType, dt.donationTypeDesc, do.donatableOrganID,"
			+ " do.donatableOrgan, do.donatableOrganDesc, o.acceptorHospitalID, o.remarks "
			+ "from T_OrganDonation o "
			+ " LEFT JOIN o.m_donationType dt "
			+ " LEFT JOIN o.m_donatableOrgan do "
			+ " LEFT JOIN o.m_gender g " 
			+ " where o.deleted=false and o.requestID=:requestID order by o.organDonationID desc")
	public List<Objects[]> getOrganDonationRequestsByRequestID(@Param("requestID") String requestID) throws Exception;
	
	@Query("select donationTypeID, donationType, donationTypeDesc from M_DonationType where deleted=false")
	public List<Objects[]> getDonationTypes() throws Exception;


	@Query("select donatableOrganID, donatableOrgan, donatableOrganDesc from M_DonatableOrgan where deleted=false")
	public List<Objects[]> getDonatableOrgans() throws Exception;
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE T_OrganDonation u set u.donationTypeID =:donationTypeID, u.donatableOrganID =:donatableOrganID, u.remarks =:remarks where u.organDonationID =:organDonationID")
	public int updateOrganDonationDetails(@Param("organDonationID") Long organDonationID,
			@Param("donationTypeID") Integer donationTypeID, @Param("donatableOrganID") Integer donatableOrganID,
			@Param("remarks")String remarks);
	
}
