package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class TC013_EditAccount extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setData() {
		testCaseName="TC013_EditAccount";
		testDescription="Edit excisting Account on LeafTaps";
		dataSheetName="TC013";
		category="Sanity";
		authors="Hari";
	}

	@Test(dataProvider="fetchData")
	public void editAccount(String userName, String password , String f_Name, String updcompanyName) throws InterruptedException{

		new LoginPage(driver, node)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()		
		.clickCRMSFA()		
		.clickLeadLink()		
		.clickFindLead()
		.enterFirstName(f_Name)
		.clickFindleadsButton()
		.clickFirstResultingLead()
		.clickEditLeadLink()
		.updateCompanyName(updcompanyName)
		.clickUpdateSubmit()
		.verifyCompanyName(updcompanyName);
		
	}

}
