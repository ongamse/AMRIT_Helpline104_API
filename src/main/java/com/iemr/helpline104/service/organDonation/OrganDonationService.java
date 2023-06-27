package com.iemr.helpline104.service.organDonation;

import java.util.List;


import com.iemr.helpline104.data.organDonation.M_DonatableOrgan;
import com.iemr.helpline104.data.organDonation.M_DonationType;
import com.iemr.helpline104.data.organDonation.OrganDonations;
import com.iemr.helpline104.data.organDonation.T_OrganDonation;


public interface OrganDonationService {
	
	List<T_OrganDonation> getOrganDonationRequests(Long benificiaryRegID, Long benCallID, String requestID) throws Exception;
	
	public String save(OrganDonations organDonations) throws Exception;
	
	public String update(T_OrganDonation organDonation) throws Exception;
	
	public String saveInstituteDetails(T_OrganDonation organDonation) throws Exception;

	List<M_DonationType> getDonationTypes() throws Exception;
	
	List<M_DonatableOrgan> getDonatableOrgans() throws Exception;
}
