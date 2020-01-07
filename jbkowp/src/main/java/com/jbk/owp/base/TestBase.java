package com.jbk.owp.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.jbk.owu.util.PropertyManager;


public  class TestBase {
	public static String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	public static String currentDir = System.getProperty("user.dir");
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extend ;
	public static ExtentTest logger ;
	public static WebDriver  driver;
	public static String browser = PropertyManager.getInstance().getBrowser();
	public static String environment = PropertyManager.getInstance().getEnvironment();
	public static String suite = PropertyManager.getInstance().getSuite();
	public static String qaurl = PropertyManager.getInstance().getQaurl();

	@BeforeSuite
	public static WebDriver setup_Browser(){
		String browserName = browser;
		System.out.println("Started");
		Reporter.log("Test is Starting");
		if (browserName.equalsIgnoreCase("firefox")) {
			String browser_path ="lib/Geckodriver/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", browser_path);
			driver = new FirefoxDriver();
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
		System.out.println("QA URL >>>"+qaurl);
		Reporter.log("=====Application Started ========",true);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	@AfterSuite
	public void CloseApplication(){
		driver.quit();
		Reporter.log("===== Browser Session End  ========",true);
	}	
		//This is my old code
//        String browsername = browser;
//        System.out.println("Started");
//    	Reporter.log("=====Test is Starting========",true);
//		if(browsername.equalsIgnoreCase("firefox")){
//			
//			driver = new FirefoxDriver();
//		} else if (browser.equals("Chrome")) {
//
//			driver=new ChromeDriver();
//		}else{
//			System.out.println("Browser not found ");
//		}
//
//		driver.manage().window().maximize(); // Maximize the window 
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.get(qaurl);
//		System.out.println("QA URL >>>"+qaurl);
//		Reporter.log("=====Application Started ========",true);
//		return driver;		
//	}
	

	//Report Generate 
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/extendReport.html");
		extend = new ExtentReports();
		extend.attachReporter(htmlReporter);
	}
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			logger.fail(MarkupHelper.createLabel(result.getName()+"  Test Case Failed", ExtentColor.RED));
			logger.fail(result.getThrowable());
		}else if (result.getStatus()==ITestResult.SUCCESS){
			logger.pass(MarkupHelper.createLabel(result.getName()+"  Test Case Passed", ExtentColor.GREEN));	
		}else
		{
			logger.skip(MarkupHelper.createLabel(result.getName()+"  Test Case Skiped", ExtentColor.YELLOW));
			logger.skip(result.getThrowable());
		}
	}
	@AfterSuite
	public void tearDown1(){
		extend.flush();

	}   
}

