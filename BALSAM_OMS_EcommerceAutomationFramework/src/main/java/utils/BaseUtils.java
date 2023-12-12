package utils;

import config.*;
import drivers.DriverManager;
import enums.ConfigProperties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BaseUtils {

private static WebDriver driver= DriverManager.getWebDriver();

/**
     * This method enters a value in a text box element.
     *
     * @param element - WebElement representing the text box.
     * @param value   - The value to be entered.
     */
    public static void enterValue(WebElement element, String value) {
        try {
            waitForElementToBeClickable(element);
            element.click();
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.clear();
            element.sendKeys(value);
        } catch (Exception ex) {
            System.out.println("Exception occurred while entering value in the element. " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Clicks on the provided WebElement with a short implicit wait.
     * 
     * @param element WebElement to be clicked.
     */
    public static void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(PropertyBuilder.getPropValue(ConfigProperties.SHORT_WAIT))));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Clicks on the element located by the provided By locator with a short implicit wait.
     * 
     * @param locator By locator of the element to be clicked.
     */
    public static void clickElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(PropertyBuilder.getPropValue(ConfigProperties.SHORT_WAIT))));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    /**
     * Clicks on the element located by the provided By locator with a retry mechanism.
     * 
     * @param locator     By locator of the element to be clicked.
     * @param maxAttempts Maximum number of attempts to click the element.
     */
    public static void clickElementWithRetry(By locator, int maxAttempts) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(PropertyBuilder.getPropValue(ConfigProperties.SHORT_WAIT))));
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                break;
            } catch (StaleElementReferenceException e) {
                // Handle stale element exception and retry
                attempts++;
            }
        }
    }

    /**
     * Clicks on the element located by the provided By locator using JavaScript.
     * 
     * @param locator By locator of the element to be clicked.
     */
    public static void clickElementWithJavaScript(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(PropertyBuilder.getPropValue(ConfigProperties.SHORT_WAIT))));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    /**
     * Clicks on the element located by the provided By locator with explicit wait.
     * 
     * @param locator By locator of the element to be clicked.
     */
    public static void clickElementWithWait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(PropertyBuilder.getPropValue(ConfigProperties.SHORT_WAIT))));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    /**
     * Clicks on the element located by the provided By locator using Actions class.
     * 
     * @param locator By locator of the element to be clicked.
     */
    public static void clickElementWithActions(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(PropertyBuilder.getPropValue(ConfigProperties.SHORT_WAIT))));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }
    
    public static void clickWithJavaScript(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }


    /**
     * This method retrieves the text of a web element.
     *
     * @param element - WebElement whose text is to be retrieved.
     * @return The text of the web element.
     */
    public static String getTextOfWebElement(WebElement element) {
        String text = "";
        try {
            waitForElementToBeVisible(element);
            text = element.getText();
        } catch (Exception ex) {
            System.out.println("Exception occurred while retrieving the text of a web element. " + ex.getMessage());
            ex.printStackTrace();
        }
        return text;
    }



    /**
     * This method retrieves a wait instance.
     *
     * @return FluentWait instance.
     */
    public static Wait<WebDriver> getWait() {
        Duration timeout = Duration.ofSeconds(Long.parseLong(PropertyBuilder.getPropValue(ConfigProperties.MEDIUM_WAIT)));
        Duration pollingInterval = Duration.ofSeconds(Long.parseLong(PropertyBuilder.getPropValue(ConfigProperties.SHORT_WAIT)));

        return new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(pollingInterval)
                .ignoring(Exception.class);
    }

    /**
     * This method waits for the element to be visible.
     *
     * @param element - WebElement to be visible.
     */
    public static void waitForElementToBeVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method is for simple dropdown selection by index.
     *
     * @param dropDownID    - Unique attribute to find a dropdown element.
     * @param dropDownValue - Index of the value to be selected.
     */
    public static void dropDownSelectionByIndex(By dropDownID, int dropDownValue) {
        WebElement element = null;
        waitForElementToBeClickable(element);
        element = driver.findElement(dropDownID);
        Select dropDown = new Select(element);
        dropDown.selectByIndex(dropDownValue);
    }

    /**
     * This method is for simple dropdown selection by value.
     *
     * @param dropDownID    - Unique attribute to find a dropdown element.
     * @param dropDownValue - Value to be selected from the dropdown.
     */
    public static void dropDownSelectionByValue(By dropDownID, String dropDownValue) {
        WebElement element = null;
        waitForElementToBeClickable(element);
        element = driver.findElement(dropDownID);
        Select dropDown = new Select(element);
        dropDown.selectByValue(dropDownValue);
    }

    /**
     * This method is for simple dropdown selection by visibleText.
     *
     * @param dropDownID    - Unique attribute to find a dropdown element.
     * @param dropDownValue - Visible text of the value to be selected.
     */
    public static void dropDownSelectionByText(By dropDownID, String dropDownValue) {
        WebElement element = null;
        waitForElementToBeClickable(element);
        element = DriverManager.getWebDriver().findElement(dropDownID);
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(dropDownValue);
    }


     /**
     * This method is used to return the system time in seconds.
     *
     * @return The system time in seconds.
     */
    public static int getCurrentTimeInSeconds() {
        long currentDateMS = new Date().getTime();
        return (int) ((currentDateMS / 1000) % 3600);
    }

    /**
     * This method selects a radio button based on the given value.
     *
     * @param webElements - List of radio buttons.
     * @param value       - The value of the radio button to be selected.
     */
    public static void selectRadioButton(List<WebElement> webElements, String value) {
        for (WebElement element : webElements) {
            if (element.getAttribute("value").equalsIgnoreCase(value)) {
                element.click();
            }
        }
    }

    /**
     * This method waits for the element to be clickable.
     *
     * @param webElement - WebElement to be clickable.
     */
    public static void waitForElementToBeClickable(WebElement webElement) {
        Duration waitDuration = Duration.ofSeconds(Integer.parseInt(PropertyBuilder.getPropValue(ConfigProperties.SHORT_WAIT)));
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), waitDuration);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }


    /**
     * This method waits for the Alert to be present.
     */
    public static void waitForAlertPresent() {
    	Duration waitDuration = Duration.ofSeconds(Integer.parseInt(PropertyBuilder.getPropValue(ConfigProperties.SHORT_WAIT)));
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), waitDuration);
        wait.until(ExpectedConditions.alertIsPresent());
    }


    /**
     * This method is used to wait for an element to be visible, ignoring StaleElementReferenceException.
     *
     * @param webElement - The web element to wait for.
     * @param waitTime   - Maximum wait time.
     * @return True if the element becomes clickable within the specified time, false otherwise.
     */
    public static boolean waitForElementToBeClickableBool(WebElement webElement, Duration waitTime) {
        boolean flag = false;
        try {
        	Duration waitDuration = Duration.ofSeconds(Integer.parseInt(PropertyBuilder.getPropValue(ConfigProperties.SHORT_WAIT)));
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), waitDuration);
            wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(webElement));
            flag = true;
        } catch (Exception ex) {
            System.out.println("Exception occurred while waiting for the element to be clickable: " + ex.getMessage());
            ex.printStackTrace();
        }
        return flag;
    }


    /**
     * This method is used to wait for an alert to be present, ignoring StaleElementReferenceException.
     *
     * @param waitTime - Maximum wait time.
     * @return True if an alert is present within the specified time, false otherwise.
     */
    public static boolean waitForAlertPresent(Duration waitTime) {
        boolean flag = false;
        try {
            Wait<WebDriver> wait = new FluentWait<>(DriverManager.getWebDriver())
                    .withTimeout(waitTime)
                    .ignoring(StaleElementReferenceException.class);
            
            wait.until(ExpectedConditions.alertIsPresent());
            DriverManager.getWebDriver().switchTo().alert();
            flag = true;
        } catch (Exception ex) {
            System.out.println("Exception occurred while waiting for the Alert to be present: " + ex.getMessage());
            ex.printStackTrace();
        }
        return flag;
    }


    /**
     * This method scrolls up the web page.
     */
    public static void scroll_Up() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getWebDriver();
        jsExecutor.executeScript("window.scrollBy(0,-550)", "");
    }

    /**
     * This method scrolls down the web page.
     */
    public static void scroll_Down() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
        js.executeScript("window.scrollBy(0,550)", "");
    }

    /**
     * This method scrolls right on the web page.
     */
    public static void scroll_Right() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
        js.executeScript("window.scrollBy(350,0)", "");
    }

    /**
     * This method scrolls left on the web page.
     */
    public static void scroll_Left() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
        js.executeScript("window.scrollBy(-350,0)", "");
    }

    /**
     * This method retrieves the current date in the format "dd/MM/yy".
     *
     * @return The current date as a string.
     */
    public static String current_date() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    /**
     * This method generates random alphabetic characters of the specified length.
     *
     * @param length - The length of the random string to be generated.
     * @return The randomly generated string.
     */
    public static String random_char(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    /**
     * This method generates random alphanumeric characters of the specified length.
     *
     * @param length - The length of the random string to be generated.
     * @return The randomly generated string.
     */
    public static String random_alpha_numeric(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    /**
     * Pauses the execution for the specified duration in milliseconds.
     *
     * @param millis - The duration to pause in milliseconds.
     */
    public static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Exception occurred while pausing: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Clicks on the back button of the browser.
     */
    public static void clickOnBackButtonOnBrowser() {
        DriverManager.getWebDriver().navigate().back();
        System.out.println("Browser Back button is clicked on");
    }

    /**
     * Waits for an element to be visible, ignoring StaleElementReferenceException.
     *
     * @param by - Locator strategy for the element.
     * @return True if the element becomes visible within the specified time, false otherwise.
     */
    public static boolean waitForElementToBeVisible(By by) {
        boolean flag = false;
        try {
        	Duration waitTime = Duration.ofSeconds(Integer.parseInt(PropertyBuilder.getPropValue(ConfigProperties.FLUENT_WAIT)));
            Duration pollingInterval = Duration.ofSeconds(Integer.parseInt(PropertyBuilder.getPropValue(ConfigProperties.POLLING_WAIT)));

            Wait<WebDriver> wait = new FluentWait<>(DriverManager.getWebDriver())
                    .withTimeout(waitTime)
                    .pollingEvery(pollingInterval)
                    .ignoring(StaleElementReferenceException.class);

            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            flag = true;
        } catch (Exception ex) {
            System.out.println("Exception occurred while waiting for the element to be visible: " + ex.getMessage());
            ex.printStackTrace();
        }
        return flag;
    }


    /**
     * Closes all open windows except the parent window.
     *
     * @return True if all other windows are closed, false otherwise.
     * @throws InterruptedException if the thread is interrupted during sleep.
     */
    public static boolean closeAllOtherWindows() throws InterruptedException {
        String parentWindow = DriverManager.getWebDriver().getWindowHandle();
        Set<String> allWindowHandles = DriverManager.getWebDriver().getWindowHandles();
        for (String currentWindowHandle : allWindowHandles) {
            if (!currentWindowHandle.equals(parentWindow)) {
                DriverManager.getWebDriver().switchTo().window(currentWindowHandle);
                DriverManager.getWebDriver().close();
                Thread.sleep(2000);
            }
        }
        DriverManager.getWebDriver().switchTo().window(parentWindow);
        return DriverManager.getWebDriver().getWindowHandles().size() == 1;
    }
    
    /**
     * This method is used to wait for an element to be visible, ignoring StaleElementReferenceException.
     *
     * @param webElement - The web element to wait for.
     * @return True if the element becomes visible within the specified time, false otherwise.
     */
    public static boolean waitForElementToBeVisibleBool(WebElement webElement) {
        boolean flag = false;
        try {
        	Duration waitDuration = Duration.ofSeconds(Integer.parseInt(PropertyBuilder.getPropValue(ConfigProperties.MEDIUM_WAIT)));
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), waitDuration);
            wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(webElement));
            flag = true;
        } catch (Exception ex) {
            System.out.println("Exception occurred while waiting for the element to be visible: " + ex.getMessage());
            ex.printStackTrace();
        }
        return flag;
    }
    
    
}
