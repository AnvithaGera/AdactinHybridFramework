package testscripts.regression;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class ValidateLoginUsingHybrid extends BaseTest{
	
		@Test(dataProvider= "getTestData")
		
		public void loginTest(HashMap<String, String> testDataMap)
		{
			ApplicationKeywords app=new ApplicationKeywords();
			
			app.startBrowser();
			
			app.launchApp();
			
			app.type("username_textbox", testDataMap.get("username"));
			
			app.type("password_textbox", testDataMap.get("password"));
			
			app.click("login_button");
			
			app.verifyTitle(testDataMap.get("expected Title"));
		}
		
		@DataProvider
		public Object[][] getTestData()
		{
			Object[][] data=new Object[1][1];
			
			data [0][0]=UtilKit.getTestDataFromExcel("TC- 101");
			
			return data;
			
		}

}
