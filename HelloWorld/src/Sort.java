import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sort {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//print list of items in the column
		//converted list to string - method - 2
		List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));	
		List<String> texts = list.stream().map(WebElement::getText).collect(Collectors.toList());
		System.out.println(texts);
		
		//converted list to string - method - 1
		List<WebElement> columnList = driver.findElements(By.xpath("//tr//td[1]"));	
		System.out.println("Original List");
		for(int i = 0 ; i<columnList.size(); i++)
		{
			String text1 = columnList.get(i).getText();
			System.out.println(text1);
		}
		Thread.sleep(3000);
		//steps
		//click on column to sort
		driver.findElement(By.xpath("//tr//th[1]")).click();
		
		//capture list of all the web elements
		List<WebElement> columnList1 = driver.findElements(By.xpath("//tr//td[1]"));
		System.out.println('\n'+"Sorted List");
		for(int i = 0 ; i<columnList1.size(); i++)
		{
			String text1 = columnList1.get(i).getText();
			System.out.println(text1);
		}
		
		
		//we have to iterate through the list to extract text of it into new list - original list - Using Streams
		List<String> originalList = columnList1.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort the list of step 3 - sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
				
		//compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		//scan the name with column with getText - Beans - Print the price of it
		List<String> price;
		do 
		{
			List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s)).collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			
			if(price.size()<1)
			{
				driver.findElement(By.cssSelector(" [aria-label='Next']")).click();
			}
		}while(price.size()<1);
		
	}
	
	private static String getPrice(WebElement s) {
		//tr//td[1]/following-sibling::td[1] - error
		//following-sibling::td[1]  or //table/tbody/tr/td[2]
		String priceValue = s.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
		return priceValue;
	}

}
