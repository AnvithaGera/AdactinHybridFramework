package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class MyTestNGListener extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test passed");
		String testname=result.getMethod().getMethodName();
		String pattern="yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
		String date=simpleDateFormat.format(new Date());
		date=date.replace(":", "-");
		System.out.println(date);
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+testname+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\screenshots\\"+testname+date+".png");
		test.log(Status.PASS, testname+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		System.out.println("Test failed");
		String testname=result.getMethod().getMethodName();
		
		String pattern="yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
		String date=simpleDateFormat.format(new Date());
		date=date.replace(":", "-");
		System.out.println(date);
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+testname+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\screenshots\\"+testname+date+".png");
		test.log(Status.FAIL, testname+" is failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Test started");
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	
}
