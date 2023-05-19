package stepdefinitions;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testrun.BDDTestScreenshot;
import testrun.MyException;

public class Login{
BDDTestScreenshot bts=new BDDTestScreenshot();
WebDriver driver;
	@Given("^On lOGIN PAGE$")
	public void ongiven() throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
		
		driver=new ChromeDriver();

		System.out.println("given");
//		  System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
//			
//			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.demoblaze.com/index.html");
			Thread.sleep(5000);
			bts.takePageScreenshot_onPass(driver, "Demoblaze login page");
			
			//a[text()='Log in']
			driver.findElement(By.xpath("//a[text()='Log in']")).click();
			Thread.sleep(3000);
			//.extentscreenshot(driver, "login page");

			
	}
	

	@When("^valid username is entered$")
	public void validuser() throws Throwable 
	{
		driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("digvijayparab");
		Thread.sleep(1000);
	}
	@And("^valid password is entered$")
	public void validpass() throws Throwable 
	{
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("digvijayparab");
		Thread.sleep(1000);
	}
	@Then("^login should be success$")
	public void loginpass() throws Throwable 
	{
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(3000);
		bts.takePageScreenshot_onPass(driver, "Demoblaze dashboard page");
		//bts.extentscreenshot(driver, "dashboard page");
	}
	
	@And("^add product to cart$")
	public void addsingleproduct() throws Throwable 
	{
		try {
			Thread.sleep(3000);
			Actions act=new Actions(driver);
			act.sendKeys(Keys.ARROW_DOWN);
			act.build().perform();
			act.sendKeys(Keys.ARROW_DOWN);
			act.build().perform();
			Thread.sleep(1000);
			bts.takePageScreenshot_onPass(driver, "Demoblaze Samsung galaxy s6");
			driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
			Thread.sleep(1000);
			
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='Cart']")).click();
			Thread.sleep(5000);
			bts.takePageScreenshot_onPass(driver, "Demoblaze cart page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("unable to add s9");
			
			bts.takePageScreenshot_onFail(driver, "to add prduct to cart");
			throw new MyException();
		}
		//bts.extentscreenshot(driver, "dashboard page");
	}
	@And("^add \"([^\"]*)\" to cart$")
	public void addmultipleproduct(String prodname) throws Throwable 
	{
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN);
		act.build().perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ARROW_DOWN);
		act.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Laptops']")).click();
		Thread.sleep(3000);
		act.sendKeys(Keys.ARROW_DOWN);
		act.build().perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ARROW_DOWN);
		act.build().perform();
		Thread.sleep(1000);
		bts.takePageScreenshot_onPass(driver, prodname);
		driver.findElement(By.xpath("//a[text()='"+prodname+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		Thread.sleep(1000);
		
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Cart']")).click();
		Thread.sleep(5000);
		bts.takePageScreenshot_onPass(driver, "Demoblaze cart page");
		//bts.extentscreenshot(driver, "dashboard page");
	}
	@And("^close browser$")
	public void closebrowser() throws Throwable 
	{
		driver.close();
		
	}
	
	
	
	@After
	public void aftertest()
	{
		System.out.println("after test");
		driver.close();
	}
}
