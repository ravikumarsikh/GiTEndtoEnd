package EndtoEndProject;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import jdk.internal.org.jline.utils.Log;
import resources.base;

public class NavBar extends base {
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver driver;//to run in parallel mode we are declaring here.
	@BeforeTest
	public void inti() throws IOException
	{
driver = initializedriver();
		
		
driver.get(prop.getProperty("url"));
log.info("navigation bar checking");

	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	
	
	@Test
	public void navigationBar() throws IOException
	{
		
		
	
		LandingPage lp = new LandingPage(driver);
		
		Assert.assertTrue(lp.nav().isDisplayed());
		
		
	}

}
