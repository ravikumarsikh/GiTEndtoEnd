package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	
	
	
	
	
	
		public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
			
			this.driver= driver;
	}



		private By signin = By.xpath("//a[contains(@href,'sign_in')]");
		private By fea = By.xpath("//h2[contains(text(),'Featured Courses')]");
		private By nav = By.cssSelector(".nav-outer.clearfix");
		
		public WebElement nav()

		{
			return driver.findElement(nav);
		}
		
		public LoginPage getLogin()
		{
			driver.findElement(signin).click();
			
			
			LoginPage l = new LoginPage(driver);
			return l;
		}
		
		public WebElement featured()
		{
			return driver.findElement(fea);
		}

}
