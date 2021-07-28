package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class base {

	public WebDriver driver;
	public String url;
	public Properties prop;
	
	public WebDriver initializedriver() throws IOException
	{
		
		prop = new Properties();
		String path = System.getProperty("user.dir");
		
		FileInputStream fis = new FileInputStream(path+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//mvn test -Dbrowser=chrome
		//to read from maven we need to use system.getproperty
		//String browserName = System.getProperty("browser");
		String browserName=prop.getProperty("browser");
		
		
		if(browserName.contains("chrome"))
			
		{
			
			
			System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			
			if(browserName.contains("headless"))
			{
			//co.setHeadless(true); you can define this way ot below
			co.addArguments("--headless");
			
			}
			driver=new ChromeDriver(co);
			
			
		}
		
			
			
			
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rsikhako\\Desktop\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	
	public String screenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
	/*public String screenshot(String name,WebDriver dirver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+name+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	
	}
	*/
	
		
}
