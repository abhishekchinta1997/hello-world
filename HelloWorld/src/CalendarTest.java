import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		
		WebElement dateClick = driver.findElement(By.cssSelector("input[id='onward_cal']"));
		dateClick.click();
		
		while(!driver.findElement(By.xpath("//td[@class='monthTitle']")).getText().contains("Dec"))
		{
			driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
		}
		List<WebElement> dateList = driver.findElements(By.className("day"));
		int count = dateList.size();
		for (int i = 0; i < count; i++)
		{
			String dateText = driver.findElements(By.className("day")).get(i).getText();
			if(dateText.equalsIgnoreCase("15"))
			{
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
		String datePicked = dateClick.getAttribute("value");
		System.out.println("Date Picked: "+datePicked);
	}
}
