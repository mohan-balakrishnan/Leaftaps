package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class TC016_CreateOpportunity extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setData() {
		testCaseName="TC016_CreateOpportunity";
		testDescription="Create a new Opportunity on LeafTaps";
		dataSheetName="TC016";
		category="Smoke";
		authors="Hari";
	}

	@Test(dataProvider="fetchData")
	public void createOpportunity(String userName, String password, String comnyName, String firstName, String lastName, String eMail){

		new LoginPage(driver, node)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()		
		.clickCRMSFA()		
		.clickLeadLink()		
		.clickCreateLead()
		.enterCompanyName(comnyName)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterEmail(eMail)
		.clickCreateLeadSubmit()		
		.verifyFirstName(firstName);			
	}

}
