package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
//if we running for junit then un comment below one
@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/features",
glue="stepDefinations")


// we need to extend AbstractTestNGCucumberTests for testng
public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	

}
