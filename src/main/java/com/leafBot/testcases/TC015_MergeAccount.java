package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.FindLeadPopPage;
import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class TC015_MergeAccount extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValues(){
		testCaseName = "TC015_MergeAccount";
		testDescription = "Merge two Accounts on LeafTaps";
		dataSheetName = "TC015";
		category = "Regression";
		authors = "Hari";		
	}

	@Test(dataProvider = "fetchData")
	public void mergeAccount(String uName, String pwd,String f_LeadName,String l_LeadName, String errorMsg) throws InterruptedException{
		String fromLeadId = 
			new LoginPage(driver, node)
				.enterUserName(uName)
				.enterPassword(pwd)
				.clickLogin()
				.clickCRMSFA()
				.clickLeadLink()
				.clickMergeLead()
				.clickFromLeadLookup()
				.enterFirstName( f_LeadName)
				.clickFindleadsButton()
				.getFirstResultingLead();
			new FindLeadPopPage(driver, node)
				.clickResultingLeads()
				.clickToLeadLookup()
				.enterFirstName( l_LeadName)
				.clickFindleadsButton()
				.clickResultingLeads()
				.clickMergeButton()
				.clickFindLead()
				.enterLeadId(fromLeadId)
				.clickFindleadsButton()
				.verifyErrorMsg(errorMsg);

	}


}
