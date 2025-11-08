package runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//give feature file path
		features = {
				"D:\\new eclipse\\31StMayCoverFoxTest\\src\\test\\resources\\coverFoxFeatures\\CoverFoxHealthInsurance.feature"}
				, glue = { "stepDefinitions",
				"hooks" }, 
				plugin = {"pretty","html:target/cucumber-reports/reports.html"},
				
publish = true,  dryRun = false

)
//runner class must extend AbstractTestNGCucumberTests
public class HealthInsuranceRunner extends AbstractTestNGCucumberTests {
//rightclick this class and run as testNG
	 @Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }

	    // ✅ Run all scenarios twice
//	    @Test(dataProvider = "scenarios")
//	    public void runScenario(io.cucumber.testng.PickleWrapper pickleWrapper,
//	                            io.cucumber.testng.FeatureWrapper featureWrapper) {
//	        super.runScenario(pickleWrapper, featureWrapper);
//}
}
