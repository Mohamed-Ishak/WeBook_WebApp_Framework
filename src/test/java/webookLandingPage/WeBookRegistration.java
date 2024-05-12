package webookLandingPage;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WeBookRegistration {
	
	// create random email
	public String createNewEmail() {
	SimpleDateFormat date = new SimpleDateFormat("HHmms");
	String timeStamp = date.format(new Date());
	String emailPrefix = "example";
	String emailSuffix = "@gmail.com";
	
	return emailPrefix+timeStamp+emailSuffix;
	}
   
	WebDriver driver ;
	JavascriptExecutor js;
	@BeforeTest
	public void openWebBookWebsite() {
		driver  =   new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://webook.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test
	public void createWeBookAccount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//p[contains(text(),'Log In / Sign Up')]"))));
		driver.findElement(By.xpath("//p[contains(text(),'Log In / Sign Up')]")).click();
		driver.findElement(By.xpath("(//form[@id='email-login']//button)[4]")).click();
	    
	}
	
	@Test
	public void fillRegistrationForm() throws InterruptedException {
		driver.findElement(By.cssSelector("[name='first_name']")).sendKeys("test");
		driver.findElement(By.cssSelector("[name='last_name']")).sendKeys("test");
		String email = createNewEmail();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("confirm_email")).sendKeys(createNewEmail());
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("Test@1234");
		driver.findElement(By.cssSelector("[name='country_code']")).click();

		
		js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0, 1000)");
		driver.findElement(By.cssSelector("[name='country_code']")).sendKeys("Egypt");
		driver.findElement(By.xpath("//div[@id='headlessui-portal-root']//li[@data-dial-code='20']")).click();

		driver.findElement(By.cssSelector("[type='tel']")).sendKeys("1091499999");
		driver.findElement(By.cssSelector("[type='checkbox']")).click();
		driver.findElement(By.xpath("//button[@form='signup-form-info']")).click();

	}
	
	

	
	@Test(priority = 2)
	public void checkSearchBarAndFilter() {
		driver.findElement(By.cssSelector("[data-title='Explore']")).click();
		driver.findElement(By.xpath("//div[@id='explore-top-filters']//ul/li[1]")).click();
		js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0, 1000)");
		driver.findElement(By.xpath("//div[@id='explore-top-filters']//ul/li[3]")).click();

	}
	
	
	
//	@AfterTest
//	public void tearDown() {
//		if(driver != null) {
//		  driver.quit();
//		}
//	}
}



