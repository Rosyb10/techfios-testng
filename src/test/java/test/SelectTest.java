package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {

	WebDriver driver;

	@BeforeMethod
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://objectspy.space");
	}

	@Test
	public void selectTest() throws InterruptedException {
		Select select = new Select(driver.findElement(By.id("continents")));
		select.selectByVisibleText("North America");
		// select.selectByIndex(5);
		// select.selectByValue("xyz");
		Thread.sleep(10000);
	}

	@AfterMethod
	public void close() {
		driver.close();
		driver.quit();
	}

}
