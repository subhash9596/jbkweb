package com.jbk.owu.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jbk.owp.base.TestBase;

public class DashboardPagee extends TestBase  {
	
	public DashboardPagee() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a/button")
	private static WebElement add_user_link;

	@FindBy(xpath="//ul[@class=\"sidebar-menu\"]//*[.='MAIN NAVIGATION']")
	private static WebElement main_navigation_text;

	@FindBy(xpath="//ul[@class=\"sidebar-menu\"]//*[.='Dashboard']")
	private static WebElement dashboard_navigation_text;

	@FindBy(xpath="//a[@href='users.html']")
	private static WebElement user_navigation_text;

	@FindBy(xpath="//ul[@class='sidebar-menu']//*[.='Operators']")
	private static WebElement operators_navigation_text;

	@FindBy(xpath="//ul/li/a[contains(@href,\"links.html\")]")
	private static WebElement useful_links_navigation_text;

	@FindBy(xpath="//ul[@class='sidebar-menu']//*[.='Downloads']")
	private static WebElement downloads_navigation_text;

	@FindBy(xpath="//ul[@class=\"sidebar-menu\"]//*[.='Logout']")
	private static WebElement logout_navigation_text;

	@FindBy(xpath="//ul/li/a[@href=\"dashboard.html\"]")
	public static	WebElement dashboard_link;

	@FindBy(xpath="//ul/li/a[@href=\"users.html\"]")
	public static WebElement user_link;

	@FindBy(xpath="//ul/li/a[@href=\"operators.html\"]")
	public static WebElement oprators_link;

	@FindBy(xpath="//ul/li/a[@href=\"links.html\"]")
	public static WebElement useful_links_link;

	@FindBy(xpath="//ul/li/a[@href=\"downloads.html\"]")
	public static WebElement downloads_link;

	@FindBy(xpath="//ul/li/a[@href=\"logout.html\"]")
	public static WebElement logout_link;

	@FindBy(xpath="//*[contains(@class,'logo-lg')]")
	private static WebElement jbk_main_logo_heading;

	@FindBy(xpath="//a[contains(@class,'logo')]")
	private static WebElement jbk_subheading_link;

	@FindBy(xpath="//img")
	private static WebElement user_img;

	@FindBy(xpath="//h1")
	private static WebElement dashboard_main_heading;

	@FindBy(xpath="//strong")
	private static WebElement dashboard_fottor_text;

	@FindBy(xpath="//footer/div[contains(@class,'pull-right hidden-xs')]")
	private static WebElement pullright_fottor_text;

	@FindBy(xpath="//div/h3")
	private static WebElement selenium_course_text;

	@FindBy(xpath="//*[contains(@class,\"inner\")]/p")
	private static WebElement automationtest_text;

	public static WebElement  mainnavigationtext()
	{
		return main_navigation_text;
	}
	public static WebElement  dashboardnavigationtext()
	{
		return dashboard_navigation_text;
	}

	public static WebElement  usernavigationtext()
	{
		return user_navigation_text;
	}

	public static WebElement  operatorsnavigationtext()
	{
		return operators_navigation_text;
	}
	public static WebElement  usefullinksnavigationtext()
	{
		return useful_links_navigation_text;
	}

	public static WebElement  downloadsnavigationtext()
	{
		return downloads_navigation_text;
	}

	public static WebElement  logoutnavigationtext()
	{
		return logout_navigation_text;
	}
	public static String  dashboardnavigationlink()
	{
		return dashboard_link.getAttribute("href");
	}

	public static String  usernavigationlink()
	{
		return user_link.getAttribute("href");
	}

	public static String  operatorsnavigationlink()
	{
		return oprators_link.getAttribute("href");
	}

	public static String  usefullinksnavigationlink()
	{
		return  useful_links_link.getAttribute("href");
	}	

	public static String  downloadsnavigationlink()
	{
		return  downloads_link.getAttribute("href");
	}	

	public static String  logoutnavigationlink()
	{
		return  logout_link.getAttribute("href");
	}	

	public static boolean  usernavigationisdisplayed()
	{
		return user_link.isDisplayed();
	}

	public static boolean  operatorsnavigationisdisplyed()
	{
		return oprators_link.isDisplayed();
	}

	public static boolean  usefullinksnavigationisdisplyed()
	{
		return  useful_links_link.isDisplayed();
	}	

	public static boolean  downloadsnavigationisdisplyed()
	{
		return  downloads_link.isDisplayed();
	}	

	public static boolean  logoutnavigationisdiplyed()
	{
		return  logout_link.isDisplayed();
	}	

	public static String  jbkmainlogoheading()
	{
		return  jbk_main_logo_heading.getText();
	}	

	public static String  jbksubheadinglink()
	{
		return  jbk_subheading_link.getAttribute("href");
	}	
	public static boolean  userimgisdisplyed()
	{
		return  user_img.isDisplayed();
	}	
	public static boolean jbktextlogoisdisplayed()
	{
		return jbk_subheading_link.isDisplayed();
	}
	public static WebElement dashboardmainheading()
	{
		return dashboard_main_heading;
	}
	public static String dashboard_fottor_text()
	{
		return dashboard_fottor_text.getText();

	}

	public static String pullrightfottortext()
	{
		return pullright_fottor_text.getText();
	}

	public static String seleniumcoursetext()
	{
		return selenium_course_text.getText();
	}

	public static String automationtesttext()
	{
		return automationtest_text.getText();
	}
    public static  AddUserPage userpage(){
   	user_navigation_text.click();
   	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	return new AddUserPage();	
    }
    public static UsersPage user(){
       	user_navigation_text.click();
    	return new UsersPage();	
    
    } 
    public static void  UsefulLinkPage (){
    	useful_links_navigation_text.click();
    	//return new UsefulLinkPage();	
    
    } 
}
