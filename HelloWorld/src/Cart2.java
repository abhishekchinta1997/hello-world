import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart2 {
	
	//goto Cart.java for detailed code explanation

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String expectedItemNames[] = {"Cauliflower", "Mushroom"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		addItems(driver,expectedItemNames);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']"))); //explicit wait
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
		//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}
		
	public static void addItems(WebDriver driver, String expectedItemNames[])
	{
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i = 0; i<products.size(); i++)
		{
			String productName[] = products.get(i).getText().split("-");	
			String formatedName = productName[0].trim();				
			List<String> itemNamesList = Arrays.asList(expectedItemNames);	
			if(itemNamesList.contains(formatedName))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==expectedItemNames.length)
				{
					break;
				}
			}
		}

	}

}
