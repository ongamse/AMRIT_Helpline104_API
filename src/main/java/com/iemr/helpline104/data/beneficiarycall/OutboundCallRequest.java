package com.iemr.helpline104.data.beneficiarycall;

import java.sql.Timestamp;
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
@Table(name = "t_outboundcallrequest")
public class OutboundCallRequest
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OutboundCallReqID")
	@Expose
	private Long outboundCallReqID;
	
	@Expose
	@Column(name = "PrefferedDateTime")
	private Timestamp prefferedDateTime;
	
	@Expose
	@Column(name = "BenCallID")	
	private Long benCallID;	
	

	@Transient
	OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	
}
