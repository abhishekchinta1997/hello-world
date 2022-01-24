import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicDropDowns2 {

	public static void main(String[] args) throws InterruptedException {
		
		//WITHOUT USING XPATH INDEXES
		//USING XPATH - PARENT to CHILD TRAVERSE
		
		System.setProperty("webdriver.gecko.driver", "D:\\Udemy\\Selenium\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']")).click();
		
		//driver.findElement(By.xpath("//a[@value='MAA']")).click();//selects Chennai in From field
		System.out.println("From: "+driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']")).getText());
		
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();//selects Banglore in To field
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
		System.out.println("From: "+driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).getText());

	}

}
