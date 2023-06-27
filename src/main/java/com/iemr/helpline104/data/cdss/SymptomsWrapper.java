package com.iemr.helpline104.data.cdss;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class SymptomsWrapper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String symptomId;
	private String symptom;
	private String gender;
	private int age;

	protected SymptomsWrapper() {
	}

	public SymptomsWrapper(String symptomId, String symptom, String gender, int age) {
		super();
		this.symptomId = symptomId;
		this.symptom = symptom;
		this.gender = gender;
		this.age = age;
	}

	public String getSymptomId() {
		return symptomId;
	}

	public void setSymptomId(String symptomId) {
		this.symptomId = symptomId;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
