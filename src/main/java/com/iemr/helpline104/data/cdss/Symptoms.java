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
@Table(name = "m_cdssdata")
public class Symptoms {

	@Id
	@Column(name = "SymptomId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int SymptomId;
	private String Symptom;
	
	private String Gender;
	private int AgeFrom;
	private int AgeTo;
	private String Data;
	
	
	public String getSymptom() {
		return Symptom;
	}
	public void setSymptom(String symptom) {
		Symptom = symptom;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getAgeFrom() {
		return AgeFrom;
	}
	public void setAgeFrom(int ageFrom) {
		AgeFrom = ageFrom;
	}
	public int getAgeTo() {
		return AgeTo;
	}
	public void setAgeTo(int ageTo) {
		AgeTo = ageTo;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	@Override
	public String toString() {
		return "Symptoms [SymptomId=" + SymptomId + ", Symptom=" + Symptom + ", Gender=" + Gender + ", AgeFrom="
				+ AgeFrom + ", AgeTo=" + AgeTo + ", Data=" + Data + "]";
	}
	public int getSymptomId() {
		return SymptomId;
	}
	public void setSymptomId(int symptomId) {
		SymptomId = symptomId;
	}

}
