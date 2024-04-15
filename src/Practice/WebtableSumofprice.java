package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebtableSumofprice {
	@Test
	public void verifysumofamount() throws InterruptedException {
		
		
		WebDriver driver;
		System.setProperty("webdriver,chrome,driver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		String section = driver.findElement(By.xpath("//legend[contains(text(),'Web Table Fixed header')]")).getText();
		System.out.println(section);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,600)");
		List<WebElement> headers =driver.findElements(By.xpath("//div[@class='tableFixHead']/table/thead/tr/th"));
		for(WebElement header:headers) {
			System.out.println(header.getText());
		}
		int row = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr")).size();
		int column = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr[2]/td")).size();
		System.out.println(row);
		System.out.println(column);
		Thread.sleep(3000);
		
		// by Javscript executor we set the attribute value of the element to expand the webtable by changing the value of height from 190 to 300px
		WebElement element = driver.findElement(By.className("tableFixHead"));
		jse.executeScript("arguments[0].setAttribute('style','height:300px');", element);
		
		Thread.sleep(3000);
		
		int sum=0;
		int amounts=0;;
		for(int i=1;i<=row;i++) {
			String  amount = driver.findElement(By.xpath("//div[@class='tableFixHead']/table/tbody/tr["+i+"]"+"/td[4]")).getText();
			try {
					amounts = Integer.parseInt(amount);
			}catch(NumberFormatException e) {
				System.out.println("not a number");
			}
			
			sum=sum+amounts;
			
		}
		System.out.println(" Total Amount Collected: "+sum); // 296
	}

}
