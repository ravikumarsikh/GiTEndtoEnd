package EndtoEndProject;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;
import resources.base;

public class Listeners extends base implements ITestListener{

	ExtentReports	extent = ExtentReportNG.getReport();
	ExtentTest test;
	//this is thread safe which can be used to execute parallel without fail
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal();
	@Override
	public void onTestStart(ITestResult result) {
		
		  test=extent.createTest(result.getMethod().getMethodName());
		
		  extenttest.set(test);
	
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extenttest.get().log(Status.PASS, "test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		extenttest.get().fail(result.getThrowable());
		WebDriver driver=null;
		// TODO Auto-generated method stub
	String methodname = result.getMethod().getMethodName();
	try {
		
		driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		screenshot(methodname, driver);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
	
	
	}
	try {
		extenttest.get().addScreenCaptureFromPath(screenshot(methodname,driver), result.getMethod().getMethodName());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	

}
