package openBrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFrame 
{
	public static WebDriver driver;
	
	By iframelink = By.xpath("//li[@id='iFrame']");
	By toggler = By.xpath("//div[@id='mobile_menu_toggler']");
	By homelink = By.xpath("(//a[contains(.,'Home')])[2]");
	//By scrolluptoelement = By.xpath("//h4[normalize-space()='End to End QA Solution']");
	
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
	}
	
	public void clickIFrame()
	{
		driver.findElement(iframelink).click();
	}
	
	public void clickHome()
	{
		driver.findElement(homelink).click();
	}
	
	public void test1() throws Throwable
	{
		driver.switchTo().frame("globalSqa");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toggler));
		Thread.sleep(5000);
		//driver.switchTo().frame(0);
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='globalSqa']")));
		driver.findElement(toggler).click();
		Thread.sleep(5000);
		clickHome();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
	}
	
	public static void main(String[] args) throws Throwable 
	{
		IFrame iframe = new IFrame();
		iframe.launchApp();
		iframe.clickIFrame();
		iframe.test1();
	}
}