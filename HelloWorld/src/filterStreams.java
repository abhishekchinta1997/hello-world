import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filterStreams {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> list = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		
		List<WebElement> filteredList = list.stream().filter(items->items.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(list.size(), filteredList.size());

	}

}
