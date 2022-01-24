import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//links of entire page
		int ct = driver.findElements(By.tagName("a")).size();
		System.out.println("Count of links in entire page : "+ct);
		
		//Limiting Web Driver Scope
		
		//links of footer section of the page
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		int footerCT = footerDriver.findElements(By.tagName("a")).size();
		System.out.println("Count of links in Footer Section : "+footerCT);
		
		//links of first column in footer section
		WebElement coulmnDriver = footerDriver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
		int colCount = coulmnDriver.findElements(By.tagName("a")).size();
		System.out.println("Count of links in first column of Footer Section : "+colCount);
		
		//click on each link in the column and check if the pages are opening in new tab
		for(int i=1; i<colCount; i++)
		{
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			coulmnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(5000L);
		}
		//Get the titles of each tab (child window)
		System.out.println("\\u001B[1m Titles of Tabs :");
		Set<String> windowTabs = driver.getWindowHandles();
		Iterator<String> move = windowTabs.iterator();
		
		while(move.hasNext())
		{
			driver.switchTo().window(move.next());
			System.out.println(driver.getTitle());
		}
	}
}
