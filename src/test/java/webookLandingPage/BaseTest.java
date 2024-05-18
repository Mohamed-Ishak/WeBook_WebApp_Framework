package webookLandingPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class BaseTest {
	// create random email
	private static String emailPrefix = "example";
	private static String emailSuffix = "@gmail.com";
	private static final String email = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(email.length());
            sb.append(email.charAt(index));
        }

        return emailPrefix+sb.toString()+emailSuffix;
    }
		
	   
		WebDriver driver ;
		JavascriptExecutor js;
		
		@Parameters("browser")
		@BeforeTest
		public void openWebBookWebsite(String browser) throws IOException {
			
			
//			Properties prop = new Properties();
//			FileInputStream stream = new FileInputStream(
//					System.getProperty("user.dir") + "//src//test//java//webookLandingPage//globalData.properties");
//			prop.load(stream);
//	        String selectedBrowser = prop.getProperty("browser");

			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			}
			
			
			
			
			driver.manage().window().maximize();
			driver.navigate().to("https://webook.com/");
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}
		
		
		@AfterTest
		public void tearDown() {
			if(driver != null) {
			  driver.quit();
			}
		}
}
