package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class TC019_EditCase extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		testCaseName="TC019_EditCase";
		testDescription="Edit excisting Case on LeafTaps";
		dataSheetName="TC019";
		category="Sanity";
		authors="Hari";
	}

	@Test(dataProvider="fetchData")
	public void editCase(String userName, String password , String f_Name, String updcompanyName) throws InterruptedException{

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
