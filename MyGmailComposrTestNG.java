package Assignment;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyGmailComposrTestNG {

	private WebDriver driver;

	// WebDriver driver = new ChromeDriver();

	// Driver Initialization and Browser initialization
	@BeforeMethod
	public void InitialSteps() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinay\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://mail.google.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	// gmail Login
	@Test(priority = 1)
	public void LoginSteps() throws InterruptedException {
		driver.findElement(By.id("identifierId")).sendKeys("myowntestingemail01@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		WebElement passwordEnter = driver.findElement(By.xpath("//input[@name='password']"));
		passwordEnter.sendKeys("Hello@123");
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
		Thread.sleep(5000);
	}

	// Sending Mail
	@Test(priority = 2)
	public void composeMail() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		// Enter the sender mail id
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("meghasinghal0408@gmail.com");
		// Enter subject to the mail
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Selenium script");
		// Email Content
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']"))
				.sendKeys("Selenium script to send mail");
		// Attach the full path of file
		driver.findElement(By.xpath("//input[@name='Filedata']")).sendKeys("D:\\SeleniumTest.txt");
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		Thread.sleep(10000);

	}

	// Logging out
	@Test(priority = 3)
	public void LaterSteps() throws InterruptedException {
		driver.findElement(By.xpath("//img[@class='gb_Da gbii']")).click();
		// Click on 'Logout' Button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='gb_71']")).click();
	}

	// Closing the browser
	@AfterMethod
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();

	}

}
