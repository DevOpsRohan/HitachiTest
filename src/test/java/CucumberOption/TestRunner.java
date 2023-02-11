package CucumberOption;



//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(CucumberOptions.class)
@CucumberOptions(
		features="src/test/java/feature",
		glue= {"StepDef"},
		monochrome = true,tags = "",
		plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	

}
