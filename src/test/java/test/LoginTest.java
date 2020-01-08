package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BasePage{
	WebDriver driver;
	@BeforeMethod
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://techfios.com/test/billing/?ng=login/");
	}

	@Test(priority = 1)
	public void validlogintotechfios() throws InterruptedException {
		
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

		waitForElement(driver,10 , By.xpath("//h2[contains(text(),'Dashboard')]"));

	}

	@Test(priority = 2)
	public void invalidlogintotechfios() throws InterruptedException {
		
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.id("password")).sendKeys("sssdf");
		driver.findElement(By.name("login")).click();

		By ALERT_MSG_LOCATOR = By.xpath("//div[@class='alert alert-danger fade in']");

		driver.findElement(ALERT_MSG_LOCATOR).isDisplayed();
		waitForElement(driver, 10, ALERT_MSG_LOCATOR);

	}

	@AfterMethod
	public void close() {
		driver.close();
		driver.quit();
	}

	

}
