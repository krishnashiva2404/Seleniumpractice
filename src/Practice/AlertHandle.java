package Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertHandle {
	
	@Test
	public void verifyalerthandle() throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver,chrome,driver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		String section = driver.findElement(By.xpath("//legend[contains(text(),'Switch To Alert Example')]")).toString();
		System.out.println(section);
		
		driver.findElement(By.id("alertbtn")).click();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		
		driver.findElement(By.id("name")).sendKeys("Rashulshetty practice page");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(al.getText());
		al.dismiss();
	}

}
