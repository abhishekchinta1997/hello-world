import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize the screen
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		//know how many browser windows or tabs opened by selenium
		//create object for this
		Set<String> windowTabs = driver.getWindowHandles(); //parent tab, child tab
		Iterator<String> it = windowTabs.iterator();	// Iterator helps us to move from one tab to another
		String parentID = it.next();
		String childID = it.next();
		
		//navigate to child tab
		driver.switchTo().window(childID);
		
		//String txt = driver.findElement(By.xpath("//div/p/strong/a")).getText();
		//select text what we required
		String txt = driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(txt);
		
		//extract email id from the sentence
		String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(emailID);
		
		//again navigate to parent tab
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(emailID);
		
		
		

	}

}
