package drivers;

import java.net.MalformedURLException;

import config.PropertyBuilder;
import enums.ConfigProperties;
import exceptions.BrowserInvocationFailedException;
import factories.DriverFactory;

public final class Driver {
    private Driver() {

    }

    public static void initDriver() {
        String browser = PropertyBuilder.getPropValue(ConfigProperties.BROWSER_TYPE);

        if (browser.equalsIgnoreCase("appium")) {
            try {
                DriverFactory.initAppiumDriver();
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Failed to initialize AppiumDriver");
            }
        } else {
            try {
                DriverFactory.initWebDriver();
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Failed to initialize WebDriver");
            }
        }
    }

    public static void quitDriver() {
        if (DriverFactory.getAppiumDriverInstance() != null) {
            DriverFactory.getAppiumDriverInstance().quit();
        }

        if (DriverFactory.getWebDriverInstance() != null) {
            DriverFactory.getWebDriverInstance().quit();
        }

//        DriverManager.unload();
    }
}
