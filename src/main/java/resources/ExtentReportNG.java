package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports extent;
	public static ExtentReports getReport()
	{
		
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(path);
		
		esr.config().setReportName("web automaton");
		esr.config().setDocumentTitle("test report");
		
		//main class
		extent=new ExtentReports();
		extent.attachReporter(esr);
		extent.setSystemInfo("tester", "ravi");
		return extent;
		
	}
	

}
