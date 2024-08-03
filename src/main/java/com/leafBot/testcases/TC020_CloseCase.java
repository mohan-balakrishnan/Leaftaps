package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.FindLeadPage;
import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class TC020_CloseCase extends ProjectSpecificMethods{

	@BeforeTest
	public void setData() {
		testCaseName="TC020_CloseCase";
		testDescription="Close the Case - LeafTaps";
		dataSheetName="TC020";
		category="Sanity";
		authors="Hari";
	}

	@Test(dataProvider="fetchData")
	public void closeCase(String userName, String password, String phoneNum,String errorMsg) throws InterruptedException{

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
