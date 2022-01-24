import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart {
	
	//Goto Cart2.java for clean code

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String itemNames[] = {"Cauliflower", "Carrot"};
		int j = 0;
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Thread.sleep(3000);
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i = 0; i<products.size(); i++)
		{
			String name[] = products.get(i).getText().split("-");
			//name[0] = Cauliflower
			//name[1] = 1 Kg
			
			String formatedName = name[0].trim(); //removes white spaces either from left or right			
			//format it with actual name
			//actual text we are getting = Cauliflower - 1 Kg
			//we need only = "Cauliflower"
			//check name you extracted is present in array or not
			//convert array to array list for easy search
			//check name you extracted is present in arrayList or not
						
			List<String> itemNamesList = Arrays.asList(itemNames);
			
			//if(name.contains("Cauliflower"))
			if(itemNamesList.contains(formatedName))
			{
				j++;
				//click on add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				//break;
				if(j==itemNames.length)
				{
					break;
				}
			}
		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
		//explicit wait
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

}
