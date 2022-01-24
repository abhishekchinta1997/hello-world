import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class example {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//to open the website
		//driver.get("https://rahulshettyacademy.com/");
		
		String baseURL = "https://rahulshettyacademy.com/";
		String expectedTitle = "Rahul Shetty Academy";
		String actualTitle = "";
		
		//Launch website in Chrome
		driver.get(baseURL);
		
		//check the title of the page
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
		
		actualTitle = driver.getTitle();
		
		//Compare actual title with expected title
		
		if(actualTitle.contentEquals(expectedTitle)) 
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		driver.close();
	}
}
