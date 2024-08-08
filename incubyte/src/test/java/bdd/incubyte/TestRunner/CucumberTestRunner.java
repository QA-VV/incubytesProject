package bdd.incubyte.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	
	features = {"src/test/resources/Features"},
	glue = {"bdd.incubyte"},
	dryRun = false,
	plugin = {"pretty","html:target/htmlreport.html"},
	tags = "@Login"
	
	)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}




