import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorsDemo3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Udemy\\Selenium\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//Sibling - Child to Parent Traverse
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//traverse sibling to sibling
		// header to div to practice button to login button to signup button
		//header/div/button[1]/following-sibling::button[1]/following-sibling::button[1]
		String loginButton =  driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(loginButton);

	}

}
