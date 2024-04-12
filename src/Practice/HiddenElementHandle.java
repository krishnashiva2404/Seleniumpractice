package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class HiddenElementHandle {
	
	
	@Test
	public void verifyhiddenelements() throws InterruptedException{
		
		// by using javaScript executor we handle the hidden element
		
		WebDriver driver;
		System.setProperty("webdriver,chrome,driver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		String section = driver.findElement(By.xpath("//legend[contains(text(),'Element Displayed Example')]")).toString();
		System.out.println(section);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.id("hide-textbox")).click();
		WebElement txtbox= driver.findElement(By.id("displayed-text"));
		
		jse.executeScript("arguments[0].setAttribute('style','visibility:visible;');", txtbox);
		txtbox.sendKeys("shiva");
	}

}
