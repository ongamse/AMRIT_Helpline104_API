package com.iemr.helpline104.data.beneficiarycall;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/* This class is created for populating data (Agent Id) in case sheet */

@Entity
@Table(name = "t_bencall")
public class BenCall
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BenCallID")	
	private Long benCallID;
	
	@Expose
	@Column(name = "ReceivedAgentID")
	private String receivedAgentID;
	
	@Expose
	@Column(name = "Remarks")
	private String remarks;
	
	@Column(name = "CallTypeID")
	@Expose
	private Integer callTypeID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CallTypeID", insertable = false, updatable = false)
	private CallType callTypeObj;

}
