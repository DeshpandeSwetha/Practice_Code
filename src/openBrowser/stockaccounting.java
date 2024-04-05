package openBrowser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class stockaccounting 
{
	public static WebDriver driver;
	
	By username = By.xpath("//input[@id='username']");
	By password = By.xpath("//input[@id='password']");
	By btnlogin = By.xpath("//button[contains(text(),'Login')]");
	By btnlogout = By.xpath("(//a[contains(text(),'Logout')])[3]");
	By btnsupplier = By.xpath("(//a[contains(text(),'Suppliers')])[2]");
	By btnadd = By.xpath("(//span[contains(@data-caption,'Add')])[1]");
	By reqfields = By.xpath("//span[@class='ewRequired']/parent::*");
	By pagesize = By.xpath("(//select)[1]");
	By nextpage = By.xpath("(//span[@class='icon-next ewIcon'])[1]/parent::a");
	By lastpageicon = By.xpath("(//div[@class='input-group-btn'])[3]/preceding::input[1]");
	By btnpurchases = By.xpath("(//a[normalize-space()='Purchases'])[2]");
	By btnpurchasedetails = By.xpath("(//a[normalize-space()='Purchases Detail'])[2]");
	By tooltiptext = By.xpath("//div[@class='ewDetailCount']");
	
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://webapp.qedgetech.com/");
	}
	
	public void enterUsername(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginBtn()
	{
		driver.findElement(btnlogin).click();
	}
	
	public void userLogout()
	{
		driver.findElement(btnlogout).click();
	}
	
	public void clickSupplierLink()
	{
		driver.findElement(btnsupplier).click();
	}
	
	public void clickAddIcon()
	{
		driver.findElement(btnadd).click();
	}
	
	public void clickPageSize()
	{
		//driver.findElement(pagesize).click();
		WebElement dropdown = driver.findElement(pagesize);
		Select drpdown = new Select(dropdown);
		drpdown.selectByIndex(8);
	}
	
	public void identifyRequiredFields()
	{
		List<WebElement> mandatoryfields = driver.findElements(reqfields);
		
		for (WebElement field : mandatoryfields) 
		{
	        System.out.println(field.getText().replace("*", "").trim());
	    }
	}
	
	public void clickPurchaseLink()
	{
		driver.findElement(btnpurchases).click();
	}
	
	public void userLoginPage() throws Exception
	{
		clickLoginBtn();
		//Thread.sleep(2000);
		//clickSupplierLink();
		//clickAddIcon();
		//identifyRequiredFields();
		//clickPageSize();
		//printdetails();
		//clickNextUntilLastPage();
		clickPurchaseLink();
		captureTextInTooltip();
		//userLogout();
	}

	public static void main(String[] args) throws Exception
	{
		stockaccounting sa = new stockaccounting();
		sa.launchApp();
		sa.userLoginPage();
		//rf.clickLogin();
		//Thread.sleep(2000);
		//rf.clickSupplierLink();
	}

	public void printdetails()
	{
		int rowcount = driver.findElements(By.xpath("//table[@id='tbl_a_supplierslist']/tbody/tr")).size();
		
		for(int i=1; i<=rowcount; i++)
		{
			System.out.print(driver.findElement(By.xpath("//table[@id='tbl_a_supplierslist']/tbody/tr["+i+"]/td[6]"))
					.getText()+"  ");
			System.out.print(driver.findElement(By.xpath("//table[@id='tbl_a_supplierslist']/tbody/tr["+i+"]/td[7]"))
					.getText()+"  ");
			System.out.println(driver.findElement(By.xpath("//table[@id='tbl_a_supplierslist']/tbody/tr["+i+"]/td[9]"))
					.getText()+"  ");
		}

	}
	
	public void clickNextUntilLastPage()
	{
		WebElement nextBtn = driver.findElement(nextpage);
		printdetails();
		while(nextBtn.isEnabled())
		{
			try
			{
				nextBtn.click();
				printdetails();
				nextBtn = driver.findElement(nextpage);
			}
			catch(Exception e)
			{
				WebElement lastPage = driver.findElement(lastpageicon);
				System.out.println("Results are in "+lastPage.getAttribute("value")+ " pages");
				break;
			}
			
		}
	
	}
	
	public void captureTextInTooltip() throws InterruptedException
	{
		WebElement element = driver.findElement(btnpurchasedetails);
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
		Thread.sleep(10000);
		
		//WebElement frame=driver.findElement(By.id("ewPreviewLowerPanel"));
	    //driver.switchTo().frame(frame);
		WebElement toolTip = driver.findElement(tooltiptext);
		//ac.moveToElement(toolTip).perform();
		String toolTipText = toolTip.getText();
		System.out.println("toolTipText-->"+toolTipText);
	}
}