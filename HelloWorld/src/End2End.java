import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class End2End {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Udemy\\Selenium\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		//FROM : HYD
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='HYD']")).click();
		
		Thread.sleep(2000);
		
		//TO : BLR
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
		
		//DEPART DATE CALENDAR
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-hover")).click();
		
		//CHECK RETURN DATE CALENDAR IS DISABLE OR NOT
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			//System.out.println("Disabled");
			Assert.assertTrue(true);
		}
		else
		{
			//System.out.println("Enabled");
			Assert.assertTrue(false);
		}
		
		//CHECKBOX
		driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).click();
		
		//PASSENGERS
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		//click 3 adults
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
		//click done for final passengers
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//Click on Search button
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		

	}

}
