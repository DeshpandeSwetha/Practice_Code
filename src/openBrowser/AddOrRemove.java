package openBrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddOrRemove 
{
	public static WebDriver driver;
	By btnAdd = By.xpath("//button[normalize-space()='Add Element']");
	By btnDelete = By.xpath("//button[normalize-space()='Delete']");
	
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
	}
	
	public void WaitForElementToBeVisible(WebElement ele, int TimetoWaitinSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimetoWaitinSeconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void WaitForElementToDisappear(WebElement ele, int TimetoWaitinSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimetoWaitinSeconds));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void clickAddButton()
	{
		driver.findElement(btnAdd).click();
	}
	
	public void clickDeleteButton()
	{
		driver.findElement(btnDelete).click();
	}
	
	public void Test1()
	{
		clickAddButton();
		WebElement ele = driver.findElement(btnDelete);
		WaitForElementToBeVisible(ele,10);
		Assert.assertTrue(ele.isDisplayed(),"Delete button is not visible");
	}
	
	public void Test2()
	{
		clickAddButton();
		WebElement ele = driver.findElement(btnDelete);
		WaitForElementToBeVisible(ele,10);
		clickDeleteButton();
		WaitForElementToDisappear(ele,10);
		try 
		{
			Assert.assertTrue(!driver.findElement(btnDelete).isDisplayed(),"Delete button is still visible");
		} catch (Exception e) 
		{
			
		}
	}
	
	public static void main(String[] args) throws Throwable 
	{
		AddOrRemove ae = new AddOrRemove();
		ae.launchApp();
		Thread.sleep(3000);
		//ae.Test1();
		ae.Test2();
		//ae.verifydeleteBtn();
		//ae.verifyAddBtn();
	}
}