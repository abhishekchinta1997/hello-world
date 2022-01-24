import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize the screen
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		//initiate new Action Object
		Actions a = new Actions(driver);
		
		//Mouse-Hover
		//moves to specific element
		//a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
		WebElement mouseHover = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		a.moveToElement(mouseHover).build().perform();
		
		//right click action
		WebElement mouseHover1 = driver.findElement(By.xpath("//a[@id='nav-orders']"));
		a.moveToElement(mouseHover1).contextClick().build().perform();
		
		//Enter CAP letters in search box
		WebElement enterText = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		a.moveToElement(enterText).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		//Enter CAP letters in search box and Double Click the text
		WebElement enterText1 = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		a.moveToElement(enterText1).click().keyDown(Keys.SHIFT).doubleClick().build().perform();
		
		
		

	}

}
