package openBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Naukri_Test 
{
    public static WebDriver driver;
    
    public static void launchApp()
    {
    	driver = new ChromeDriver();
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    	driver.get("https://www.naukri.com/");
    }
    
    public static void enterSkill(String skill)
	{
		driver.findElement(By.xpath("//input[contains(@placeholder,'Enter skills / designations / companies')]"))
			.sendKeys(skill);
	}
	
	public static void selectSkill(String inputtext, String selectedtext) throws Exception
	{
		enterSkill(inputtext);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='"+selectedtext+"']")).click();
	}
	
		
	public static void enterExp(String exp)
	{
		driver.findElement(By.id("expereinceDD")).click();
		driver.findElement(By.xpath("//span[text()='" +exp+ "']")).click();
	}
	
	public static void enterCity(String city)
	{
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(city);
	}
	
	public static void selectCity(String inputtext, String selectcity) throws Exception
	{
		enterCity(inputtext);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='"+selectcity+"']"));
	}
	
	public static void clickSearch()
	{
		driver.findElement(By.xpath("//div[text()='Search']")).click();	
	}
	
	public static void test1()
	{
		launchApp();
		enterSkill("Testing");
		enterExp("3 years");
		enterCity("Hyderabad");
		clickSearch();
	}
	
	public static void test2() throws Exception
	{
		launchApp();
		selectSkill("Testing","Testing ETL");
		enterExp("3 years");
		enterCity("Hyderabad");
		clickSearch();
	}
	
	public static void test3() throws Exception
	{
		launchApp();
		selectSkill("Testing","Testing ETL");
		enterExp("7 years");
		selectCity("b","Bengaluru");
		clickSearch();
	}
	
	public static void main(String[] args) throws Throwable 
	{
		//test1();
		//test2();
		test3();
		Thread.sleep(5000);
		driver.quit();
	}
}
