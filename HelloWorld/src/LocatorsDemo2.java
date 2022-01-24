import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorsDemo2 {

	public static void main(String[] args) throws InterruptedException {
		
		String name = "aaa";
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String passWord = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(passWord);		
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
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String pwdArray[] = passwordText.split("'");
		//divide into two parts as array
		//0th index - Please use temporary password
		//1st index - rahulshettyacademy' to Login.
		//String pwdArray2[] = pwdArray[1].split("'"); We can also write as below
		//again divide into two parts as array
		//0th index - rahulshettyacademy
		//1st index -  to Login.
		//now assign that 0th index to a string to extract the text
		String pwd = pwdArray[1].split("'")[0];
		return pwd;
	}
}
