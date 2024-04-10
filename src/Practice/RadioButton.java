package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButton {
	
	@Test
	public void verifyRadiobtn() throws InterruptedException {
		WebDriver driver;
		System.setProperty("driver,chrome,webdriver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		String SectionName=driver.findElement(By.xpath("//legend[contains(text(),'Radio Button Example')]")).toString();
		System.out.println(SectionName);
		List<WebElement> radios=driver.findElements(By.xpath("//div[@id='radio-btn-example']/fieldset/label"));
		for(WebElement rao : radios) {
			System.out.println(rao.getText());
			}
		
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		
			
		}
	

}
