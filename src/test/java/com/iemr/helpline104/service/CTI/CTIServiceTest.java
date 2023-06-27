package com.iemr.helpline104.service.CTI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CTIServiceTest {

	@InjectMocks
	CTIService cTIService;

	@Test
	public void loginAgentTest()
	{
		try {
			//cTIService.loginAgent("agentID");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void logoutAgentTest()
	{
		try {
			//cTIService.logoutAgent("agent");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void transferCallTest()
	{
		try {
			//cTIService.transferCall("MO", "CO");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
