package factories;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;
import drivers.DriverManager;
import enums.WaitLogic;
//import com.gep.constants.Constants;
//import com.gep.driver.DriverManager;
//import com.gep.enums.WaitLogic;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {}

    public static WebElement waitexplicitlyforElement(WaitLogic waitstrategy, By by) {
        WebElement element = null;
        if(waitstrategy == WaitLogic.CLICKABLE) {
            element = 	new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(Constants.getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        }
        else if(waitstrategy == WaitLogic.PRESENCE) {
            element =	new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(Constants.getExplicitWait()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if(waitstrategy == WaitLogic.VISIBLE) {
            element =new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(Constants.getExplicitWait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if(waitstrategy == WaitLogic.NONE) {
            element = DriverManager.getWebDriver().findElement(by);
        }
        return element; 
    }

    
    
    public static WebElement waitexplicitlyforElement(WaitLogic waitstrategy, By by, Duration timeout) {
		WebElement element = null;
		if (waitstrategy == WaitLogic.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getWebDriver(), timeout)
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitstrategy == WaitLogic.PRESENCE) {
			element = new WebDriverWait(DriverManager.getWebDriver(), timeout)
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitstrategy == WaitLogic.VISIBLE) {
			element = new WebDriverWait(DriverManager.getWebDriver(), timeout)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (waitstrategy == WaitLogic.NONE) {
			element = DriverManager.getWebDriver().findElement(by);
		}
		return element; 
	}
    
    public static List<WebElement> waitexplicitlyforElements(WaitLogic waitstrategy, By by) {
 	   List<WebElement> elements = null;
 	   if (waitstrategy == WaitLogic.PRESENCE) {
 	      elements = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(Constants.getExplicitWait()))
 	              .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
 	   } else if (waitstrategy == WaitLogic.VISIBLE) {
 	      elements = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(Constants.getExplicitWait()))
 	              .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
 	   } else if (waitstrategy == WaitLogic.NONE) {
 	      elements = DriverManager.getWebDriver().findElements(by);
 	   }
 	   return elements;
 	}
 
 public static List<WebElement> waitexplicitlyforElements(WaitLogic waitstrategy, By by, Duration timeout) {
	   List<WebElement> elements = null;
		 if (waitstrategy == WaitLogic.PRESENCE) {
			elements = new WebDriverWait(DriverManager.getWebDriver(), timeout)
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		} else if (waitstrategy == WaitLogic.VISIBLE) {
			elements = new WebDriverWait(DriverManager.getWebDriver(), timeout)
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		} else if (waitstrategy == WaitLogic.NONE) {
			elements = DriverManager.getWebDriver().findElements(by);
		}
		return elements;
	}
 
 public static WebElement waitexplicitlyforWebElement(WaitLogic waitstrategy, WebElement element, Duration timeout) {
	 List<WebElement> elements = null;
	 		WebDriverWait ele;
		if (waitstrategy == WaitLogic.CLICKABLE) {
			ele = (WebDriverWait) new WebDriverWait(DriverManager.getWebDriver(), timeout)
					.until(ExpectedConditions.elementToBeClickable(element));
		} else if (waitstrategy == WaitLogic.VISIBLE) {
			ele = (WebDriverWait) new WebDriverWait(DriverManager.getWebDriver(), timeout).
					until(ExpectedConditions.visibilityOfAllElements(element));
	}
		return element; 
		}
  
}
