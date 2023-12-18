package pages.web;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import enums.WaitLogic;
import utils.BasePage;

public class StatusCheckingWebPage extends BasePage {
	WebDriver adriver;

	public StatusCheckingWebPage(WebDriver rDriver) {
		adriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(id = "idx_form_TextBox_0")
	private WebElement usernameInput;

	@FindBy(id = "loginPassword")
	private WebElement passwordInput;

	@FindBy(id = "dijit_form_Button_0")
	private WebElement loginButton;

	@FindBy(xpath = "//span[@class = 'tabLabel' and text() = 'Home']")
	private WebElement homePageHeader;

	@FindBy(xpath = "//div[@class='dijitReset dijitInputField dijitInputContainer'] //input[@id='idx_form_TextBox_0']")
	private WebElement OrderNoTextInput;

	@FindBy(xpath = "//span[@uid='bFindOrder'] //span[@id='dijit_form_Button_1']")
	private WebElement FindOrderBtn;

	@FindBy(xpath = "//*[@uid='lblStatus']")
	private WebElement OrderSummaryPage;

	public void enterCredentials(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
	}

	public void clickLoginButton() {
		click(loginButton, WaitLogic.CLICKABLE, "login");

	}

	public void isHomePageDisplayed() {
		isElementPresent(By.xpath("//span[@class = 'tabLabel' and text() = 'Home']"), WaitLogic.CLICKABLE,
				"homePageHeader");

	}

	public void enterOrderNo(String orderNumber) {
		sendKeys(By.xpath(
				"//div[@class='dijitReset dijitInputField dijitInputContainer'] //input[@id='idx_form_TextBox_0']"),
				orderNumber, WaitLogic.VISIBLE, "orderNumber");

	}

	public void clickFindOrderButton() {
		click(By.xpath("//span[@uid='bFindOrder'] //span[@id='dijit_form_Button_1']"), WaitLogic.CLICKABLE,
				"FindOrderBtn");
	}

	public void isOrderSummaryPageDisplayed() {
//		isElementPresent(By.xpath("//span[text() = 'Order Summary']"), WaitLogic.CLICKABLE, "OrderSummaryPage");
		WebDriverWait wait = new WebDriverWait(adriver, Duration.ofSeconds(10));
		WebElement OrderSummaryPage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@uid='lblStatus']")));

		String status = OrderSummaryPage.getText();

		System.out.println("status :" + status);

		if (status.equals("Created")) {
			Assert.assertTrue(true, "Status 'Created' is present.");
		} else if (status.equals("Scheduled")) {
			Assert.assertTrue(true, "Status 'Scheduled' is present.");
		} else if (status.equals("Released")) {
			Assert.assertTrue(true, "Status 'Released' is present.");
		} else if (status.equals("Shipped")) {
			Assert.assertTrue(true, "Status 'Shipped' is present.");
		}else {
			Assert.fail("Unexpected status: " + status);
		}
	}

}
