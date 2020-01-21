package com.jbk.owp.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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

public  class TestBase {
	public static String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mmss").format(new Date());
	public static String currentDir = System.getProperty("user.dir");
	Configuration getURL = new Configuration();
	public static WebDriver  driver;
	public static String browser = PropertyManager.getInstance().getBrowser();
	public static String environment = PropertyManager.getInstance().getEnvironment();
	public static String suite = PropertyManager.getInstance().getSuite();
	public static String qaurl = PropertyManager.getInstance().getQaurl();
	public static String uaturl = PropertyManager.getInstance().getUaturl();
	public static String projectName = PropertyManager.getInstance().getProject();
	public static String report = PropertyManager.getInstance().getReport();
	public static String screenshot = PropertyManager.getInstance().getScreenshot();
	//public static String report = "Y";
	@BeforeSuite
	public void Setup(){
		openBrowser();
		Reporter.log("=====Application Started ========",true);
		Reports.startReport();
	}
	public static WebDriver openBrowser(){
		String browserName = browser;
		System.out.println("Started");
		Reporter.log("Test is Starting");
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
	public void CloseApplication(){
		driver.quit();
		Reporter.log("===== Browser Session End  ========",true);
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
	//Selenium methods

	// This method can Redirects or Navigate to particular URL
	public static void get(String url) throws Exception {
		try {
			if (url != null) {
				driver.get(url);
			}
		} catch (Exception e) {
			System.out.println("invaid URL pleaes check ");
		}
		}
	
	public static boolean isDisplayed(WebElement element) throws Exception {
		boolean visible;
		try {
			element.isDisplayed();
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid green'", element);
			visible = true;
		} catch (Exception e) {
			visible = false;
		}
		return visible;
	}
	public static void click(WebElement element ) throws Exception{
		if(isDisplayed(element)==true){
			element.click();
		}
		
	}
	}

