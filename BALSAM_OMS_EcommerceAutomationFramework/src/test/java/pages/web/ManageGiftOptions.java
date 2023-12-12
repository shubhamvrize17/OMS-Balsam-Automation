package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverManager;
import enums.WaitLogic;
import utils.BasePage;
import utils.BaseUtils;

public class ManageGiftOptions extends BasePage {

	WebDriver ldriver;

	public ManageGiftOptions(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//div[@class='dijitReset dijitInputField dijitInputContainer'] //input[@id='idx_form_TextBox_0']")
	private WebElement OrderNoTextInput;

	@FindBy(xpath = "//span[@uid='bFindOrder'] //span[@id='dijit_form_Button_1']")
	private WebElement FindOrderBtn;

	@FindBy(xpath = "//span[text() = 'Order Summary']")
	private WebElement OrderSummaryPage;

	@FindBy(linkText = "Manage Gift Options")
	private WebElement ManageGiftOptionsLink;

	@FindBy(xpath = "//span[@uid='nextBttn2'] //span[@id='dijit_form_Button_13']")
	private WebElement NextBtn;

	@FindBy(xpath = "//span[text()='Confirm']")
	private WebElement ConfirmBtn;

	public void enterOrderNo(String OrderNumber) {
		// BaseUtils.enterValue(OrderNoTextInput, OrderNumber);
		// OrderNoTextInput.sendKeys("OrderNumber");
		sendKeys(By.xpath(
				"//div[@class='dijitReset dijitInputField dijitInputContainer'] //input[@id='idx_form_TextBox_0']"),
				OrderNumber, WaitLogic.VISIBLE, "OrderNumber");
	}

	public void clickFindOrderButton() {
		// BaseUtils.clickElement(FindOrderBtn);
		// click(FindOrderBtn, WaitLogic.CLICKABLE, "FindOrderBtn");
		click(By.xpath("//span[@uid='bFindOrder'] //span[@id='dijit_form_Button_1']"), WaitLogic.CLICKABLE,
				"FindOrderBtn");
	}

	public void isOrderSummaryPageDisplayed() {
		isElementPresent(By.xpath("//span[text() = 'Order Summary']"), WaitLogic.CLICKABLE, "OrderSummaryPage");

	}

	public void clickManageGiftOptionsLink() {
		click(ManageGiftOptionsLink, WaitLogic.CLICKABLE, "ManageGiftOptionsLink");
	}

	public void clickOnNextButton() {
		// click(NextBtn, WaitLogic.CLICKABLE, "NextBtn");
		//jsClick(NextBtn, WaitLogic.CLICKABLE, "NextBtn");
	jsClick(By.xpath("//span[@uid='nextBttn2'] //span[@id='dijit_form_Button_13']"), WaitLogic.CLICKABLE, "NextBtn");
	
	}

	public void clickOnConfirmButton() {
		click(ConfirmBtn, WaitLogic.CLICKABLE, "ConfirmBtn");
		// isElementPresent(By.xpath("//span[text()='Confirm']"), WaitLogic.CLICKABLE,
		// "ConfirmBtn");
	}

	public void displayConfirmButton() {
		// click(ConfirmBtn, WaitLogic.CLICKABLE, "ConfirmBtn");
		isElementPresent(By.xpath("//span[text()='Confirm']"), WaitLogic.CLICKABLE, "ConfirmBtn");
	}

}
