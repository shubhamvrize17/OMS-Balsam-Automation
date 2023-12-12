package pages.web;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;
import utils.BaseUtils;

public class WebPageObjects {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "error-message")
    private WebElement errorMessage;

    private final WebDriver driver;

    public WebPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public void enterCredentials(String username, String password) {
        BaseUtils.enterValue(usernameInput, username);
        BaseUtils.enterValue(passwordInput, password);
    }

//    public void clickLoginButton() {
//        BaseUtils.click(loginButton);
//    }

    public boolean isErrorMessageDisplayed() {
        return BaseUtils.waitForElementToBeVisibleBool(errorMessage);
    }

}


