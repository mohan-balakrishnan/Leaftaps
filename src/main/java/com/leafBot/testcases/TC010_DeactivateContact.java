package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.FindLeadPage;
import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class TC010_DeactivateContact extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setData() {
		testCaseName="TC010_DeactivateContact";
		testDescription="Delete a Contact - LeafTaps";
		dataSheetName="TC010";
		category="Sanity";
		authors="Hari";
	}

	@Test(dataProvider="fetchData")
	public void deactivateContact(String userName, String password, String phoneNum,String errorMsg) throws InterruptedException{

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
