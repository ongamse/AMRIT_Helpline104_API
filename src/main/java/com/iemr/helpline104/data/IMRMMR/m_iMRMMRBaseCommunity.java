package com.iemr.helpline104.data.IMRMMR;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_imrmmrbasecommunity")
public class m_iMRMMRBaseCommunity {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imrmmrcommunityID ")
	private Integer imrmmrCommunityID;

	@Expose
	@Column(name = "CommunityType")
	private String communityType;

	public m_iMRMMRBaseCommunity(Integer imrmmrCommunityID, String communityType) {
	    this.imrmmrCommunityID = imrmmrCommunityID;
	    this.communityType = communityType;
	}
}
