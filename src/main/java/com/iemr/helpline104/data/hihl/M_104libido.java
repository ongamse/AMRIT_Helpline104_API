package com.iemr.helpline104.data.hihl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_104libido")
public class M_104libido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int libidoId;
	@Column(name = "Name")
	private String libidoName;
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
}
