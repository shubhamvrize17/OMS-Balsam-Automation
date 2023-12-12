package constants;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import config.PropertyBuilder;
import drivers.Driver;
import drivers.DriverManager;
import enums.ConfigProperties;
import factories.DriverFactory;
import utils.JavaUtils;

public final class Constants {

	private Constants() {
	}

	static JavaUtils appUtil = new JavaUtils();
	private static final int EXPLICIT_WAIT = 60;
	private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String WEBTEST_PROPERTY_FILE_PATH = RESOURCES_PATH + "/webtest.properties"; // Update the path
	private static final String BROWSER = PropertyBuilder.getPropValue(ConfigProperties.BROWSER_TYPE, "chrome");
	private static final String DRIVER_BASE_URL = PropertyBuilder.getPropValue(ConfigProperties.BASE_URL,
			"http://sterling-oms-qa.z.balsamhill.com:9080/isccs/isccs/login.do");

	private static final String API_BASE_URL = PropertyBuilder.getPropValue(ConfigProperties.APIBASEURL,
			"http://sterling-oms-qa.z.balsamhill.com:9080/smcfs/restapi");

	private static final String EXCEL_PATH = "";
	private static final String INPUT_JSON_PATH = "";
//    private static final String APPLICATION_PATH = PropertyBuilder.getPropValue(ConfigProperties.APP_PATH);
	private static final String RUN_MODE = System.getProperty("runmode");
	private static final int QUICKWAIT = appUtil
			.convertStringToInt(PropertyBuilder.getPropValue(ConfigProperties.QUICK_WAIT, "5"));
	private static final int SHORTWAIT = appUtil
			.convertStringToInt(PropertyBuilder.getPropValue(ConfigProperties.SHORT_WAIT, "15"));
	private static final int MEDIUMWAIT = appUtil
			.convertStringToInt(PropertyBuilder.getPropValue(ConfigProperties.MEDIUM_WAIT, "30"));
	private static final int LONGWAIT = appUtil
			.convertStringToInt(PropertyBuilder.getPropValue(ConfigProperties.LONG_WAIT, "60"));
	private static final int FLUENTWAIT = appUtil
			.convertStringToInt(PropertyBuilder.getPropValue(ConfigProperties.FLUENT_WAIT, "2"));
	private static final int POLLINGWAIT = appUtil
			.convertStringToInt(PropertyBuilder.getPropValue(ConfigProperties.POLLING_WAIT, "2"));
	private static final String PLATFORM = PropertyBuilder.getPropValue(ConfigProperties.PLATFORM, "local");
	private static final String PLATFORMNAME = PropertyBuilder.getPropValue(ConfigProperties.PLATFORM_NAME, "android");
//    private static final String DEVICENAME = PropertyBuilder.getPropValue(ConfigProperties.DEVICE_NAME);

	public static JavaUtils getAppUtil() {
		return appUtil;
	}

	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}

	public static String getResourcesPath() {
		return RESOURCES_PATH;
	}

	public static String getWebtestPropertyFilePath() {
		return WEBTEST_PROPERTY_FILE_PATH;
	}

	public static String getBrowser() {
		return BROWSER;
	}

	public static String getExcelPath() {
		return EXCEL_PATH;
	}

	public static String getInputJsonPath() {
		return INPUT_JSON_PATH;
	}

//	public static String getApplicationPath() {
//		return APPLICATION_PATH;
//	}
	public static String getRunMode() {
		return RUN_MODE;
	}

	public static int getQuickwait() {
		return QUICKWAIT;
	}

	public static int getShortwait() {
		return SHORTWAIT;
	}

	public static int getMediumwait() {
		return MEDIUMWAIT;
	}

	public static int getLongwait() {
		return LONGWAIT;
	}

	public static int getFluentwait() {
		return FLUENTWAIT;
	}

	public static int getPollingwait() {
		return POLLINGWAIT;
	}

	public static String getPlatform() {
		return PLATFORM;
	}

	public static String getPlatformname() {
		return PLATFORMNAME;
	}

	public static String getBaseUrl() {
		return DRIVER_BASE_URL;
	}

	public static String getAPIBASEURL() {
		return API_BASE_URL;
	}

}
