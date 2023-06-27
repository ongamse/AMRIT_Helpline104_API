package com.iemr.helpline104.data.hihl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_104relationship")
public class M_104relationship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int relationShipId;
	@Column(name = "Name")
	private String relationShipName;
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
}
