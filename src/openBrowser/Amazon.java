package openBrowser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon 
{
	public static WebDriver driver;
	
	public static void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("samsung m20 back cover");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		
	}
	
	public static void getProductNames()
	{
		List<WebElement> allnames =driver.findElements(By.xpath("//h2"));
		//System.out.println("List of products in first page are: "+allnames);
		for(int i=0; i<allnames.size(); i++)
		{
			System.out.println((i+1)+". "+allnames.get(i).getText());
			System.out.println(" ");
		}
	}
	
	
	public static void main(String[] args) throws Exception 
	{
		launchApp();
		getProductNames();
		Thread.sleep(5000);
		driver.quit();
	}

}


