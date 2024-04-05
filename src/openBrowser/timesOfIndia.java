package openBrowser;

import java.awt.Window;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class timesOfIndia 
{

	public static WebDriver driver;
	public static Window winname;
	
	public static void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://timesofindia.indiatimes.com/");
	}
	
	public static void ClickOnCity(String cityname)
	{
		WebElement element = driver.findElement(By.xpath("//a[starts-with(text(),'City')]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[contains(text(),'"+cityname+"')]")).click();

	}
	
	public static void SwithToNewWindow()
	{
		Set<String> allwindows = driver.getWindowHandles();
		driver.switchTo().window(allwindows.toArray()[1].toString());
	}
		
	public static void mouseHover()
	{
		String currentwinname = driver.getWindowHandle();
		
		WebElement element = driver.findElement(By.xpath("//a[starts-with(text(),'City')]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[contains(text(),'Hyderabad')]")).click();
		
		Set<String> Allwindows = driver.getWindowHandles();
		
		for(String win : Allwindows)
		{
			if(!win.equals(currentwinname))
			{
				driver.switchTo().window(win);
				break;
			}
		}
	}
	
	public static void validateTitle()
	{
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Hyderabad";
		if(actualTitle.contains(expectedTitle))
		{
			System.out.println("title is matching");
		}
		else
		{
			System.out.println("title not mathcing");
		}
	}
	
	public static void main(String[] args) 
	{
		launchApp();
		//mouseHover();
		ClickOnCity("Hyderabad");
		SwithToNewWindow();
		validateTitle();
	}

}