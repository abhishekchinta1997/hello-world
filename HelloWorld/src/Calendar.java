import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		
		//click on FEB 20, 2022
		WebElement datePicker = driver.findElement(By.xpath("//input[@id='travel_date']"));
		datePicker.click();
		
		//click on next to get required month
		WebElement calendarMonthTitle = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"));
		WebElement calendarNextButton = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']"));
		while(!calendarMonthTitle.getText().contains("Apr"))
		{
			calendarNextButton.click();
		}		
		//take all the dates with the class name into a list
		List<WebElement> datesList = driver.findElements(By.className("day"));
		//grab the common attribute
		//put it into list and iterate
		
		int count = datesList.size();
		for(int i=0; i<count; i++)
		{
			String dateText = driver.findElements(By.className("day")).get(i).getText();
			if(dateText.equalsIgnoreCase("20"))
			{
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
		//to pick values from input tag
		//we have to use the getAttribute() method.
		//Then the value is passed as a parameter to the method
		String datePicked = datePicker.getAttribute("value");
		System.out.println("Date Picked: "+datePicked);
	}
}
