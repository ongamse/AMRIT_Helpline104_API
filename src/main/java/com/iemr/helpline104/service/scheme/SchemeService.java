package com.iemr.helpline104.service.scheme;

import java.util.List;

import com.iemr.helpline104.data.scheme.T_Schemeservice;

public interface SchemeService
{
	String saveSchemeSearchHistory(T_Schemeservice[] schemeHistory);
	List<T_Schemeservice> getSchemeSearchHistory(Long beneficiaryId, Long benCallID);
}
