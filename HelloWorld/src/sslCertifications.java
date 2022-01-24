import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class sslCertifications {

	public static void main(String[] args) {
		
		//DesiredCapabilities ch = DesiredCapabilities.chrome();
		//ch.acceptInsecureCerts();
		ChromeOptions c = new ChromeOptions();
		//c.merge(ch);
		c.setAcceptInsecureCerts(true);
		c.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		c.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		

	}

}
