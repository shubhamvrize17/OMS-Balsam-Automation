package pages.web;

import java.time.Duration;

import org.openqa.selenium.By;
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

public class ManageChargesWebPage extends BasePage {

	WebDriver ldriver = DriverManager.getWebDriver();

	public ManageChargesWebPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//a[text() = 'Manage Charges']")
	private WebElement ManageChargesLink;
	
	@FindBy(linkText = "Modify Charges/Discounts")
	private WebElement ModifyCharges_DiscountsLink;

	@FindBy(xpath = "(//div[@uid='cmbChargeCategory']//input)[2]")
	private WebElement DiscountRefund;

	@FindBy(xpath = "(//div[@uid=\"cmbChargeName\"]//input)[2]")
	private WebElement Productdiscount;
	
	@FindBy(xpath = "(//div[@uid=\"cmbApplyTo\"]//input)[2]")
	private WebElement charge_PerLine;
	
	@FindBy(xpath = "(//div[@uid = \"txt_chargeAmount\"]//input)[1]")
	private WebElement DiscountTextBox;

	@FindBy(id = "(//div[@uid = \"txtNoteText\"]//textarea)")
	private WebElement NoteText;

	@FindBy(xpath = "(//span[text() = 'Apply'])[2]")
	private WebElement ApplyBtn;

	@FindBy( xpath = "(//span[@uid = \"nextBttn2\"]//span)[5]")
	private WebElement NextBtn;
	
	@FindBy( xpath = "(//Span[text() = 'Confirm'])[1]")
	private WebElement ConfirmBtn;
	
	
	@FindBy( xpath = "(//span[text() = \"Total amount:\"])[1]")
	private WebElement TotalAmt;
	
	
	public void clickManageChargesLink() {
		click(ManageChargesLink, WaitLogic.CLICKABLE, "ManageChargesLink");
	}

	
	
	public void clickModifyCharges_DiscountsLink() {

		jsClick(By.linkText("Modify Charges/Discounts"), WaitLogic.CLICKABLE, "ModifyCharges_DiscountsLink");
	}

	public void enterDiscountRefundValue(String ChargeCategory)  {
		sendKeys(By.xpath("(//div[@uid='cmbChargeCategory']//input)[2]"), "Discount/Refund", WaitLogic.VISIBLE,
				ChargeCategory);
		DiscountRefund.sendKeys(Keys.ENTER);
	}

	public void selectProductDiscount_drpdwn(String productDiscount)  {
		
		
		WebDriverWait wait= new WebDriverWait(ldriver, Duration.ofSeconds(5));
		   By by=By.xpath("(//div[@uid=\"cmbChargeName\"]//input)[2]");
			wait.until(ExpectedConditions.elementToBeClickable(by));
			Productdiscount.click();
			Productdiscount.clear();
			Productdiscount.sendKeys("Product discount");
			Productdiscount.sendKeys(Keys.ENTER);
		
	}

	public void selectChargeperLine(String chargeperLine) {
		
		WebDriverWait wait= new WebDriverWait(ldriver, Duration.ofSeconds(5));
		   By by=By.xpath("(//div[@uid=\"cmbApplyTo\"]//input)[2]");
			wait.until(ExpectedConditions.elementToBeClickable(by));
			charge_PerLine.click();
			charge_PerLine.sendKeys("Charge Per Line");
			charge_PerLine.sendKeys(Keys.ENTER);

		//sendKeys(By.id("//*[@id=\"idx_form_FilteringSelect_13\"]"), "Charge Per Line", WaitLogic.VISIBLE, "Apply to:");
	}

	public void enterDiscountTextBox(String ChargeAmount) {
		sendKeys(By.xpath("(//div[@uid = \"txt_chargeAmount\"]//input)[1]"), "20", WaitLogic.VISIBLE, ChargeAmount);
	}

	public void enterNoteText(String Note) {
		sendKeys(By.xpath("(//div[@uid = \"txtNoteText\"]//textarea)"), Note, WaitLogic.VISIBLE, "NoteText");
	}

	public void clickOnApplyBtn() {
		click(ApplyBtn, WaitLogic.CLICKABLE, "ApplyBtn");
	}
	
	public void clickOnNextBtn() {
		//click(NextBtn, WaitLogic.CLICKABLE, "NextBtn");
		jsClick(NextBtn, WaitLogic.CLICKABLE, "NextBtn");
	}
	
	public void clickOnConfirmBtn() {
		jsClick(ConfirmBtn, WaitLogic.CLICKABLE, "ConfirmBtn");
	}

	public void displayTotalAmt() {
		isVisible(By.xpath("(//span[text() = \"Total amount:\"])[1]"), "TotalAmt");
	}
}