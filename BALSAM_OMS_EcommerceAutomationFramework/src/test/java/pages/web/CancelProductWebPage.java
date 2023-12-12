package pages.web;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import enums.WaitLogic;
import utils.BasePage;
public class CancelProductWebPage extends BasePage {
	WebDriver ldriver;
	public CancelProductWebPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	@FindBy(linkText = "Cancel Products")
	private WebElement CancelProductsLink;
	
	@FindBy(xpath = "(//div[@uid='cmbReasoncode']//input)[2]")
	private WebElement Reasonforcancelproduct_dropdown;
	
	@FindBy(xpath = "(//div[@widgetid='idx_form_RadioButtonSet_1_RadioItem1']//input)[1]")
	private WebElement ChoseanOption;
	
	@FindBy(xpath = "(//*[@class='gridxRowHeaderBody']//span)[1]")
	private WebElement CheckBtn;
	
	@FindBy(xpath = "(//*[@uid='navigationPanel']//span)[12]")
	private WebElement NextBtn;

	@FindBy(xpath = "//span[text() = 'Ok']")
	private WebElement okBtn;
	
	
	@FindBy(xpath = "(//span[text()='Confirm'])[1]")
	private WebElement ConfirmBtn;
	
	@FindBy(xpath = "(//*[@class='messageAction']/span[2]//span)[5]")
	private WebElement Clickcancel;
	
	@FindBy(xpath = "//span[text() = 'Cancelled']")
	private WebElement verifyCancelled;
	
	public void clickCancelProductsLink() {
		click(CancelProductsLink, WaitLogic.CLICKABLE, "CancelProductsLink");
	}
	public void clickReasonforcancelproduct_dropdown(String Orderedwrongitem) {
		WebDriverWait wait= new WebDriverWait(ldriver, Duration.ofSeconds(5));
		By by=By.xpath("(//div[@uid='cmbReasoncode']//input)[2]");
					wait.until(ExpectedConditions.elementToBeClickable(by));
					Reasonforcancelproduct_dropdown.click();
					Reasonforcancelproduct_dropdown.sendKeys("Ordered wrong item");
					Reasonforcancelproduct_dropdown.sendKeys(Keys.ENTER);
	}
	public void clickChoseanOption() {
		//click(By.xpath("(//div[@widgetid='idx_form_RadioButtonSet_1_RadioItem1']//input)[1]"), WaitLogic.CLICKABLE, "ChoseanOption");
		WebDriverWait wait= new WebDriverWait(ldriver, Duration.ofSeconds(5));
		By by=By.xpath("(//div[@aria-label='Choose an option:']//input)[3]");
					wait.until(ExpectedConditions.elementToBeClickable(by));
					ChoseanOption.click();
	}

	public void selectCheckBtn() {
		click(CheckBtn, WaitLogic.CLICKABLE,"CheckBtn");
	}
	public void selectNextBtn() {
		click(NextBtn, WaitLogic.CLICKABLE, "NextBtn");
	}
	public void selectOkBtn() throws InterruptedException {
		WebDriverWait wait= new WebDriverWait(ldriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(okBtn));
		jsClick(okBtn, WaitLogic.CLICKABLE, "OKBtn");
		Thread.sleep(5000);
	}

	public void selectConfirmBtn() {
		jsClick(ConfirmBtn, WaitLogic.CLICKABLE, "ConfirmBtn");
	}
	public void displayCancelProduct() {
		isVisible(By.xpath("//span[text() = 'Cancelled']"), "verifyCancelled");
	}


}