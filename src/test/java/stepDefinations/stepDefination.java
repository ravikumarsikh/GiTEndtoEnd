package stepDefinations;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import resources.base;

import org.junit.runner.RunWith;

import PageObjects.LandingPage;
import PageObjects.LoginPage;

@RunWith(Cucumber.class)
public class stepDefination extends base{

    @Given("^initialize with chrome$")
    public void initialize_with_chrome() throws Throwable {
        
        driver = initializedriver();
    }

   @When("^user enters the (.+) and (.+) and login$")
   public void user_enters_the_and_and_login(String username, String password) throws Throwable {
       
    	LandingPage lp = new LandingPage(driver);
		LoginPage l=lp.getLogin();
		
		l.username().sendKeys(username);
		l.pwd().sendKeys(password);
		l.Login().click();	
    	
    }

    /*@When("^user enters the (.+) and (.+) and login$")
    public void user_enters_the_and_and_login(String username, String password) throws Throwable {
     
    	LandingPage lp = new LandingPage(driver);
		LoginPage l=lp.getLogin();
		
		l.username().sendKeys(username);
		l.pwd().sendKeys(password);
		l.Login().click();
    	
    }*/

    
    @Then("^User succesfully logged in$")
    public void user_succesfully_logged_in() throws Throwable {
        
    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
        
    	driver.get(strArg1);
    	
    }

    @And("^click on loin link$")
    public void click_on_loin_link() throws Throwable {
     System.out.println("logged in succesffully");   
     
     
    }

}