import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		
		// using class name
		//driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); 
		
		//size of iframes
		System.out.println("size of iframe: " + driver.findElement(By.tagName("iframe")).getSize());
		
		//count of iframes
		System.out.println("iframe count: " + driver.findElements(By.tagName("iframe")).size());
		
		//using css selector
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']"))); 
		driver.findElement(By.id("draggable")).click();
		
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		//go back to main frame
		driver.switchTo().defaultContent();
		// you can also use - driver.switchTo().parentFrame();

	}

}
