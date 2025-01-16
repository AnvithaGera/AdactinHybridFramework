package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class BasePage extends BaseTest{
	
	public BasePage()
	{
		PageFactory.initElements(driver, this);
	}

	public void type(WebElement element, String text) {
		
		element.sendKeys(text);
		
		test.log(Status.INFO, "entered text "+text+" in webelement"+element);
	}

	public void click(WebElement element)
	{
		element.click();
		
		test.log(Status.INFO, "Clicked webelement"+element);
	}
	
	public String getTitle()
	{
		return driver.getTitle();	
	}
	
	public void verifyTitle(String expTitle)
	{
		Assert.assertEquals(getTitle(), expTitle);
		
		test.log(Status.PASS, "Both titles are matched");
	}
	
	public void verifyTextPresentAsValue(WebElement element,String expText)
	{
		Assert.assertEquals(element.getAttribute("value"), expText);
	}
}
