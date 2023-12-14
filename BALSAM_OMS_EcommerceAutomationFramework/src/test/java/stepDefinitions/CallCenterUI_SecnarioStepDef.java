package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.Constants;
import drivers.Driver;
import drivers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.CancelProductWebPage;
import pages.web.LoginWebPage;
import pages.web.ManageChargesWebPage;
import pages.web.ManageGiftOptions;
import utils.BasePage;

public class CallCenterUI_SecnarioStepDef extends BasePage {
	public WebDriver driver;
	public LoginWebPage loginPg;
	public ManageGiftOptions manageGp;
	public ManageChargesWebPage manageCh;
	public CancelProductWebPage cancelPd;

	@Given("User launch Browser")
	public void user_launch_browser() {

		driver = DriverManager.getWebDriver();
	}

	// Scenario: 1 _ Login

	@Given("The user on login page")
	public void the_user_on_login_page() {

		loginPg = new LoginWebPage(driver);
	}

	@When("User enter the <username> and <password>")
	public void user_enter_the_username_and_password(List<Map<String, String>> credentials) {
		// Extract values from the table and perform the necessary actions
		String username = credentials.get(0).get("username");
		String password = credentials.get(0).get("password");

		loginPg.enterCredentials(username, password);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		loginPg.clickLoginButton();
	}

	@Then("The user will be display the home page")
	public void the_user_will_be_display_the_home_page() {
		loginPg.isHomePageDisplayed();
	}

	@When("User enter the <OrderNumber> in order search text box")
	public void user_enter_the_order_number_in_order_search_text_box(List<Map<String, String>> credentials) {
		manageGp = new ManageGiftOptions(driver);
		String OrderNumber = credentials.get(0).get("OrderNumber");
		manageGp.enterOrderNo(OrderNumber);
	}

	@When("Click on  Find order")
	public void click_on_find_order() {
		manageGp.clickFindOrderButton();
	}

	@Then("The order summary page should apper")
	public void the_order_summary_page_should_apper() {
		manageGp.isOrderSummaryPageDisplayed();
	}

	// Scenario -2@ManageCharges
	@When("Click on {string} from Releated Task sub window")
	public void click_on_from_releated_task_sub_window(String string) {
		manageCh = new ManageChargesWebPage(driver);
		manageCh.clickManageChargesLink();
	}

	@When("Click on {string} at header level")
	public void click_on_at_header_level(String string) {
		manageCh.clickModifyCharges_DiscountsLink();
	}

	@When("Select Discount\\/Refund from the <ChargeCategory> dropdown")
	public void select_discount_refund_from_the_charge_category_dropdown(List<Map<String, String>> credentials) {
		String ChargeCategory = credentials.get(0).get("ChargeCategory");
		try {
			manageCh.enterDiscountRefundValue(ChargeCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("Select {string} from the charge name dropdown")
	public void select_from_the_charge_name_dropdown(String Productdiscount) {
		try {
			manageCh.selectProductDiscount_drpdwn(Productdiscount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("Select {string}  from the Applyto dropdown")
	public void select_from_the_applyto_dropdown(String chargeperLine) {
		manageCh.selectChargeperLine(chargeperLine);
	}

	@When("Provide the discount amount in the <ChargeAmount> textbox")
	public void provide_the_discount_amount_in_the_charge_amount_textbox(List<Map<String, String>> credentials) {
		String ChargeAmount = credentials.get(0).get("ChargeAmount");
		manageCh.enterDiscountTextBox(ChargeAmount);
	}

	@Then("Provide the note in the Note textbox")
	public void provide_the_note_in_the_note_textbox(List<Map<String, String>> credentials)
			throws InterruptedException {
		String Note = credentials.get(0).get("Note");
		manageCh.enterNoteText(Note);
	}

	@Then("Click on the Apply button")
	public void click_on_the_apply_button() {
		manageCh.clickOnApplyBtn();
	}

	@When("Click on Next button Manage Charge Page")
	public void click_on_next_button_manage_charge_page() {
		manageCh.clickOnNextBtn();
	}

	@When("Click on Confirm button Manage Charges Page")
	public void click_on_confirm_button_manage_charges_page() {
		manageCh.clickOnConfirmBtn();
	}

	@Then("The total amount will be reflected according to discount amount in order Summary screen")
	public void the_total_amount_will_be_reflected_according_to_discount_amount_in_order_summary_screen() {
		System.out.println("Display Summury screen");
		manageCh.displayTotalAmt();
	}

	// Scenario -3 ManageGiftOptions

	@Then("Click on Manage Gift Option from Releated Task sub window")
	public void click_on_manage_gift_option_from_releated_task_sub_window() {
		manageGp.clickManageGiftOptionsLink();
	}

	@Then("Click on Next button Manage Gift option page")
	public void click_on_next_button_manage_gift_option_page() {
		manageGp.clickOnNextButton();
	}

	@Then("It display the Manage Gift option")
	public void it_display_the_manage_gift_option() {
		manageGp.displayConfirmButton();
	}

	// Scenario: 4

	@Then("Click on cancel product from Releated Task sub window")
	public void click_on_cancel_product_from_releated_task_sub_window() {
		cancelPd = new CancelProductWebPage(driver);
		cancelPd.clickCancelProductsLink();

	}

	@Then("Select {string} from Reason code dropdown")
	public void select_from_Reason_code_dropdown(String Orderedwrongitem) {
		cancelPd.clickReasonforcancelproduct_dropdown(Orderedwrongitem);
	}

	@Then("Click on {string} from Choose an option")
	public void click_on_from_choose_an_option(String string) {
		cancelPd.clickChoseanOption();
	}

	@When("Click on CheckBox in Cancel product Page")
	public void click_on_check_box_in_cancel_product_page() {
		cancelPd.selectCheckBtn();
	}

	@Then("Click on the Next button Cancel Product Page")
	public void click_on_the_Next_button_cancel_product_page() {
		cancelPd.selectNextBtn();
	}

	@Then("Click Ok button in pop up screen")
	public void click_ok_button_in_pop_up_screen() throws InterruptedException {
		cancelPd.selectOkBtn();
	}

	@Then("Click on Confirm button Cancel Product page")
	public void click_on_confirm_button_cancel_product_page() {
		cancelPd.selectConfirmBtn();
	}

	@Then("Verify the order should be get cancelled on order summury page")
	public void verify_the_order_should_be_get_cancelled_on_order_summury_page() {
		cancelPd.displayCancelProduct();
	}
	
	//Scenario -5partial
	
	@When("Click on CheckBox in Partial Cancel product Page")
	public void click_on_check_box_in_partial_cancel_product_page() {
		cancelPd.partialselectCheckBtn();
	}

}
