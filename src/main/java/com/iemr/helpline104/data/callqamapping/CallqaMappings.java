package com.iemr.helpline104.data.callqamapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.google.gson.Gson;
import com.iemr.helpline104.data.organDonation.T_OrganDonation;

@Entity
public class CallqaMappings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mappingId;
	
	@Transient
	private List<M_104callqamapping> m_104callqamapping;

	public List<M_104callqamapping> getM_104callqamapping() {
		return m_104callqamapping;
	}

	public void setM_104callqamapping(List<M_104callqamapping> m_104callqamapping) {
		this.m_104callqamapping = m_104callqamapping;
	}

	public Long getMappingId() {
		return mappingId;
	}
	
	public String toString() {
		return new Gson().toJson(this);
	}
}
