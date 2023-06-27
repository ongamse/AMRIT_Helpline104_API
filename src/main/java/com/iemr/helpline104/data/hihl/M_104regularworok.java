package com.iemr.helpline104.data.hihl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_104regularworok")
public class M_104regularworok {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int regularWorkId;
	@Column(name = "Name")
	private String regularWorkName;
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
}
