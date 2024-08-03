package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.FindLeadPage;
import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class TC025_RemoveActivity extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setData() {
		testCaseName="TC025_RemoveActivity";
		testDescription="Remove Event and Task Activities - LeafTaps";
		dataSheetName="TC025";
		category="Sanity";
		authors="Hari";
	}

	@Test(dataProvider="fetchData")
	public void removeActivity(String userName, String password, String phoneNum,String errorMsg) throws InterruptedException{

		String firstResultingLead =
			new LoginPage(driver, node)
				.enterUserName(userName)
				.enterPassword(password)
				.clickLogin()
				.clickCRMSFA()
				.clickLeadLink()		
				.clickFindLead()
				.clickPhoneTab()
				.enterPhoneNumberField(phoneNum)
				.clickFindleadsButton()
				.getFirstResultingLead();
		
			new FindLeadPage(driver, node)
				.clickFirstResultingLead()
				.clickDeleteLeadLink()
				.clickFindLead()
				.enterLeadId(firstResultingLead)
				.clickFindleadsButton()
				.verifyErrorMsg(errorMsg);
	}

}
