package openBrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ClickStart 
{
	public static WebDriver driver;
	By btnstart = By.xpath("//button[normalize-space()='Start']");
	By textdisplay = By.xpath("//h4[normalize-space()='Hello World!']");
	
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
	}
	
	public void clickStart()
	{
		driver.findElement(btnstart).click();
	}
	
	public void WaitForTextToBeVisible(WebElement ele, int TimetoWaitinSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimetoWaitinSeconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void textDisplayed()
	{
		WebElement ele = driver.findElement(textdisplay);
		WaitForTextToBeVisible(ele,5);
		Assert.assertTrue(ele.isDisplayed(), "Text not displayed");
	}
	
	public void test1()
	{
		clickStart();
		textDisplayed();
	}
	
	public static void main(String[] args) throws Throwable 
	{
		ClickStart cs = new ClickStart();
		cs.launchApp();
		Thread.sleep(2000);
		cs.test1();
		//cs.driver.quit();
	}
}