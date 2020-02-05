package com.jbk.owp.base;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jbk.owu.util.Configuration;
import com.jbk.owu.util.PropertyManager;
import com.jbk.owu.util.Reports;
import com.jbk.owu.util.Screenshot;
import com.jbk.owu.util.SendEmail;


public  class TestBase {
	public static WebDriver  driver;
	public static Logger logger = LogManager.getLogger(TestBase.class);
	public static String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mmss").format(new Date());
	public static String currentDir = System.getProperty("user.dir");
	Configuration getURL = new Configuration();
	public static String browser = PropertyManager.getInstance().getBrowser();
	public static String environment = PropertyManager.getInstance().getEnvironment();
	public static String suite = PropertyManager.getInstance().getSuite();
	public static String qaurl = PropertyManager.getInstance().getQaurl();
	public static String uaturl = PropertyManager.getInstance().getUaturl();
	public static String projectName = PropertyManager.getInstance().getProject();
	public static String report = PropertyManager.getInstance().getReport();
	public static String screenshot = PropertyManager.getInstance().getScreenshot();
	public static String sendemail=PropertyManager.getInstance().getSendemail();
	@BeforeSuite
	public void Setup(){
		openBrowser();
		Reporter.log("=====Application Started ========",true);
		Screenshot.CreateDirectory(currentDir + "\\" + "Reports");
		Screenshot.CreateDirectory(currentDir + "\\Reports\\" + timeStamp + "_OWPReport");
		Screenshot.CreateDirectory(currentDir + "\\Reports\\" + timeStamp + "_OWPReport\\Screenshots");
		Reports.startReport();
	}
	public static WebDriver openBrowser(){
		String browserName = browser;
		System.out.println("Started");
		logger.info("Testing is Started");
		if (browserName.equalsIgnoreCase("firefox")) {
			String browser_path ="lib/Geckodriver/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", browser_path);
			FirefoxOptions options = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			profile.setPreference("network.proxy.type", 0);
			options.setCapability(FirefoxDriver.PROFILE, profile);
			driver = new FirefoxDriver(options);
		} else if (browserName.equalsIgnoreCase("chrome")) {
			String browser_path ="lib/Chromedriver/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); // open Browser in maximized mode
			options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			options.addArguments("--disable-gpu"); // applicable to windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model
			options.setExperimentalOption("useAutomationExtension", false);
			WebDriver driver = new ChromeDriver(options);
			//driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			String browser_path = currentDir +"/jbkowp/lib/IEDriverServer/3.14/IEDriverServer.exe";
			DesiredCapabilities d = DesiredCapabilities.internetExplorer();
			d.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			d.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			d.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			System.setProperty("webdriver.ie.driver", browser_path);
			driver = new InternetExplorerDriver();
		}
		driver.get(qaurl);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;		
	}
	@AfterSuite
	public void CloseApplication() throws Exception{
		logger.info("Testing is Ended ");
		driver.quit();	
		if(sendemail.equals("Y")){
			SendEmail.execute(projectName+ ".html");
		}
	}	

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if(report.equals("Y")){
			if (result.getStatus() == ITestResult.FAILURE) {
				Reports.test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +" Test Case Failed ", ExtentColor.RED));
				Reports.test.fail(result.getThrowable());
				String screenshotpath=Screenshot.getScreenshot(driver,result.getName());
				Reports.test.addScreenCaptureFromPath(screenshotpath);//add screenshot in report
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				Reports.test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Test Case Passsed",ExtentColor.GREEN));
			} else {
				Reports.test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() +" Test Case Skip ", ExtentColor.ORANGE));
				Reports.test.skip(result.getThrowable());
			}Reports.extent.flush();
		}
	}


	// This method can Redirects or Navigate to particular URL
	public static void get(String url) throws Exception {
		if (url != null) {
			driver.get(url);
		}
	} 
	// This method can get the current URL of application
	public static String getcurrentURL ()  {
		String currentURL = null;
		currentURL = driver.getCurrentUrl();
		return currentURL;
	}
	// This method can Redirects or Navigate to particular URL
	public static void navigate(String url) throws Exception {
		if (url != null) {
			driver.navigate().to(url);
		}
	}

	// This method can click on any web-element
	public static void click(WebElement element) throws Exception {
			if (isDisplayed(element) == true) {
			element.click();
		}
	}
	// Taken 3 parameter, 1st for locator, 2nd string/text, 3rd for show that object
	// text on report
	public static void sendKeys(WebElement element,String str,String object) throws Exception {
		try {
			if (isDisplayed(element) == true) {
				element.sendKeys(str);
				//Reports.passTest(str + " " + object);
			} else {
				//Reports.failTest(object);
			}
		} catch (Exception e) {
			//Reports.failTest(object + e.getMessage());
		}
	}
	public static void javaScriptClear(WebElement element, String object) throws Exception {

		if (isDisplayed(element) == true) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value = '';", element);
		}
		}
	// To Switch to new window
	public static void switchTonewWndow(WebElement element, String object) throws Exception {
			if (isDisplayed(element) == true) {
				// Store the current window handle
				String winHandleBefore = driver.getWindowHandle();
				// Perform the click operation that opens new window
				// Switch to new window opened
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
					//Reports.passTest(object);
				}
			}
	}

	// To verify text is present on screen.

	public static void isTextPresent(WebElement element, String str) throws Exception {
		try {
			if (isDisplayed(element) == true) {

				String ActualResult = element.getText();
				String ExpectedResult = str;

				/*
				 * if(ActualResult.equals(ExpectedResult))
				 * 
				 * { Reports.passTest(object); }
				 */

				int Value = ActualResult.compareTo(ExpectedResult);
				if (Value >= 0) {
					//Reports.passTest(object);
				} else {
					//Reports.failTest(object);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//Reports.failTest(object + e.getMessage());

		}
	}
	// Method to clear the text box value

	public static void clear(WebElement element) throws Exception {
		
			if (isDisplayed(element) == true) {
				element.clear();
			
			}
		
		}

	// Get element text
	public static String getText(WebElement element) throws Exception {
		String text = null;
		text = element.getText();
		return text;
	}

	// Get element value
	public static String getValue(WebElement element, String attribute) throws Exception {
		String value = null;
        value = element.getAttribute(attribute);
		return value;
	}

	// Get element page title
	public static String getTitle() throws Exception {
		String title = null;
	    title = driver.getTitle();
		return title;
	}

	// Mouse over on element
	public static void mouseOver(WebElement element) throws Exception {
		
			if (isDisplayed(element) == true) {
				Actions act = new Actions(driver);
				act.moveToElement(element).build().perform();
		}
	}
	// Double click on element
	public static void contextClick(WebElement element) throws Exception {

			if (isDisplayed(element) == true) {
				Actions act = new Actions(driver);
				act.contextClick(element).build().perform();
				//Reports.passTest(object);
			} 
	}

	// Click And Hold on element
	public static void clickAndHold(WebElement element) throws Exception {
			if (isDisplayed(element) == true) {
				Actions act = new Actions(driver);
				act.clickAndHold(element).build().perform();
			} 
		}
	

	// Drag And Drop the element
	public static void dragAndDrop(WebElement element1, WebElement element2) throws Exception {
			if (isDisplayed(element1) && isDisplayed(element2) == true) {
				Actions act = new Actions(driver);
				act.dragAndDrop(element1, element2).build().perform();
			} 
		}
	

	// Move To Element
	public static void moveToElement(WebElement element) throws Exception {
			if (isDisplayed(element) == true) {
				Actions act = new Actions(driver);
				act.moveToElement(element).build().perform();
		}
	}

	// Move To Element
	public static void javaScriptMoveToElement(WebElement element) throws Exception {
			JavascriptExecutor jse2 = (JavascriptExecutor) driver;
			jse2.executeScript("arguments[0].scrollIntoView()", element);

		}
	
	// Accept Alerts
	public static void acceptAlert() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();	
	}
	// Dismiss Alerts
	public static void dismissAlert() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
	}

	// Select drop down element by Text
	public static void selectByVisibleText(WebElement element, String str) throws Exception {

		if (isDisplayed(element) == true) {
			Select select = new Select(element);
			select.selectByVisibleText(str);
		}
	}

	// Select drop down element by Value
	public static void selectByValue(WebElement element, String str) throws Exception {

		if (isDisplayed(element) == true) {
			Select select = new Select(element);
			select.selectByValue(str);
	
		}
	}

	// Select drop down element by Index
	public static void selectByIndex(WebElement element, int index, String object) throws Exception {

		if (isDisplayed(element) == true) {
			Select select = new Select(element);
			select.selectByIndex(index);
		}
	}
	// Check is element display on web page
	public static boolean isDisplayed(WebElement element) throws Exception {
		boolean visible;
			element.isDisplayed();
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid green'", element);
			visible = true;
			visible = false;
		    return visible;
	}

	// Check is element Enabled on web page
	public static boolean isEnabled(WebElement element) {
		boolean visible;
			element.isEnabled();
			visible = true;
			visible = false;
		    return visible;
	}

	// Check is element Selected on web page
	public static boolean isSelected(WebElement element) {
		boolean visible;
			element.isSelected();
			visible = true;
			visible = false;
		   return visible;
	}

	// Wait for any element for specific seconds
	public static void waitForElement(WebElement element, int sec) throws Exception {
		Thread.sleep(1000);
		for (int second = 0; second <= sec; second++) {
			if (isDisplayed(element) == true) {
				break;
			}
			Thread.sleep(1000);
		}
	}

	public static void waitInvisibilityOf(WebElement element) throws Exception {
		Thread.sleep(1000);
		for (int second = 0; second <= 60; second++

				) {
			if (isDisplayed(element) != true) {
				break;
			}
			Thread.sleep(1000);
		}
	}

}
