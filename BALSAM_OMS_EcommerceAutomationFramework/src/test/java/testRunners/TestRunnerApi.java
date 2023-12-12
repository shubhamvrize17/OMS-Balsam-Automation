package testRunners;

import java.net.MalformedURLException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constants.Constants;
import drivers.Driver;
import drivers.DriverManager;
import factories.DriverFactory;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.BasePage;

@CucumberOptions(features = "src/test/resources/features/api/CallCenter_ApiScenario.feature", glue = {
		"stepDefinitions" }, tags = "@CallCenterApiScenario", plugin = { "pretty", "html:target/cucumber-reports" })

public class TestRunnerApi extends AbstractTestNGCucumberTests  {

}
