import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		//USING XPATH INDEXES
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='MAA']")).click();//selects Chennai in From field
		System.out.println("From: "+driver.findElement(By.xpath("//a[@value='MAA']")).getText());
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();//selects Banglore in To field
		System.out.println("To: "+driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).getText());
		
		//CALENDAR
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-hover")).click();

	}

}
