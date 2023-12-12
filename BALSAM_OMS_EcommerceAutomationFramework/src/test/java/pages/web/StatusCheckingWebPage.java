package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import enums.WaitLogic;
import utils.BasePage;

public class StatusCheckingWebPage extends BasePage{
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

	@FindBy(xpath = "//span[text() = 'Order Summary']")
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
		isElementPresent(By.xpath("//span[text() = 'Order Summary']"), WaitLogic.CLICKABLE, "OrderSummaryPage");

	}
}
