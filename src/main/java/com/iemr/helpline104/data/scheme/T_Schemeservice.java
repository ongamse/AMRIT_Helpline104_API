package com.iemr.helpline104.data.scheme;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.helpline104.data.beneficiarycall.BenCall;
import com.iemr.helpline104.utils.mapper.OutputMapper;

@Entity
@Table(name="t_schemeservice")
public class T_Schemeservice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SchemeServiceID")
	private Long schemeServiceID;
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	@Column(name = "BenCallID")
	private Long benCallID;	
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "benCallID")
	private BenCall benCall;
	@Expose
	@Column(name = "SchemeID")
	private Integer schemeID;
	@Expose
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, insertable = false, name = "schemeID")
	private Scheme scheme;
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;	
	@Column(name = "Deleted",insertable = false, updatable = true)
	private Boolean deleted;
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable=false, updatable=false)
	private Date createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable=false, updatable=false)
	private Date lastModDate;
	
	public T_Schemeservice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getBeneficiaryRegID()
	{
		return beneficiaryRegID;
	}
	public Long getBenCallID()
	{
		return benCallID;
	}
	public void setBenCall(BenCall benCall)
	{
		this.benCall = benCall;
	}
	
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
		
}
