import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		String name = "aaa";
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("aaa");
		driver.findElement(By.name("inputPassword")).sendKeys("aaa");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("XYZ");
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("xyz@abc.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("xyz@gmail.com");
		
		//traverse from parent to child tags
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("aaa");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		
		String expectedTitle = "Hello "+name+",";
		String actualTitle = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		
		driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
		
		if(actualTitle.contentEquals(expectedTitle)) 
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		driver.close();
	}
	
	public void getPassword(WebDriver driver) {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		
	}

}
