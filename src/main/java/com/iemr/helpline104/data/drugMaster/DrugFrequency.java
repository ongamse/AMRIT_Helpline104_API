package com.iemr.helpline104.data.drugMaster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.helpline104.utils.mapper.OutputMapper;

@Entity
@Table(name="m_drugfrequency")
public class DrugFrequency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "drugFrequencyID")
	private Integer drugFrequencyID;
	
	@Expose
	@Column(name = "Frequency")
	private String frequency;	
	
	@Column(name = "Deleted",insertable = false, updatable = true)
	private Boolean deleted; 
	
	public DrugFrequency() {
		super();
		
	}
	
	public DrugFrequency(Integer frequencyID, String frequency) {
		super();
		this.drugFrequencyID = frequencyID;
		this.frequency = frequency;
	}
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

}
