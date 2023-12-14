package pages.web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverManager;
import enums.WaitLogic;
import utils.BasePage;

public class ManageChargesWebPage_Inchara extends BasePage {

	WebDriver ldriver = DriverManager.getWebDriver();

	public ManageChargesWebPage_Inchara(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(linkText = "Manage Charges")
	private WebElement ManageChargesLink;

	@FindBy(xpath = "(//a[text() = 'Modify Charges/Discounts'])[1]")
	private WebElement ModifyCharges_DiscountsLink;

	@FindBy(xpath = "(//div[@uid='cmbChargeCategory']//input)[2]")
	private WebElement DiscountRefund;

	@FindBy(xpath = "(//div[@uid=\"cmbChargeName\"]//input)[2]")
	private WebElement Productdiscount;

	@FindBy(xpath = "(//div[@uid=\"cmbApplyTo\"]//input)[2]")
	private WebElement charge_PerLine;

	@FindBy(xpath = "(//div[@uid = \"txt_chargeAmount\"]//input)[1]")
	private WebElement DiscountTextBox;

	@FindBy(id = "(//div[@uid = \"txtNoteText\"]//textarea)[1]")
	private WebElement NoteText;

	@FindBy(xpath = "(//span[text() = 'Apply'])[2]")
	private WebElement ApplyBtn;

	@FindBy(xpath = "(//span[@uid = \"nextBttn2\"]//span)[5]")
	private WebElement NextBtn;

	@FindBy(xpath = "(//Span[text() = 'Confirm'])[1]")
	private WebElement ConfirmBtn;

	@FindBy(xpath = "(//span[text() = \"Total amount:\"])[1]")
	private WebElement TotalAmt;

	public void clickManageChargesLink() {
		jsClick(ManageChargesLink, WaitLogic.CLICKABLE, "ManageChargesLink");
		jsClick(By.xpath("(//a[text() = 'Modify Charges/Discounts'])[1]"), WaitLogic.CLICKABLE, "ManageChargesLink");
	}

	public void clickModifyCharges_DiscountsLink() {

		jsClick(By.linkText("Modify Charges/Discounts"), WaitLogic.CLICKABLE, "ModifyCharges_DiscountsLink");
	}

	public void enterDiscountRefundValue(String ChargeCategory) {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(15));
		By by = By.xpath("(//div[@uid='cmbChargeCategory']//input)[2]");
		wait.until(ExpectedConditions.elementToBeClickable(by));
		WebElement element = ldriver.findElement(by);
		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		element.sendKeys("Discount/Refund");
		element.sendKeys(Keys.ENTER);
	}

	public void selectProductDiscount_drpdwn(String productDiscount) {
		WebDriverWait wait1 = new WebDriverWait(ldriver, Duration.ofSeconds(15));
		By by = By.xpath("(//div[@uid=\"cmbChargeName\"]//input)[2]");
		wait1.until(ExpectedConditions.elementToBeClickable(by));
		WebElement element1 = ldriver.findElement(by);
		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();
		element1.sendKeys("Product discount");
		element1.sendKeys(Keys.ENTER);

	}

	public void selectChargeperLine(String chargeperLine) {

		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		By by = By.xpath("(//div[@uid=\"cmbApplyTo\"]//input)[2]");
		wait.until(ExpectedConditions.elementToBeClickable(by));
		charge_PerLine.click();
		charge_PerLine.sendKeys("Charge Per Line");
		charge_PerLine.sendKeys(Keys.ENTER);

		// sendKeys(By.id("//*[@id=\"idx_form_FilteringSelect_13\"]"), "Charge Per
		// Line", WaitLogic.VISIBLE, "Apply to:");
	}

	public void enterDiscountTextBox(String ChargeAmount) {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		By by = By.xpath("((//div[@uid = \"txt_chargeAmount\"]//input)[1]");
		wait.until(ExpectedConditions.elementToBeClickable(by));
		DiscountTextBox.click();
		DiscountTextBox.sendKeys("20");
		DiscountTextBox.sendKeys(Keys.ENTER);
		//sendKeys(By.xpath("(//div[@uid = \"txt_chargeAmount\"]//input)[1]"), "20", WaitLogic.VISIBLE, ChargeAmount);
	}

	public void enterNoteText(String Note) {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		By by = By.xpath("(//div[@uid = \"txtNoteText\"]//textarea)");
		wait.until(ExpectedConditions.elementToBeClickable(by));
		NoteText.click();
		NoteText.sendKeys("add all details");
		NoteText.sendKeys(Keys.ENTER);
	}

	public void clickOnApplyBtn() {
		click(ApplyBtn, WaitLogic.CLICKABLE, "ApplyBtn");
	}

	public void clickOnNextBtn() {
		// click(NextBtn, WaitLogic.CLICKABLE, "NextBtn");
		jsClick(NextBtn, WaitLogic.CLICKABLE, "NextBtn");
	}

	public void clickOnConfirmBtn() {
		jsClick(ConfirmBtn, WaitLogic.CLICKABLE, "ConfirmBtn");
	}

	public void displayTotalAmt() {
		isVisible(By.xpath("(//span[text() = \"Total amount:\"])[1]"), "TotalAmt");
	}
}