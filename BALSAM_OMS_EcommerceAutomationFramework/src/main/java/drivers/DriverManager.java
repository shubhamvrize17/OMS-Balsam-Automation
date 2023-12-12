package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;

import factories.DriverFactory;

public final class DriverManager {
    private DriverManager() {

    }

//    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
//    private static ThreadLocal<AppiumDriver<MobileElement>> appiumDriver = new ThreadLocal<>();

    public static WebDriver getWebDriver() {
        return DriverFactory.getWebDriverInstance();
    }

    public static AppiumDriver<MobileElement> getAppiumDriver() {
        return DriverFactory.getAppiumDriverInstance();
    }

//    public static void unload() {
//        webDriver.remove();
//        appiumDriver.remove();
//    }
    
    

//    /**
//     * This method is used to get the appium driver with ThreadLocal.
//     *
//     * @return AppiumDriver
//     */
//    public static synchronized AppiumDriver<MobileElement> getAppiumDriver() {
//        return DriverFactory.tlAppiumDriver.get();
//    }
//
//    /**
//     * This method is used to get the WebDriver with ThreadLocal.
//     *
//     * @return WebDriver
//     */
//    public static synchronized WebDriver getWebDriver() {
//        return tlWebDriver.get();
    }

