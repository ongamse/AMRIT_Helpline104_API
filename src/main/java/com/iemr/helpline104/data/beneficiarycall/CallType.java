package com.iemr.helpline104.data.beneficiarycall;

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
@Table(name = "m_calltype")
public class CallType
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "CallTypeID")
	private Integer callTypeID;	
	@Expose
	@Column(name = "CallGroupType")
	private String callGroupType;
	@Expose
	@Column(name = "CallType")
	private String callType;
	
	@Column(name = "Deleted", insertable = false, updatable = true)	
	private Boolean deleted;		

	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	public String getCallGroupType()
	{
		return callGroupType;
	}

	public String getCallType()
	{
		return callType;
	}
}
