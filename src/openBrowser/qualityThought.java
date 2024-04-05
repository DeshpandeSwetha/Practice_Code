package openBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class qualityThought 
{

	public static WebDriver driver;
	
	public static void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://qualitythought.in/");
	}
	
	public static void ClickOnServices(String menu,String submenu1,String... submenu2)
	{
		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='"+menu+"']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		WebElement subelements = driver.findElement(By.xpath("//span[text()='"+submenu1+"']"));
		action.moveToElement(subelements).perform();
		
		if(submenu2.length > 0)
		{
			WebElement subelement = driver.findElement(By.xpath("//span[text()='"+submenu2+"']"));
			action.moveToElement(subelement).build().perform();
			subelement.click();
		}
		else
		{
			subelements.click();
		}
		
	}
	
	public static void main(String[] args) 
	{
		launchApp();
		//ClickOnServices("Upcoming Batches","Training Courses","Hyderabad");
		ClickOnServices("Workshops","Snowflake Workshop");
	}

}
