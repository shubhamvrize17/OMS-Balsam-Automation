package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import testRunners.TestRunnerUi;
import io.cucumber.java.en.Then;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import constants.Constants;
import drivers.Driver;
import drivers.DriverManager;
import enums.ConfigProperties;
import factories.DriverFactory;
import io.cucumber.java.en.And;

public class WebStepDefinitions {

	@Given("I am on the Google homepage")
	public void i_am_on_the_google_homepage() throws Exception {
		
		System.out.println("execute");
		//TestRunner.SETUP();
		
	}

}

