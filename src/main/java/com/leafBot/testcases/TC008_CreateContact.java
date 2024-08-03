package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class TC008_CreateContact extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValues() {
		testCaseName = "TC008_CreateContact";
		testDescription = "Create a new Contact on LeafTaps";
		authors = "Hari";
		category = "Smoke";
		dataSheetName = "TC008";
	}

	@Test(dataProvider="fetchData")
	public void createContact(String userName, String password, String comnyName, String firstName, String lastName, String eMail){

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
