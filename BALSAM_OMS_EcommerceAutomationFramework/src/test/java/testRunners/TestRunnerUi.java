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

@CucumberOptions(features = "src/test/resources/features/web/CallCenterUI_Senarios.feature", glue = {
		"stepDefinitions" }, tags = "@CallCenterUI_Senarios", plugin = { "pretty", "html:target/cucumber-reports" })

public class TestRunnerUi extends AbstractTestNGCucumberTests  {

	public static WebDriver driver;
	
	@BeforeMethod
	public static void SETUP()  {
		
		Driver.initDriver();
		try {
			driver = DriverManager.getWebDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = Constants.getBaseUrl();
		System.out.println(url);
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public static void teardown()  {
		BasePage bpg = new BasePage();
		//bpg.closeBrowser();
	}
}
