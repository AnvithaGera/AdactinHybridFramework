package testscripts.regression;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import utils.UtilKit;

public class ValidateLoginUsingDataProviderExcel extends BaseTest {

	@Test(dataProvider="getTestData")
	public void validateLoginTest(HashMap<String, String>testDataMap)
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(testDataMap.get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(testDataMap.get("password"));
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Assert.assertEquals(driver.getTitle(), testDataMap.get("expected Title"));
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC- 101");
	
		return data;
		
	}
	
	
}
