package openBrowser;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class openChromeBrowser 
{
	public static WebDriver driver;
	public static String winname = null;
	
	public static void launchBrowser()
	{
		driver = new ChromeDriver();
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    	driver.get("https://timesofindia.indiatimes.com/");
	}
	
	public static void selectCity()
	{
		winname = driver.getWindowHandle();
		System.out.println(winname);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@aria-label='City']"))).perform();
		//WebElement element = driver.findElement(By.xpath("//a[starts-with(text(),'City')]"));

		//Actions action = new Actions(driver);

		//action.moveToElement(element).perform();

		driver.findElement(By.xpath("//a[contains(text(),'Hyderabad')]")).click();
	}
	
	public static void SwitchToNewWindow()
	{
		Set<String> windows = driver.getWindowHandles();
		System.out.println("number of windows are "+ windows.size());
		
		for(String win : windows)
		{
			System.out.println(win);
			if(win != winname)
			{
				driver.switchTo().window(win);
				break;
			}
		}
	}
	
	
	

	public static void validateTitle()
	{
		
		String expTitle = "Hyderabad";
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		if(pagetitle.contains(expTitle))
		{
			System.out.println("System displayed Hyderabad page");
		}
		else
		{
			System.out.println("System displayed other city page");
		}
	}

	public static void main(String[] args) 
	{
		launchBrowser();
		selectCity();
		SwitchToNewWindow();
		validateTitle();
		//driver.quit();
	}

}
