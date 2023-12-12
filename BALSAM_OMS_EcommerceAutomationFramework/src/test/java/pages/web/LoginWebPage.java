package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.PropertyBuilder;
import constants.Constants;
import drivers.Driver;
import drivers.DriverManager;
import enums.WaitLogic;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import utils.BasePage;
import utils.BaseUtils;

public class LoginWebPage extends BasePage {

	WebDriver ldriver;

	public LoginWebPage(WebDriver rDriver) {
		ldriver = rDriver;
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

}
