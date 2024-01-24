package test_page;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class orangehrm 
{
    public static WebDriver driver;
    public static Actions ac;
    
    //get current date time with Date()
    Date date = new Date();
    
    // Create object of SimpleDateFormat class and decide the format
    DateFormat dateFormat = new SimpleDateFormat("dd");
    
    // Now format the date
    String date1= dateFormat.format(date);

    By username = By.xpath("//input[@id='txtUsername']");
    By password = By.xpath("//input[@id='txtPassword']");
    By loginbtn = By.xpath("//input[@id='btnLogin']");
    By leave = By.xpath("//b[normalize-space()='Leave']");
    By fromcalldate = By.xpath("//input[@id='calFromDate']");
    By fromdate = By.xpath("//a[normalize-space()='1']");
    //By frommonth = By.xpath("//select[@class='ui-datepicker-month']");
    By tocalldate = By.xpath("//input[@id='calToDate']");
    By currentdate = By.xpath("//a[normalize-space()='"+date1+"']");
    By btncheckbox = By.xpath("//div/label[1]");
    By btnsearch = By.xpath("//input[@id='btnSearch']");
    By tableRow = By.xpath("//table/tbody[1]/tr[1]/td");
    By pim = By.xpath("//b[normalize-space()='PIM']");
    By addemployee = By.xpath("//a[@id='menu_pim_addEmployee']");
    By firstname = By.xpath("//input[@id='firstName']");
    By lastname = By.xpath("//input[@id='lastName']");
    By employeeid = By.xpath("//input[@id='employeeId']");
    By photoupload = By.xpath("//input[@id='photofile']");
    By checkbox = By.xpath("//input[@id='chkLogin']");
    By uname = By.xpath("//input[@id='user_name']");
    By pwd = By.xpath("//input[@id='user_password']");
    By repwd = By.xpath("//input[@id='re_password']");
    By status = By.xpath("//select[@id='status']");
    By btnsave = By.xpath("//input[@id='btnSave']");
    //By gender = By.xpath("//li[@class='radio']");
    //By gendermale = By.xpath("//input[@id='personal_optGender_1']");
    By genderfemale = By.xpath("//input[@id='personal_optGender_2']");
    //By btnedit = By.xpath("//input[@id='btnSave']");
    By admin = By.xpath("//b[normalize-space()='Admin']");
    By qualifications = By.xpath("//a[@id='menu_admin_Qualifications']");
    By newskill = By.xpath("//a[@id='menu_admin_viewSkills']");
    By requiredfield = By.xpath("//em/parent::*");
    By helpicon = By.xpath("//a[@class='help-icon-div']");
    By faq = By.xpath("//div[@class='container']//section[@class='categories blocks']//li[4]/a");
    //By h2 = By.xpath("//h2");
    By text = By.xpath("//ul[@class='article-list']");
    By checkbox1 = By.xpath("//input[@type='checkbox']");
    //By text2 = By.xpath("//h1");
    //By userpersonalpage = By.xpath("//h1[contains(.,'Sania Demo')]");
    
    //By welcome = By.xpath("//a[@id='welcome']");
    //By logout = By.xpath("//div/ul/li/a[contains(.,'Logout')]");
    
    public void launchApp()
    {
    	driver = new ChromeDriver();
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    	driver.get("http://www.orangehrm.qedgetech.com/");
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
    
    public void clickLeaveOption()
    {
    	driver.findElement(leave).click();
    }
    
    public void selectFromDate()
    {
    	driver.findElement(fromcalldate).click();
    	driver.findElement(fromdate).click();
    }
    
    public void selectToDate()
    {
    	driver.findElement(tocalldate).click();
    	driver.findElement(currentdate).click();
    }
    
    public void selectCheckBox()
    {
    	driver.findElement(btncheckbox).click();
    }
    
    public void clickSearchBtn()
    {
    	driver.findElement(btnsearch).click();
    }
    
    public void validateTable() throws Throwable
    {
    	WebElement element = driver.findElement(tableRow);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	Thread.sleep(500); 
    	Assert.assertEquals(driver.findElement(tableRow).getText(), "No Records Found", 
    		"Records are Present");
    }
    
    public void clickPim()
    {
    	WebElement elementToHover = driver.findElement(pim);
    	ac = new Actions(driver);
    	ac.moveToElement(elementToHover).perform();
    	driver.findElement(addemployee).click();
    }
    
    public void enterDetails(String fname,String lname)
    {
    	driver.findElement(firstname).sendKeys(fname);
    	driver.findElement(lastname).sendKeys(lname);
    }
    
    public void uploadPhoto()
    {
    	WebElement uploadElement = driver.findElement(photoupload);
    	uploadElement.sendKeys("C:/download.png");
    }
    
    public void checkCheckBox()
    {
    	driver.findElement(checkbox).click();
    }
    
    public void employeeLoginDetails(String euname,String epwd,String cpwd)
    {
    	driver.findElement(uname).sendKeys(euname);
    	driver.findElement(pwd).sendKeys(epwd);
    	driver.findElement(repwd).sendKeys(cpwd);
    }
    
    public void selectStatus()
    {
    	WebElement ele = driver.findElement(status);
    	Select dropdown = new Select(ele);
    	dropdown.selectByIndex(0);
    }
    
    public void saveBtn()
    {
    	driver.findElement(btnsave).click();
    }
    
   /* public void clickGenderMale()
    {
    	driver.findElement().click();
    }*/
    
    public void addEmployee() throws Throwable
    {
    	/*enterDetails("Jisoo", "Demo");
    	uploadPhoto();
    	checkCheckBox();
    	employeeLoginDetails("Jisoo", "JisooDemo@_123", "JisooDemo@_123");
    	selectStatus();
    	WebElement saveoption = driver.findElement(btnsave);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveoption);
    	Thread.sleep(500);
    	saveBtn();*/
    	checkCheckBox();
    	List<WebElement> star = driver.findElements(requiredfield);
    	/*for(WebElement mandatoryfield : star)
    	{
    		if(!mandatoryfield.getText().contains("Required field"))
    		{
    			System.out.println(mandatoryfield.getText().replace("*", "").trim());
    		}
    		
    	}*/
    	//String mandatoryfields = driver.findElement(requiredfield).getText();
    	for(int i=0; i<star.size(); i++)
    	{
    		if(!star.get(i).getText().contains("Required field"))
    		{
    			System.out.println(star.get(i).getText().replace("*", "").trim());
    		}
    	}
    }
    
    public void editPersonalDetails()
    {
    	saveBtn();
    	driver.findElement(genderfemale).click();
    	saveBtn();
    	//Assert.assertEquals(driver.findElement(userpersonalpage).getText(), euname+" Demo","Other users page");
    }
    
    public void adminModule()
    {
    	WebElement adminToHover = driver.findElement(admin);
    	WebElement qualificationToHover = driver.findElement(qualifications);
    	ac = new Actions(driver);
    	ac.moveToElement(adminToHover).perform();
    	ac.moveToElement(qualificationToHover).perform();
    	driver.findElement(newskill).click();
    }
    
    public void clickHelpIcon() throws Throwable
    {
    	driver.findElement(helpicon).click();
    	ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    	driver.switchTo().window(tabs.get(1));
    	driver.findElement(faq).click();
    	
    	//System.out.println(driver.findElement(text2).getText());
    	driver.switchTo().frame(driver.findElement(By.id("cf-chl-widget-vom1r")));
    	
    	
    	Thread.sleep(10000);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(x -> driver.findElement(checkbox1).isDisplayed());
    	
    	driver.findElement(checkbox1).click();
    	
    	//WebDriverWait wait = new WebDriverWait(driver, (long)(Duration.ofSeconds(3));
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox1));
    	
    	
    	//WebDriverWait wait = new WebDriverWait(driver, Timeouts.class.wait("3000"));
    	System.out.println(driver.findElement(text).getText());
    }
    
    /*public void clickLogOut()
    {
    	driver.findElement(welcome).click();
    	//WebElement element = driver.findElement(logout);
    	//WebDriverWait wait = new WebDriverWait(driver, 10); 
    	//WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        //element1.click();
    	driver.findElement(logout).click();
    }*/
    
	public static void main(String[] args) throws Throwable
	{
		orangehrm oh = new orangehrm();
		oh.launchApp();
		oh.login("Admin", "Qedge123!@#");
		oh.clickHelpIcon();
		//oh.clickLeaveOption();
		//oh.selectFromDate();
		//oh.selectToDate();
		//oh.selectCheckBox();
		//oh.clickSearchBtn();
		//oh.validateTable();
		//oh.clickPim();
		//oh.addEmployee();
		//oh.editPersonalDetails();
		//oh.adminModule();
		//oh.clickLogOut();
	}

}