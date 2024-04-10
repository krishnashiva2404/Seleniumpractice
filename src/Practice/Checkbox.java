package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Checkbox {
	
	
	@Test
	public void verifycheckbox() throws InterruptedException
	{
		WebDriver driver;
		System.setProperty("webdriver,chrome,driver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		String section = driver.findElement(By.xpath("//legend[contains(text(),'Checkbox Example')]")).toString();
		System.out.println(section);
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label"));
		int i=3;
		while(i>0) {
			
				driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label["+i+"]"+"/input")).click();
				i--;
			}
		
		
		
	}
}
