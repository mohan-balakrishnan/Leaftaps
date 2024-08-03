package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class TC001_CreateOrder extends ProjectSpecificMethods{	

	@BeforeTest
	public void setData() {
		testCaseName="TC001_CreateOrder";
		testDescription="Create a new Order on LeafTaps";
		dataSheetName="TC001";
		category="Smoke";
		authors="Hari";
	}

	@Test(dataProvider="fetchData")
	public void createOrder(String userName, String password, String comnyName, String firstName, String lastName, String eMail){

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





