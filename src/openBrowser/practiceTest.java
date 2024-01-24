package openBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.*;

public class practiceTest 
{
	public WebDriver driver;
	
    By username  = By.xpath("//input[@id='username']");
    By password = By.xpath("//input[@id='password']");
    By submit = By.xpath("//button[@id='submit']");
    By logout = By.xpath("//a[normalize-space()='Log out']");
    By errormessage = By.xpath("//div[@id='error']");
	
   
    public void enterUsername(String uname)
    {
    	driver.findElement(username).sendKeys(uname);
    }
    public void enterPassword(String pwd)
    {
    	driver.findElement(password).sendKeys(pwd);
    }
    public void clickButton()
    {
    	driver.findElement(submit).click();
    }
    
    public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
    
    public void login(String uname, String pwd)
    {
    	enterUsername(uname);
    	enterPassword(pwd);
    	clickButton();
    }
   
    public void verifyUrl()
    {
    	Assert.assertTrue(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"),
    			"login not successful");
    }
    
    public void verifyPageContents()
    {
    	String webpageText =driver.getPageSource();
		Assert.assertTrue(webpageText.contains("Congratulations") ||
					webpageText.contains("successfully logged in"),"User is not logged in");
    }
    
    public void verifyLogoutButton()
    {
    	Assert.assertTrue(driver.findElement(logout).isDisplayed(), "Logout button not displayed");
    }
    
    public void clickLogout()
    {
    	driver.findElement(logout).click();
    }
    
    public String errorMessage()
	{
		Assert.assertTrue(driver.findElement(errormessage).isDisplayed(), "Error message not displayed");
		String act_message = driver.findElement(errormessage).getText();
		return act_message;
	}
    
    public void Test1()
    {
    	login("student", "Password123");
    	verifyUrl();
    	verifyPageContents();
    	verifyLogoutButton();	
    }
    
    public void Test2()
	{
		login("incorrectUser", "Password123");
		Assert.assertEquals(errorMessage(),"Your username is invalid!","Error message is different");
	}
    
    public void Test3()
	{
		login("student", "incorrectPassword");
		Assert.assertEquals(errorMessage(),"Your password is invalid!","Error message is different");
	}
    
	public static void main(String[] args) 
	{
		practiceTest pt = new practiceTest();
		pt.launchApp();
		pt.Test1();
		pt.clickLogout();
		pt.Test2();
		pt.Test3();
		pt.driver.quit();
	}
}