package factories;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.*;
import constants.Constants;
import enums.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static AppiumDriver<MobileElement> appiumDriver;
    private static WebDriver webDriver;

    private static ThreadLocal<AppiumDriver<MobileElement>> tlAppiumDriver = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> tlWebDriver = new ThreadLocal<>();
    

    /**
     * This method is used to initialize the thread-local driver based on the given
     * platformName.
     *
     * @param prop Properties
     * @throws MalformedURLException
     */
    public static void initAppiumDriver() throws MalformedURLException {
        DesiredCapabilities capAndroid = new DesiredCapabilities();
        DesiredCapabilities capIOS = new DesiredCapabilities();

        if (PropertyBuilder.getPropValue(ConfigProperties.PLATFORM).equalsIgnoreCase("local")) {
            if (PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_NAME).equalsIgnoreCase("android")) {
                // Set up capabilities for Android
                WebDriverManager.chromedriver().setup();
                capAndroid.setCapability("platformName", PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_NAME));
                capAndroid.setCapability("deviceName", PropertyBuilder.getPropValue(ConfigProperties.DEVICE_NAME));
                capAndroid.setCapability("automationName", "UIAutomator2");
                capAndroid.setCapability("platformVersion", PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_VERSION));
                capAndroid.setCapability("appWaitDuration", 60000);
                capAndroid.setCapability("app", PropertyBuilder.getPropValue(ConfigProperties.APP_PATH));
                capAndroid.setCapability("noReset", false);
                capAndroid.setCapability("fullReset", true);
                capAndroid.setCapability("autoAcceptAlerts", true);
                capAndroid.setCapability("autoGrantPermissions", true);
                appiumDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capAndroid);
                tlAppiumDriver.set(appiumDriver);
            } else if (PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_NAME).equalsIgnoreCase("ios")) {
                // Set up capabilities for iOS
                WebDriverManager.chromedriver().setup();
                capIOS.setCapability("platformName", PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_NAME));
                capIOS.setCapability("deviceName", PropertyBuilder.getPropValue(ConfigProperties.DEVICE_NAME));
                capIOS.setCapability("automationName", "XCUITest");
                capIOS.setCapability("platformVersion", PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_VERSION));
                capIOS.setCapability("app", PropertyBuilder.getPropValue(ConfigProperties.APP_PATH));
                capIOS.setCapability("noReset", false);
                capIOS.setCapability("autoAcceptAlerts", true);
                capIOS.setCapability("autoGrantPermissions", true);
                appiumDriver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capIOS);
                tlAppiumDriver.set(appiumDriver);
            }
        } else if (PropertyBuilder.getPropValue(ConfigProperties.PLATFORM).equalsIgnoreCase("sauce")) {
            if (PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_NAME).equalsIgnoreCase("android")) {
                capAndroid.setCapability("platformName", PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_NAME));
            capAndroid.setCapability("deviceName", PropertyBuilder.getPropValue(ConfigProperties.DEVICE_NAME));
            capAndroid.setCapability("automationName", "UIAutomator2");
            capAndroid.setCapability("app", "sauce-storage:your-app-name.apk"); // Update with your app name
            capAndroid.setCapability("platformVersion", PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_VERSION));
                appiumDriver = new AndroidDriver<>(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), capAndroid);
                tlAppiumDriver.set(appiumDriver);
            } else if (PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_NAME).equalsIgnoreCase("ios")) {
                capIOS.setCapability("platformName", PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_NAME));
            capIOS.setCapability("deviceName", PropertyBuilder.getPropValue(ConfigProperties.DEVICE_NAME));
            capIOS.setCapability("automationName", "XCUITest");
            capIOS.setCapability("app", "sauce-storage:your-app-name.ipa"); // Update with your app name
            capIOS.setCapability("platformVersion", PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_VERSION));
                appiumDriver = new IOSDriver<>(new URL("https://ondemand.apac-southeast-1.saucelabs.com:443/wd/hub"), capIOS);
                tlAppiumDriver.set(appiumDriver);
            }
        }

        // Set implicit wait
        WebDriverWait wait = new WebDriverWait(getAppiumDriverInstance(), Duration.ofSeconds(20));

        // Set WebDriver for local execution
        if (PropertyBuilder.getPropValue(ConfigProperties.PLATFORM).equalsIgnoreCase("local")) {
            if (appiumDriver != null) {
                webDriver = appiumDriver;
                tlWebDriver.set(webDriver);
            }
        }
    }

    public static void initWebDriver() throws MalformedURLException {

        if (PropertyBuilder.getPropValue(ConfigProperties.PLATFORM).equalsIgnoreCase("local")) {
            String browser = PropertyBuilder.getPropValue(ConfigProperties.BROWSER_TYPE);

            if (browser.equalsIgnoreCase("chrome")) {
                // Set up capabilities for Chrome
                WebDriverManager.chromedriver().setup();
            //    WebDriverManager.chromedriver().chromedriverVersion("your_chrome_version").setup();
               // WebDriverManager.chromedriver().config().setChromeDriverVersion("119.0.6045.200").setup();	
                WebDriverManager.chromedriver().browserVersion("120.0.6099.63").setup();
                		
                ChromeOptions chromeOptions = new ChromeOptions();
               // String chromeBinaryPath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
               // chromeOptions.setBinary(chromeBinaryPath);
                
                
                chromeOptions.addArguments("--remote-allow-origins=*");
                webDriver = new ChromeDriver(chromeOptions);
                tlWebDriver.set(webDriver);
            } else if (browser.equalsIgnoreCase("firefox")) {
                // Set up capabilities for Firefox
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                webDriver = new FirefoxDriver(firefoxOptions);
                tlWebDriver.set(webDriver);
            } else if (browser.equalsIgnoreCase("edge")) {
                // Set up capabilities for Edge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                webDriver = new EdgeDriver(edgeOptions);
                tlWebDriver.set(webDriver);
            }
        } else if (PropertyBuilder.getPropValue(ConfigProperties.PLATFORM).equalsIgnoreCase("remote")) {
            String browser = PropertyBuilder.getPropValue(ConfigProperties.BROWSER_TYPE);

            if (browser.equalsIgnoreCase("chrome")) {
                // Set up capabilities for remote Chrome
                ChromeOptions chromeOptions = new ChromeOptions();
                webDriver = new RemoteWebDriver(new URL("your_remote_url_here"), chromeOptions);
                tlWebDriver.set(webDriver);
            } else if (browser.equalsIgnoreCase("firefox")) {
                // Set up capabilities for remote Firefox
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                webDriver = new RemoteWebDriver(new URL("your_remote_url_here"), firefoxOptions);
                tlWebDriver.set(webDriver);
            } else if (browser.equalsIgnoreCase("edge")) {
                // Set up capabilities for remote Edge
                EdgeOptions edgeOptions = new EdgeOptions();
                webDriver = new RemoteWebDriver(new URL("your_remote_url_here"), edgeOptions);
                tlWebDriver.set(webDriver);
            }
        }
    }
    

    /**
     * This method is used to get the appium driver with ThreadLocal.
     *
     * @return AppiumDriver
     */
    public static synchronized AppiumDriver<MobileElement> getAppiumDriverInstance() {
        return tlAppiumDriver.get();
    }

    /**
     * This method is used to get the WebDriver with ThreadLocal.
     *
     * @return WebDriver
     */
    public static synchronized WebDriver getWebDriverInstance() {
        return tlWebDriver.get();
    }
}
