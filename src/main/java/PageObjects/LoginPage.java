package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	
	private By username = By.xpath("//input[@id='user_email']");
	
	private By pwd = By.xpath("//input[@id='user_password']");
	private By Login = By.cssSelector("input[value='Log In']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}




	public WebElement username()
	{
		return driver.findElement(username);
	}

	public WebElement pwd()
	{
		return driver.findElement(pwd);
	}
	
	public WebElement Login()
	{
		return driver.findElement(Login);
	}
	
	
}
