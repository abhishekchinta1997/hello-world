import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Intro {

	public static void main(String[] args) {

		//Invoking Browser
		//Chrome - ChromeDriver -> Methods
		//ChromeDriver driver = new ChromeDriver();
		
		//WebDriver Methods + Class Methods
		//  ChromeDriver.exe -> Chrome Browser
		//webdriver.chome.driver -> value of the path
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//to open the website
		driver.get("https://rahulshettyacademy.com/");
		
		//check the title of the page
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		

	}

}
