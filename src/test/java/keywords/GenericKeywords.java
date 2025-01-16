package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class GenericKeywords extends BaseTest {
	
	public void startBrowser()
	{
        String browserName=configProp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
	}	
		public void launchApp()
		{
			driver.get(configProp.getProperty("url"));
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));
		}
		
		public void type(String locatorKey, String text)
		{
		    getElement(locatorKey).sendKeys(text);
		}
		
		public void click(String locatorKey)
		{
			getElement(locatorKey).click();
		}
		
		public void selectItemFromDropdown(String locatorKey,String option)
		{
			new Select(getElement(locatorKey)).selectByVisibleText(option);
		}
		
		private WebElement getElement(String locatorKey) {
			
			WebElement element=null;
			
			WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(30));
			
			myWait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			
			element=driver.findElement(getLocator(locatorKey));
			
			return element;
				
		}
		
		public By getLocator(String locatorKey)
		{
			By by=null;
			
			if(locatorKey.endsWith("_id"))
			{
				by=By.id(locatorProp.getProperty(locatorKey));
			}
			
			else if(locatorKey.endsWith("_name"))
			{
				by=By.name(locatorProp.getProperty(locatorKey));
			}
			
			else if(locatorKey.endsWith("_xpath"))
			{
				by=By.xpath(locatorProp.getProperty(locatorKey));
			}
			
			else
			{
				by=By.xpath(locatorProp.getProperty(locatorKey));
			}
			return by;
			
		}
		
		public String getTitle()
		{
			return driver.getTitle();
			
		}
	}
		
	  