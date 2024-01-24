package openBrowser;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class saucedemo 
{
    public static WebDriver driver;
    
    By username = By.xpath("//input[@id='user-name']");
    By password = By.xpath("//input[@id='password']");
    By loginbtn = By.xpath("//input[@id='login-button']");
    By errormessage = By.xpath("//h3");
    By openmenu = By.xpath("//button[normalize-space()='Open Menu']");
    By weblinks = By.xpath("//nav/a");
    By closebtn = By.xpath("//button[contains(normalize-space(),'Close Menu')]");
    By filterdropdown = By.xpath("//select[@class='product_sort_container']");
    By carticon = By.xpath("//a[@class='shopping_cart_link']");
    By continueshopping = By.xpath("//button[@id='continue-shopping']");
    By addtocartoption = By.xpath("//div[@class='inventory_list']/div/div[2]/div[2]/button");
    By homePageAmt = By.xpath("//div[@class='inventory_list']/div/div[2]/div[2]/div");
    By cartPageAmt = By.xpath("//div[@class='inventory_item_price']");
    //By logout = By.xpath("//a[@id='logout_sidebar_link']");
	
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	public void enterUsername(String uname)
    {
    	driver.findElement(username).sendKeys(uname);
    }
    public void enterPassword(String pwd)
    {
    	driver.findElement(password).sendKeys(pwd);
    }
    public void clickLoginButton()
    {
    	driver.findElement(loginbtn).click();
    }
    
    public void login(String uname, String pwd)
    {
    	enterUsername(uname);
    	enterPassword(pwd);
    	clickLoginButton();
    }
    
    public void verifyHomePage()
    {
    	Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com/inventory.html"),
    			"user not logged in successful");
    }
    
    public String errorMessage()
	{
		Assert.assertTrue(driver.findElement(errormessage).isDisplayed(), "Error message not displayed");
		String act_message = driver.findElement(errormessage).getText();
		return act_message;
	}
    
    public void expandBtn()
    {
    	driver.findElement(openmenu).click();
    }
    
    public void verifyLinksAvaliable()
    {
    	List<WebElement> links = driver.findElements(weblinks);
    	for(int i=0; i<links.size(); i++)
    	{
    		Assert.assertTrue(links.get(i).isDisplayed(), "No links are displayed");
    		//System.out.println(links.get(i).getText());
    	}
    }
    
    public void crossBtn()
    {
    	driver.findElement(closebtn).click();
    }
    
    public void clickFilterDropDown()
    {
    	driver.findElement(filterdropdown).click();
    }
    
    public void verifyFilterDropDownOptions1()
    {
    	Select dropdown = new Select(driver.findElement(filterdropdown));
    	List<WebElement> options = dropdown.getOptions();
    	//System.out.println(options.size());
    	//List<WebElement> filteroptions = driver.findElements(filterdropdown);
    	//System.out.println(filteroptions.);
    	//System.out.println(filteroptions.get(0).getText());
		//options.get(0).click();
    	for(int i=0; i<options.size(); i++)
    	{
    		Assert.assertTrue(options.get(i).isDisplayed(), "No options displayed");
    		//System.out.println(options.get(i).getText());
    	}
    }
    
    public void verifyFilterDropDownOptions()
    {
    	String[] expectedoptions = new String[] 
    			{"Name (A to Z)","Name (Z to A)","Price (low to high)","Price (high to low)"};
    	
    	Select dropdown = new Select(driver.findElement(filterdropdown));
    	List<WebElement> optionslist = dropdown.getOptions();
    	System.out.println(optionslist.size());
    	ArrayList<String> actualoptions = new ArrayList<String>();
    	
    	for(int i=0; i<optionslist.size(); i++)
    	{
    		actualoptions.add(optionslist.get(i).getText());
    		//System.out.println(optionslist.get(i).getText());
    	}
    	
  	    if(expectedoptions.length == actualoptions.size())
  	    {

  	    	for(int i=0; i<optionslist.size(); i++)
  	    	{
  	    		System.out.println(expectedoptions[i]);
  	    		System.out.println(actualoptions.get(i).trim());
  	    		if(!expectedoptions[i].trim().equals(actualoptions.get(i).trim()))
  	    		{
  	    			System.out.println("expected options are not matching with actual options.");
  	    			break;
  	    		}
  	    		
  	    		if(i==optionslist.size()-1)
  	    		{
  	    			System.out.println("Expected and actual options are matching.");
  	    		}
  	    	}
  	    }
    }
    
    public void clickOnCartIcon()
    {
    	driver.findElement(carticon).click();
    }
    
    public void verifyCartPage()
    {
    	Assert.assertTrue(driver.getCurrentUrl().contains("cart"),"Not navigated to cart page");
    }
    
    public void clickContinueShoppingBtn()
    {
    	driver.findElement(continueshopping).click();
    }
    
    public void clickAddToCartBtn()
    {
    	driver.findElement(addtocartoption).click();
    }
    
    public void verifyAddToCartBtn()
    {
    	List<WebElement> addToCartBtns = driver.findElements(addtocartoption);
    	for(WebElement addToCartBtn : addToCartBtns)
    	{
    		Assert.assertTrue(addToCartBtn.isDisplayed(), "Add to cart button not found");
    	}
    }
    
    public void homePageAmount()
    {
    	String amt1 = driver.findElement(homePageAmt).getText();
    }
    
    public void cartPagrPageAmount()
    {
    	String amt2 = driver.findElement(cartPageAmt).getText();
    }
    
    public void compareAmt()
    {
    	//Assert.assertEquals(homePageAmount(), cartPagrPageAmount(),"Amounts are not same");
    }
    
    /*public void clickLogOut()
	{
		driver.findElement(logout).click();
	}*/
	
	public void Test1() throws Throwable
	{
		login("standard_user", "secret_sauce");
		verifyHomePage();
		Thread.sleep(2000);
	}
	
	public void Test2()
	{
		login("", "");
		Assert.assertEquals(errorMessage(),"Epic sadface: Username is required","Error message is different");
	}
	
	public void Test3()
	{
		login("standard_user", "");
		Assert.assertEquals(errorMessage(),"Epic sadface: Password is required","Error message is different");
	}
	
	public void Test4()
	{
		login("", "secret_sauce");
		Assert.assertEquals(errorMessage(),"Epic sadface: Username is required","Error message is different");
	}
	
	public void Test5() throws Throwable
	{
		expandBtn();
		verifyLinksAvaliable();
		Thread.sleep(2000);
		crossBtn();
	}
	
	public void Test6() throws Throwable
	{
		login("standard_user", "secret_sauce");
		//clickFilterDropDown();
		verifyFilterDropDownOptions();
		Thread.sleep(2000);
		clickFilterDropDown();
	}
	
	public void Test7() throws Throwable
	{
		clickOnCartIcon();
		Thread.sleep(2000);
		verifyCartPage();
	}
	
	public void Test8() throws Throwable
	{
		Test7();
		clickContinueShoppingBtn();
		verifyHomePage();
	}
	
	public void Test9() throws Throwable
	{
		//clickAddToCartBtn();
		//Thread.sleep(2000);
		verifyAddToCartBtn();
	}
	
	public void Test12() throws Throwable
	{
		Test9();
		clickAddToCartBtn();
		compareAmt();
	}
	
	public static void main(String[] args) throws Throwable 
	{
        saucedemo sd = new saucedemo();
        sd.launchApp();
        sd.login("standard_user", "secret_sauce");
        //sd.Test1();
        //sd.Test2();
        //sd.Test3();
        //sd.Test4();
        //sd.Test5();
        //sd.Test6();
        //sd.Test9();
        //sd.Test12();
        //sd.Test7();
        //sd.Test8();
        //sd.driver.quit();
        sd.addorremovebutton();
	}
	
	public void addorremovebutton()
	{
		WebElement btnAdd = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		String currentbuttontext = btnAdd.getText();
		System.out.println("Current text before clicking on the button is : "+ currentbuttontext);
		
		btnAdd.click();
		WebElement btnRemove = driver.findElement(By.id("remove-sauce-labs-backpack"));
		currentbuttontext = btnRemove.getText();
		System.out.println("Current text after clicking on the button is : "+ currentbuttontext);
	}
	
	

}
