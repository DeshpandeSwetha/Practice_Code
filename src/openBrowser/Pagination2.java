package openBrowser;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination2 
{
	public static WebDriver driver;
	
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
	}
	
	public void searchForItem(String Item)
	{
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(Item);
	}
	
	public void clickSearch()
	{
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
	}
	
	List<WebElement> allnames = null;
	ArrayList<String> allproductnames = new ArrayList<String>();
	public void getProductNames()
	{
		allnames = driver.findElements(By.xpath("//ul/li/div/div/a/div/span"));
		ArrayList<String> productnames = new ArrayList<String>();
		
		for(int i=0; i<allnames.size(); i++)
		{
			productnames.add(allnames.get(i).getText());
			//System.out.println((i+1)+". "+allnames.get(i).getText());
		}
		
		allproductnames.addAll(productnames);
		productnames.clear();
	}
	
	public void clickNextUntilLastPage()
	{
		WebElement nextBtn = driver.findElement(By.xpath("//a[@aria-label='Go to next search page']"));
		getProductNames();
		while(nextBtn.isEnabled())
		{
			nextBtn.click();
			getProductNames();
			try
			{
				nextBtn = driver.findElement(By.xpath("//a[@aria-label='Go to next search page']"));
			}
			catch(Exception e)
			{
				WebElement lastPage = driver.findElement(By.xpath("//button[@type='next']/preceding::a[1]"));
				System.out.println("Results are in "+lastPage.getText()+ " pages");
				break;
			}
		}
		System.out.println("Total No. of Products are :"+ allproductnames.size());
		System.out.println("the product names are : ");
		int productcount = allproductnames.size();
		for(int i=0; i<productcount; i++)
		{
			System.out.println((i+1)+". " +allproductnames.get(i));
		}
	}
	
	public String numberOfResults()
	{
		return driver.findElement(By.xpath("//h1/span[1]")).getText();
	}
	
	public static void main(String[] args) 
	{
		Pagination2 pg = new Pagination2();
		pg.launchApp();
		String searchItem = "comic articles";
		pg.searchForItem(searchItem);
		pg.clickSearch();
		pg.clickNextUntilLastPage();
		System.out.println("There are "+pg.numberOfResults()+" results for "+ searchItem);
		pg.getProductNames();
		pg.driver.quit();
	}

}
