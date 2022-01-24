import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class StaticDropDowns {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "D:\\Udemy\\Selenium\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//CURRENCY
		//dropdown with select tag
		//create new obj Select
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropDown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//PASSENGERS
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		//click 5 adults
		int i = 1;
		while(i<3)// clicking 2 times for 3 adults
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		for(i=1;i<3;i++) //clicking 2 times for 2 children
		{
			driver.findElement(By.id("hrefIncChd")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult, 2 Child");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
