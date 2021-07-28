package EndtoEndProject;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import jdk.internal.org.jline.utils.Log;
import resources.base;

public class HomePage extends base{
	
	public static Logger Log=LogManager.getLogger(base.class.getName());
	
	
	public WebDriver driver;//to run in parallel mode we are declaring here.
	
	@BeforeTest
	public void inti() throws IOException
	{
driver = initializedriver();
//commenting for adding git commends

		
		
		//driver.get(prop.getProperty("url"));
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String pwd) throws IOException
	
	{
		
		
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		LoginPage l=lp.getLogin();
		
		l.username().sendKeys(username);
		l.pwd().sendKeys(pwd);
		l.Login().click();
		Log.info("login is clicked");
		
		
	
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		// roe stands for how many datatypes needs to test nothig but how many test
		// coumn stands for how many values for each test
		Object[][] mul = new Object[2][2];
		
		mul[0][0]="username1";
		mul[0][1]="password1";
				
		mul[1][0]="username2";
		mul[1][1]="password2";
		

		
		return mul;
		
	}
		
		
	
	

}
