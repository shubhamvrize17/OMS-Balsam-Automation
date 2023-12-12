package utils;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import config.PropertyBuilder;
import constants.Constants;
import drivers.Driver;
import drivers.DriverManager;
import enums.ConfigProperties;
import enums.*;
import enums.WaitLogic;
import factories.ExplicitWaitFactory;

public class BasePage {	  
	/**
	 * Name of the method: click
	 * Description: Method to wait until the element is present and performs mouse-click on the element
	 * Parameters: locator of the element, wait strategy and element name
	 */
	protected void click(By by, WaitLogic waitstrategy, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		try {
			element.click();
		}
		catch(ElementClickInterceptedException e)
		{
			jsClick(by,waitstrategy,elementname);
		}
	} 

	/**
	 * Name of the method: click
	 * Description: Method to performs the click operation
	 * Parameters: locator of the element, wait strategy and element name
	 */
	protected void click(WebElement element, WaitLogic waitstrategy, String elementname) {
		element.click();
	}
	
	/**
	* Name of the method: jsclick
	* Description: Method to wait until the element is present and performs the javascript click operation
	* Parameters: Element to be clicked, wait strategy and element name
	*/
	protected void jsClick(WebElement element, WaitLogic waitstrategy, String elementname) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getWebDriver();
		executor.executeScript("arguments[0].click();", element);
	}


	/**
	 * Name of the method: jsclick
	 * Description: Method to wait until the element is present and performs the javascript click operation
	 * Parameters: locator of the element, wait strategy and element name
	 */
	protected void jsClick(By by, WaitLogic waitstrategy, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getWebDriver();
		executor.executeScript("arguments[0].click();", element);
		
	}

	/**
	 * Name of the method: sendkeys
	 * Description: Method to wait until the element is present and enters the value to the element
	 * Parameters: locator of the element,value to be entered,wait strategy and element name
	 */
	protected void sendKeys(By by, String value, WaitLogic waitstrategy, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		element.sendKeys(value);
		
	}

	/**
	 * Name of the method: getElementByReplaceText
	 * Description: Method to get elements by replacing the text in xpath
	 * Parameters: xpath to be updated and string to be replaced
	 */
	protected By getElementByReplaceText(String xpath, String replaceValue) {

		String xpathUpdated = xpath.replace("${variable}", replaceValue);
		return By.xpath(xpathUpdated);
	}


	/**
	 * Name of the method: isVisible
	 * Description: Method to validate Element is visible or not
	 * Parameters: locator of the element and element name
	 */
	protected boolean isVisible(By by, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		boolean result = true;
		try {
			WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(WaitLogic.VISIBLE, by);
		} catch (ElementNotInteractableException e) {
			result = false;
		}
		return result;
	}
	


	/**
	 * Name of the method: isVisible
	 * Description: Method to validate Element is visible or not within a given time
	 * Parameters: locator of the element,element name and wait Time
	 */
	protected boolean isVisible(By by, String elementname, Duration timeout) {
		boolean result = true;
		try {
			ExplicitWaitFactory.waitexplicitlyforElement(WaitLogic.VISIBLE, by, timeout);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	/**
	 * Name of the method: isClickable
	 * Description: Method to validate element field is able to edit or not -- using clickable
	 * Parameters: locator of the element and element name
	 */
	protected boolean isClickable(By by, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		boolean result = true;
		try {
			ExplicitWaitFactory.waitexplicitlyforElement(WaitLogic.CLICKABLE, by);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	/**
	 * Name of the method: isEnabled
	 * Description: Method to validate element field is able to edit or not -- using isEnabled
	 * Parameters: locator of the element and element name
	 */
	protected boolean isEnabled(By by, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		boolean result = true;
		try {
			WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(WaitLogic.VISIBLE, by);
			if (element.isEnabled()) {
			} else {
				result = false;
			}

		} catch (ElementNotInteractableException e) {
			result = false;
		}
		return result;
	}
	
	/**
	 * Name of the method: isSelected
	 * Description: Method to validate checkbox/radio button is selected or not -- using isSelected
	 * Parameters: locator of the element and element name
	 */
	protected boolean isSelected(By by, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		boolean result = true;
		try {
			WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(WaitLogic.VISIBLE, by);
			if (element.isSelected()) {
			} else {
				result = false;
			}

		} catch (ElementNotInteractableException e) {
			result = false;
		}
		return result;
	}


	/**
	 * Name of the method: WaitForMiliSec
	 * Description: Method to wait until the given wait time
	 * Parameters: wait time
	 */
	public static void WaitForMiliSec(int timeout) {

		try {
			Thread.sleep(timeout);
		} catch (Exception e) {
		}
	}

	/**
	 * Name of the method: isElementPresent
	 * Description: Method to validate that the element is displayed or not
	 * Parameters: locator of the element, wait strategy and element name
	 */
	protected boolean isElementPresent(By by, WaitLogic waitstrategy, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		return element.isDisplayed();
	}

	/**
	 * Name of the method: selectByValueInDropdown
	 * Description: Method to select a value from the dropdown by select by value
	 * Parameters: locator of the element,value to be selected, wait strategy and element name
	 */
	protected void selectByValueInDropdown(By by, String value, WaitLogic waitstrategy, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(getDriverInstance(),by),elementname+" is not visible");
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		Select sel = new Select(element);
		sel.selectByValue(value);		
	}

	/**
	 * Name of the method:selectByVisibleTxtInDropdown
	 * Description: Method to select an option  from the dropdown form Visible Text
	 * Parameters: locator of the element,value to be selected, wait strategy and element name
	 */
	protected void selectByVisibleTxtInDropdown(By by, String textValue, WaitLogic waitstrategy, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(getDriverInstance(),by),elementname+" is not visible");
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		Select sel = new Select(element);
		sel.selectByVisibleText(textValue);		
	}

	
	
	/**
	 * Name of the method: switchTab
	 * Description: Method to switch the tab in the window
	 * Parameters: index of the tab
	 */	
	public void switchTab(int tabIndex) {

		Set<String> windows = DriverManager.getWebDriver().getWindowHandles();
		ArrayList<String> list = new ArrayList<>(windows);
		DriverManager.getWebDriver().switchTo().window(list.get(tabIndex));
	}

	/**
	 * Name of the method: switchToWindow
	 * Description: Method to switch from one window to another window using Window-Handles
	 * Parameters: NA
	 */
	protected void switchToWindow() {
		// It will return the parent window name as a String
		String parent = DriverManager.getWebDriver().getWindowHandle();
		Set<String> set = DriverManager.getWebDriver().getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String child_window = iterator.next();
			if (!parent.equals(child_window)) {
				DriverManager.getWebDriver().switchTo().window(child_window);
				// getDriver().close();
			}

		}
		// switch to the parent window
		DriverManager.getWebDriver().switchTo().window(parent);

	}

	/**
	 * Name of the method: switchToFrame
	 * Description: Method to switch to the frame using frameName or frameId
	 * Parameters: frame name or frame Id
	 */	
	protected void switchToFrame(String framenameOrId) {
		getDriverInstance().switchTo().frame(framenameOrId);
	}

	/**
	 * Name of the method: switchTabUsingWindowString
	 * Description: Method to switch tab using Window handle string
	 * Parameters: Window Handle string
	 */	
	protected void switchTabUsingWindowString(String windowString) {
		getDriverInstance().switchTo().window(windowString);
	}

	/**
	 * Name of the method:  openNewTabAndNavigateToUrl
	 * Description: Method to open new tab and navigate to the given url
	 * Parameters: url to be launched in the new tab
	 */	
	public void  openNewTabAndNavigateToUrl(String url)
	{
		JavascriptExecutor js = (JavascriptExecutor)  getDriverInstance(); 
		js.executeScript("window.open('"+(url)+"')");
		for(String winHandle :  getDriverInstance().getWindowHandles())
		{ 
			switchTabUsingWindowString(winHandle); 
		} 
	}

	/**
	 * Name of the method: downArrow
	 * Description: Method to press the down arrow key and enter key using Robot class
	 * Parameters: NA
	 */
	protected void downArrow() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * Name of the method: clearField
	 * Description: Method to clear the editable field of the element
	 * Parameters: locator of the element, wait strategy and element name
	 */
	protected void clearField(By by, WaitLogic waitstrategy, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		element.clear();

	}

	/**
	 * Name of the method: getStringFromElement
	 * Description: Method to return the text from the element located by the locator
	 * Parameters: locator of the element, wait strategy and element name
	 */
	
	protected String getStringFromElement(By by,WaitLogic waitstrategy, String elementname ) {
		Assert.assertTrue(waitUntilElementTextIsVisible(by,elementname+ " text is not visible"));
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		return element.getText();
	}

	/**
	 * Name of the method: getTextFromElements
	 * Description: Method to return the list of texts from the elements located by the locator
	 * Parameters: locator of the element and wait strategy
	 */
	protected List<String> getTextFromElements(By by, WaitLogic waitstrategy) {
		Assert.assertTrue(waitUntilElementTextIsVisible(by, "Element text is not visible"));
		List<WebElement> elements = ExplicitWaitFactory.waitexplicitlyforElements(waitstrategy, by);
		List<String> texts = new ArrayList<>();
		for(int i=0;i<elements.size();i++) {
			String name = elements.get(i).getText().trim();
			texts.add(name);
		}
		return texts;
	}

	/**
	 * Name of the method: getWebElement
	 * Description: Method to return the element located by the locator
	 * Author:Priyanka
	 * Parameters: locator of the element with formatted string as key
	 */
	protected WebElement getWebElement(By key) {
		WebElement element = DriverManager.getWebDriver().findElement(key);
		 return element;
	}
	
	/**
	* Name of the method: getWebElements
	* Description: Method to return the list of elements located by the locator
	* Author:Priyanka
	* Parameters: locator of the element with formatted string as key
	*/
	protected List<WebElement> getWebElements(By key) {
		List<WebElement> elements = DriverManager.getWebDriver().findElements(key);
		 return elements;
	}

	/**
	 * Name of the method: clickElementByMatchingTextFromElements
	 * Description: Method to perform click operation on the element by matching the text being passed as parameter
	 * Parameters: locator of the element, wait strategy and text to be matched
	 */
	protected void clickElementByMatchingTextFromElements(By by, WaitLogic waitstrategy,String clickText) {
		List<WebElement> elements = ExplicitWaitFactory.waitexplicitlyforElements(waitstrategy, by);
		for(int i=0;i<elements.size();i++) {
			if(elements.get(i).getText().equalsIgnoreCase(clickText)) {
				jsClick(elements.get(i),WaitLogic.CLICKABLE,clickText);
				break;
			}
		}
	}

	/**
	 * Name of the method: getPageTitle
	 * Description: Method returns the page title
	 * Parameters: NA
	 */
	public static String getPageTitle() {
		return DriverManager.getWebDriver().getTitle();
	}


	/**
	 * Name of the method: mouseHoveratElement
	 * Description: Method to perform Mouse-Hover on the element
	 * Parameters: locator of the element, wait strategy and element name
	 */
	
	protected void mouseHoveratElement(By by, WaitLogic waitstrategy, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		Actions actions = new Actions(DriverManager.getWebDriver());
		actions.moveToElement(element).perform();
	}
	
	/**
	 * Name of the method:getCssValueOfElement
	 * Description: To get the css value of the element
	 * Author: Sravya
	 * Parameters: By,waitstrategy,elementname
	 * To do:  NA
	 */
	protected String getCssValueOfElement(By by, String cssAttribute, WaitLogic waitstrategy, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		return element.getCssValue(cssAttribute);

	}

	/**
	 * Name of the method:getHexColorOfElement
	 * Description: To get the hex color of the element
	 * Author: Sravya
	 * Parameters: cssValue
	 * To do:  NA
	 */
	protected String getHexColorOfElement(String cssValue)
	{
		String hexcolor = Color.fromString(cssValue).asHex();
		return hexcolor;

	}



	/**
	 * Name of the method: waitUntilElementIsVisible
	 * Description: Method to check until the element is visible, in a loop for a constant number of times
	 * Author:Rajeena and Vihara
	 * Parameters: driver and locator of the element
	 */
	
	protected boolean waitUntilElementIsVisible(WebDriver driver,By locator) {
		boolean flag=false;
		for(int i=1;i<=Constants.getExplicitWait();i++)
		{
			try {
				if(driver.findElement(locator).isDisplayed()||driver.findElement(locator).isEnabled())
				{
					flag = true;
					break;
				}
			}
			catch(Exception e) {
				WaitForMiliSec(1000);
				System.out.println("Trial "+i+" was not able to find element with "+locator);
			}
		}
		return flag;
	}
	/**
	 * Name of the method: waitUntilElementIsVisible
	 * Description: Method to check until the element is visible, in a loop for a constant number of times
	 * Author:Rajeena and Vihara
	 * Parameters: locator of the element
	 */

	protected boolean waitUntilElementIsVisible(By locator) {
		boolean flag=false;
		for(int i=1;i<=Constants.getExplicitWait();i++)
		{
			try {
				if(getDriverInstance().findElement(locator).isDisplayed()||getDriverInstance().findElement(locator).isEnabled())
				{
					flag = true;
					break;
				}
			}
			catch(Exception e) {
				WaitForMiliSec(1000);
				System.out.println("Trial "+i+" was not able to find element with "+locator);
			}
		}
		return flag;
	}

	/**
	 * Name of the method: waitUntilElementIsInvisible
	 * Description: Method to check until the element is invisible, in a loop for a constant number of times
	 * Author:Rajeena and Vihara
	 * Parameters: driver and locator of the element
	 */
	
	protected boolean waitUntilElementIsInvisible(WebDriver driver,By locator) {
		boolean flag=false;
		for(int i=1;i<=Constants.getExplicitWait();i++)
		{
			try {
				if(!(driver.findElement(locator).isDisplayed())||!(driver.findElement(locator).isEnabled()))
				{
					flag = true;
					break;
				}
				else {
                    WaitForMiliSec(100);
                    System.out.println("Trial "+i+" was able to find element with "+locator);
                }
			}
			catch(Exception e) {
				WaitForMiliSec(1000);
				System.out.println("Trial "+i+" was able to find element with "+locator);
			}
		}
		return flag;
	}

	/**
	 * Name of the method: waitUntilElementIsInvisible
	 * Description: Method to check until the element is invisible, in a loop for a constant number of times
	 * Author:Rajeena and Vihara
	 * Parameters: locator of the element
	 */
	
	protected boolean waitUntilElementIsInvisible(By locator) {
		boolean flag=false;
		for(int i=1;i<=Constants.getExplicitWait();i++)
		{
			try {
				if(!(getDriverInstance().findElement(locator).isDisplayed())||!(getDriverInstance().findElement(locator).isEnabled()))
				{
					flag = true;
					break;
				}
				else {
					WaitForMiliSec(500);
					System.out.println("Trial "+i+" was able to find element with "+locator);
				}
			}
			catch(Exception e) {
				WaitForMiliSec(1000);
				System.out.println("Trial "+i+" was able to find element with "+locator);
			}
		}
		return flag;
	}
	
	/**
	 * Name of the method: waitUntilElementIsInvisible
	 * Description: Method to check until the element is invisible, in a loop for a required number of times
	 * Author:Rajeena
	 * Parameters: locator of the element and time
	 */
	
	protected boolean waitUntilElementIsInvisible(By locator,int timeOut) {
		boolean flag=false;
		for(int i=1;i<=timeOut;i++)
		{
			try {
				if(!(getDriverInstance().findElement(locator).isDisplayed())||!(getDriverInstance().findElement(locator).isEnabled()))
				{
					flag = true;
					break;
				}
				else {
					WaitForMiliSec(100);
					System.out.println("Trial "+i+" was able to find element with "+locator);
				}
			}
			catch(Exception e) {
				WaitForMiliSec(1000);
				System.out.println("Trial "+i+" was able to find element with "+locator);
			}
		}
		return flag;
	}

	/**
	 * Name of the method: scrollToWebElement
	 * Description: Method to scroll to the webElement until element is visible to get the correct screenshot
	 * Author:Priyanka
	 * Parameters: JavaScriptExecutor, locator of the element and waitTime
	 */

	protected void scrollToWebElement(By by, WaitLogic waitstrategy, String elementname) {
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * Name of the method: getDriverInstance()
	 * Description: Method to return WebDriver instance
	 * Author:Rajeena and Vihara
	 * Parameters: NA
	 */
	public WebDriver getDriverInstance() {
		return DriverManager.getWebDriver();
	}


	/**
	 * Name of the method: waitUntilElementIsVisible
	 * Description: Method to check until the element is visible, in a loop for given number of times
	 * Author:Rajeena and Vihara
	 * Parameters: locator of the element and waitTime
	 */
	public boolean waitUntilElementIsVisible(By locator,int waitTime) {
		boolean flag=false;
		for(int i=1;i<=waitTime;i++)
		{
			try {
				if(getDriverInstance().findElement(locator).isDisplayed()||getDriverInstance().findElement(locator).isEnabled())
				{
					flag = true;
					break;
				}
			}
			catch(Exception e) {
				WaitForMiliSec(1000);
				System.out.println("Trial "+i+" was not able to find element with "+locator);
			}
		}
		return flag;
	}
	
	/**
	* Name of the method: isPaddingVisible
	* Description: Method to check if padding returns a value or not. If it returns zero, then no Text is displayed in UI
	* Author:Priyanka
	* Parameters: Locator of the element, WaitTime and Element name
	*/
	protected void isPaddingVisible(By by, WaitLogic waitstrategy, String elementname) {
		
		String paddingValue=getDriverInstance().findElement(by).getCssValue("padding-top");
		if(paddingValue.contains("0px")) {
			Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		}
		else {
			Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is visible");
		}
	}
	
	/**
	* Name of the method: getAttributeValue
	* Description: Method to get the attribute value
	* Author:Priyanka
	* Parameters: Locator of the element and Element name
	*/
	protected String getAttributeValue(By by, String attributeName, String elementname) {
		WebElement element = DriverManager.getWebDriver().findElement(by);
		String attributeValue=element.getAttribute(attributeName).toString();
		return attributeValue;
	}
	/**
	 * Name of the method: navigateToUrl
	 * Description: Method to Navigate to Url
	 * Author:Rajeena and Vihara
	 * Parameters: url to be navigated
	 */
	protected static void navigateToUrl(String url) {
		 DriverManager.getWebDriver().get(url);
	}
	
	/**
	 * Name of the method: alertPopUp
	 * Description: Method to fetch text from alert pop up
	 * Author:Parmeshwar
	 * Parameters: 
	 */
	protected String getTextFromAlertPopUp() {
		String text= getDriverInstance().switchTo().alert().getText();
		return text ;
	}
		
	/**
	 * Name of the method: getCurrentPageUrl
	 * Description: Method to fetch the current page url
	 * Author:Rajeena
	 * Parameters: NA
	 */
	public String getCurrentPageUrl() {
		String currentPageUrl = getDriverInstance().getCurrentUrl();
		return currentPageUrl;
	}


	/**
	 * Name of the method: waitUntilUserIsNavigated
	 * Description: Wait until the navigation happens
	 * Author:Sravya
	 * Parameters: Current page url
	 */
	protected void waitUntilUserIsNavigated(String currentPageUrl) {

		String NavigatedPageUrl = getCurrentPageUrl();
		int timer = 0;
		do {
			WaitForMiliSec(1000);
			timer++;
			NavigatedPageUrl = getCurrentPageUrl();

				} while (currentPageUrl.equalsIgnoreCase(NavigatedPageUrl) && timer <= 10);
	}
	
	/**
	 * Name of the method:waitUntilElementTextIsVisible
	 * Description: Method to check until the elements text is visible, in a loop for a constant number of times
	 * Author:Shrivatsa
	 * Parameters: locator of the element and element name
	 */
	protected boolean waitUntilElementTextIsVisible(By locator,String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),locator),elementname+" is not visible");
		boolean flag=false;
		for(int i=1;i<=Constants.getExplicitWait();i++)
		{
			try {
				String elemetText=getDriverInstance().findElement(locator).getText();
				if(elemetText != null && !elemetText.isEmpty() && !elemetText.trim().isEmpty())
				{
					flag = true;
					break;
				}
				else {
					WaitForMiliSec(100);
				}
			}
			catch(Exception e) {
				WaitForMiliSec(1000);
				System.out.println("Trial "+i+" was not able to find the text present in the element with "+locator);
			}
		}
		return flag;
	
	}	
	/**
	 * Name of the method: navigateToBrowserPreviousPage
	 * Description: Method to navigate back to the previous page by clicking on the browser back button
	 * Author: Priyanka
	 * Parameters: NA
	 */
	public static void navigateToBrowserPreviousPage() {
		 DriverManager.getWebDriver().navigate().back();
		
	}
	
	/**
	 * Name of the method: closeFirstTab
	 * Description: Method that close first tab
	 * Author: Aleksandar
	 * Parameters: NA
	 */
	public BasePage closeFirstTab() {
		switchTab(0);
		DriverManager.getWebDriver().close();
		switchTab(0);
		return this;
	}
	
	/**
	 * Name of the method:waitUntilElementTextIsVisible
	 * Description:Method to check until expected string in the element text is visible, in a loop for a constant number of times
	 * Author: Shrivatsa
	 * Parameters: locator and the expected string 
	 */
	protected boolean waitUntilElementTextIsVisible(By locator,String elementname,String expectedString) {
		Assert.assertTrue(waitUntilElementIsVisible(getDriverInstance(),locator),elementname+" is not visible");
		boolean flag=false;
		for(int i=1;i<=Constants.getExplicitWait();i++)
		{
			try {
				String elemetText=getDriverInstance().findElement(locator).getText();
				if(elemetText != null&&elemetText.contains(expectedString))
				{
					flag = true;
					break;
				}
				else {
					WaitForMiliSec(1000);
				}
			}
			catch(Exception e) {
				WaitForMiliSec(1000);
				System.out.println("Trial "+i+" was not able to find the text present in the element with " +locator);
			}
		}
		return flag;
	}
	
	/**
	 * Name of the method:waitForElementCordinates
	 * Description:Method to check until the X and Y cordinates of the element updates, in a loop for a constant number of times
	 * Author: Shrivatsa
	 * Parameters: Driver and the locator
	 */
	protected boolean waitAndGetElementCordinates(WebDriver driver,By locator) {
		boolean flag=false;
		for(int i=1;i<=Constants.getExplicitWait();i++)
		{	
			try {
				WebElement element = getDriverInstance().findElement(locator);					
				Dimension dimension= element.getSize();
				int width=dimension.getWidth();
				int height=dimension.getHeight();
				if(width>0&&height>0) {
					flag = true;
					break;
				}
				else {
					WaitForMiliSec(1000);
				}
			}
			catch(Exception e) {
				WaitForMiliSec(1000);
				System.out.println("Trail "+i+" was  not able to find element with " + locator);
			}
		}	
						
		return flag;	
	}
	
	/**
	 * Name of the method: WaitAndSelectValueFromDropDown
	 * Description: Method to wait until the values in the DropDown are loaded and select a desired value from it
	 * Author: Shrivatsa
	 * Parameters: NA
	 */
	protected void WaitAndSelectValueFromDropDown(By by, String value, WaitLogic waitstrategy, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(getDriverInstance(),by),elementname+" is not visible");
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		Select select = new Select(element);		
		boolean flag=false;
		for(int i=1;i<=60;i++) {
			List<WebElement> l = select.getOptions();
			if(l.size()>1) {
				flag = true;
				select.selectByValue(value);
				break;		
			}
			else {
				WaitForMiliSec(1000);}
		}
	}
	
	/**
	 * Name of the method: removeSessionStorage
	 * Description: To remove the session Storage
	 * Author: Prasanna
	 * Parameters: NA
	 */
	
	public void removeSessionStorage() {
		
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
		js.executeScript(String.format("window.sessionStorage.clear"));
	}
	
	/**
	 * @MethodName: refreshPage
	 * @Description: To refresh Page
	 * @Author: Prasanna
	 * @Parameters: NA
	 * @ToDo: NA
	 */
	public void refreshPage() {
		getDriverInstance().navigate().refresh();
		
	}
	
	/**
	 * @MethodName: toDeleteCookies
	 * @Description: To delete cookies
	 * @Author: Prasanna
	 * @Parameters: NA
	 * @ToDo: NA
	 */
	public void toDeleteCookies() {
		getDriverInstance().manage().deleteAllCookies();
	}
	
	/**
	 * Name of the method: doubleClickOnElement
	 * Description: Method to perform Double Click
	 * Parameters: locator of the element, wait strategy and element name
	 */
	
	protected void doubleClickOnElement(By by, WaitLogic waitstrategy, String elementname) {
		Assert.assertTrue(waitUntilElementIsVisible(DriverManager.getWebDriver(),by),elementname+" is not visible");
		WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
		Actions actions = new Actions(DriverManager.getWebDriver());
		actions.doubleClick(element).perform();
	}
		
	/**
	 * @MethodName: refreshCurrentBrowserPage
	 * @Description: Method to refresh current page by clicking on the browser Refresh button.
	 * @Author: Parmeshwar
	 * @Parameters: NA
	 * @ToDo: NA
	 */ 
	public void refreshCurrentBrowserPage() {
		try {
			getDriverInstance().navigate().refresh();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	/**
	 * @MethodName: getWindowHandleName
	 * @Description: Method to return the handlename of the Window Handle
	 * @Parameters: NA
	 * @ToDo: NA
	 */
	
	public String getWindowHandleName() {
		String handleName = getDriverInstance().getWindowHandle();
		return handleName;
	}

	/**
	 * @MethodName: waitForFiveSeconds
	 * @Description: To wait for Five seconds, we are hardcoding wait 
	 * @Author: Swathi
	 * @Parameters: NA
	 * @ToDo: NA
	 */
	public void waitForFiveSeconds() {
		WaitForMiliSec(5000);
	} 

	/**
     * Name of the method: waitUntilWebElementIsVisible
     * Description: Method to check until the Webelement is visible, in a loop for given number of times
     * Author:Sreeja And Natasha
     * Parameters: locator of the element and waitTime
     */
	
    public boolean waitUntilWebElementIsVisible(WebElement element,int waitTime) {
        boolean flag=false;
        for(int i=1;i<=waitTime;i++)
        {
            try {
                if(element.isDisplayed())
                {
                    flag = true;
                    break;
                }
            }
            catch(Exception e) {
                WaitForMiliSec(1000);
                System.out.println("Trial "+i+" was not able to find element with "+element);
            }
        }
        return flag;
    }
        
    /**
     * Name of the method: webElementsIsVisible
     * Description: Method to validate WebElement is visible or not within a given time
     * Author:Sreeja And Natasha
     * Parameters: element,element name and wait Time
     */
    
  protected boolean webElementIsVisible(WebElement element, String elementname) {
  boolean result = true;
  try {
	  ExplicitWaitFactory.waitexplicitlyforWebElement(WaitLogic.PRESENCE, element, Duration.ofSeconds(Constants.getLongwait()));
  } catch (Exception e) {
      result = false;
  }
  return result;
}
 
    /**
	 * Name of the method: switchToFrame
	 * Description: Method to switch to the frame using iframe
	 * Parameters: iframe 
	 * Author: Natasha
	 */	

	protected void switchToFrame(By iframe) {
		WebElement frameElement = getDriverInstance().findElement(iframe);
		getDriverInstance().switchTo().frame(frameElement);
	}	
	
	 /**
     * Name of the getSelectedOptionFromDropdown
     * Description: Method to get the selected option  from the dropdown 
     * Parameters: locator of the element, wait strategy and element name
     * @return 
     */
    protected String getSelectedOptionFromDropdown(By by, WaitLogic waitstrategy, String elementname) {
        Assert.assertTrue(waitUntilElementIsVisible(getDriverInstance(),by),elementname+" is not visible");
        WebElement element = ExplicitWaitFactory.waitexplicitlyforElement(waitstrategy, by);
        Select sel = new Select(element);
        WebElement SelectedOption = sel.getFirstSelectedOption();    
        String text = SelectedOption.getText();
        return text;
    }
    
    /**
     * Name of the launchBrowser
     * Description: Method to launch the browser
     * Parameters: NA
     * @return 
     */
    public void launchBrowser() {
    	Driver.initDriver();
    }
    
    /**
     * Name of the closeBrowser
     * Description: Method to close the browser
     * Parameters: NA
     * @return 
     */
    public void closeBrowser() {
		Driver.quitDriver();
    }
    
    
}
