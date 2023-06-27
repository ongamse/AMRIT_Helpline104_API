package com.iemr.helpline104.data.organDonation;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class OrganDonations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long organDonationID;
	
	@Transient
	private List<T_OrganDonation> t_organDonations;

	public List<T_OrganDonation> getT_organDonations() {
		return t_organDonations;
	}

	public void setT_organDonations(List<T_OrganDonation> t_organDonations) {
		this.t_organDonations = t_organDonations;
	}
}
