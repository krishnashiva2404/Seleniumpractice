package Practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TabHandles {
	
	@Test
	public void verifymultipleTabsHandle() throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver,chrome,driver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		String section = driver.findElement(By.xpath("//legend[contains(text(),'Switch Tab Example')]")).toString();
		System.out.println(section);
		driver.findElement(By.linkText("Open Tab")).click();
		String parentwindow = driver.getWindowHandle();
		System.out.println(parentwindow);
		Set<String> set =  driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String childwindow=it.next();
			
			if(!(parentwindow.equals(childwindow))) {
				System.out.println(driver.switchTo().window(childwindow).getTitle());
				Thread.sleep(5000);
				
				driver.findElement(By.linkText("Courses")).click();
				
			}
		}
		
	}

}
