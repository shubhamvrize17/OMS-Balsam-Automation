package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import drivers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.LoginWebPage;
import pages.web.ManageGiftOptions;
import pages.web.StatusCheckingWebPage;
import utils.BasePage;

public class StatusCheckingStepDef extends BasePage {
	public WebDriver driver;
	public StatusCheckingWebPage cr;

	@Given("User launch the Browser")
	public void User_launch_the_browser() {
		driver = DriverManager.getWebDriver();
	}

	@Given("User on login page")
	public void User_on_login_page() {

		cr = new StatusCheckingWebPage(driver);
	}

	@When("User enter <username> and <password> for status checking page")
	public void user_enter_username_and_password_for_status_checking_page(List<Map<String, String>> credentials) {
		String username = credentials.get(0).get("username");
		String password = credentials.get(0).get("password");
		cr.enterCredentials(username, password);
	}

	@When("User click on the login button")
	public void user_click_on_the_login_button() {
		cr.clickLoginButton();
	}

	@Then("User will be display the home page")
	public void User_will_be_display_the_home_page() {
		cr.isHomePageDisplayed();
	}

	@When("User enter the <OrderNumber> in the order search text box for status checking page")
	public void user_enter_the_order_number_in_the_order_search_text_box_for_status_checking_page(
			List<Map<String, String>> credentials) {
		cr = new StatusCheckingWebPage(driver);
		String OrderNumber = credentials.get(0).get("OrderNumber");
		cr.enterOrderNo(OrderNumber);
	}

	@When("Click on the Find order")
	public void click_on_the_find_order() {
		cr.clickFindOrderButton();
	}

	// scenario - created status

	@Then("The order should be in Created status")
	public void The_order_should_be_in_Created_status() {
		cr.isOrderSummaryPageDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
	}

	@Then("The order should be in Scheduled status")
	public void The_order_should_be_in_Scheduled_status() {
		cr.isOrderSummaryPageDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
	}

	@Then("The order should be in Released status")
	public void The_order_should_be_in_Released_status() {
		cr.isOrderSummaryPageDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
	}

	@Then("The order should be in Shipment status")
	public void The_order_should_be_in_Shipment_status() {
		cr.isOrderSummaryPageDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
	}

	@Then("The order should be in Delivered status")
	public void The_order_should_be_in_Delivered_status() {
		cr.isOrderSummaryPageDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
	}

}
