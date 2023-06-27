package com.iemr.helpline104.data.beneficiary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class M_Promoservice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pamphlet;
	private String radio;
	private String television;
	private String familyFriends;
	private String healthcareWorker;
	private String others;
	private String notDisclosed;

	public M_Promoservice() {
	}

	public M_Promoservice(String pamphlet, String radio, String television, String familyFriends,
			String healthcareWorker, String others, String notDisclosed) {
		this.pamphlet = pamphlet;
		this.radio = radio;
		this.television = television;
		this.familyFriends = familyFriends;
		this.healthcareWorker = healthcareWorker;
		this.others = others;
		this.notDisclosed = notDisclosed;
	}

	public Long getId() {
		return this.id;
	}

	public String getPamphlet() {
		return this.pamphlet;
	}

	public void setPamphlet(String pamphlet) {
		this.pamphlet = pamphlet;
	}

	public String getRadio() {
		return this.radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getTelevision() {
		return this.television;
	}

	public void setTelevision(String television) {
		this.television = television;
	}

	public String getFamilyFriends() {
		return this.familyFriends;
	}

	public void setFamilyFriends(String familyFriends) {
		this.familyFriends = familyFriends;
	}

	public String getHealthcareWorker() {
		return this.healthcareWorker;
	}

	public void setHealthcareWorker(String healthcareWorker) {
		this.healthcareWorker = healthcareWorker;
	}

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getNotDisclosed() {
		return this.notDisclosed;
	}

	public void setNotDisclosed(String notDisclosed) {
		this.notDisclosed = notDisclosed;
	}
}
