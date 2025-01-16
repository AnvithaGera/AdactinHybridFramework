package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;

public class BaseTest {

	public static WebDriver driver;	
	public static FileInputStream fis1;
	public static Properties configProp;
	public static FileInputStream fis2;
	public static Properties locatorProp;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeTest
	public void fileReadSet()
	{
		try {
			fis1=new FileInputStream("src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		configProp=new Properties();
		try {
			configProp.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fis2=new FileInputStream("src\\test\\resources\\properties\\locators.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		locatorProp=new Properties();
		try {
			locatorProp.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reports=ExtentManager.getReports(); 
	}
	
	@BeforeMethod
	public void setUp(Method method)
	{	 
		test=reports.createTest(method.getName());
		
		String browserName=configProp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			test.log(Status.INFO, browserName+" is launched");		
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			test.log(Status.INFO, browserName+" is launched");
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			test.log(Status.INFO, browserName+" is launched");
		}
		
		driver.get(configProp.getProperty("url"));
		
		test.log(Status.INFO, "App launched using url "+configProp.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));
	}
	
	@AfterMethod
	public void tearDown()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
		test.log(Status.INFO, "Browser is closed");
	}
	
	@AfterTest
	public void flushReports()
	{
		reports.flush();
	}
}
