package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Textbox {
	
	@Test
	public void verifyTextbox() throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver,chrome,driver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		String section = driver.findElement(By.xpath("//legend[contains(text(),'Suggession Class Example')]")).toString();
		System.out.println(section);
		WebElement text = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		text.sendKeys("INDIA");
		text.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		List<WebElement> countries = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/div"));
		for(WebElement country: countries) {
			System.out.println(country.getText());
		}
		
		driver.findElement(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/li[2]/div")).click();
	}

}
