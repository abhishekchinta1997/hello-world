import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize the screen
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		//driver.switchTo().newWindow(WindowType.TAB); ---> opens new tab
		driver.switchTo().newWindow(WindowType.WINDOW); //--->opens new window 
		Set<String> newTab = driver.getWindowHandles();
		Iterator<String> move = newTab.iterator();
		String parentTab = move.next();
		String childTab = move.next();
		driver.switchTo().window(childTab);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		WebElement img = driver.findElement(By.cssSelector("[class='fb_logo _8ilh img']"));
		
		//screenshot
		File file = img.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("C:\\Users\\Abhis\\Desktop\\logo.png"));
		
		//get height and width
		img.getRect().getDimension().getHeight();
		img.getRect().getDimension().getWidth();
		
		driver.switchTo().window(parentTab);
	}

}
