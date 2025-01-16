package testscripts.regression;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class ValidateLoginUsingPOMDataProviderExcel extends BaseTest {
	
	@Test(dataProvider="getTestData")
	public void validateLoginTest(HashMap<String, String> testDataMap)
	{
		LoginPage loginPage=new LoginPage();
		
		 loginPage.usernameTextbox(testDataMap.get("username"));
		 
		 loginPage.passwordTextbox(testDataMap.get("password"));
		 
		 loginPage.loginButton();
		 
		 SearchHotelPage searchHotelPage=new SearchHotelPage();
		 
		 searchHotelPage.verifyTitle(testDataMap.get("expected Title"));
		 
		 searchHotelPage.helloUsernameText(testDataMap.get("username"));
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data=new Object[1][1];
		data[0][0]=UtilKit.getTestDataFromExcel("TC- 101");
		return data;
		
	}

}
