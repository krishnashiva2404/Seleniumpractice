package Practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableHandle {
	@Test
	public void verifywebtable() throws InterruptedException {
		
		
		WebDriver driver;
		System.setProperty("webdriver,chrome,driver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		String section = driver.findElement(By.xpath("//legend[contains(text(),'Web Table Example')]")).toString();
		System.out.println(section);
		
		 System.out.println(driver.findElement(By.xpath("//table[@id='product']")).isDisplayed());
		 // print webtable headers
		 List<WebElement> allheaders= driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th"));
		 List headersname=new ArrayList();
		 for(WebElement header : allheaders) {
			 String headername=header.getText();
			 headersname.add(headername);
			 
		 }
//		 for(int i=1;i<=3;i++) {
//			 ArrayList<String> al=new ArrayList(driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th["+i+"]")));
//			 System.out.println(al);
//		 }
		 
		 // get row count of webtable
		 int row= driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size();
		 // get column count of webtable
		 int column = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[2]/td")).size();
		 
		 System.out.println(row);
		 System.out.println(column);
		 
		 String data1= driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[2]/td[2]")).getText();
		 System.out.println(data1);
		 
		 LinkedHashMap eachdata=new LinkedHashMap();
		 
		 for(int i=2;i<=row;i++) {
			 for(int j=1;j<=column;j++) {
				 
				// String data = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr["+i+"]"+"/td["+j+"]")).getText();
				 eachdata.put(headersname, driver.findElement(By.xpath("//table[@name='courses']/tbody/tr["+i+"]"+"/td["+j+"]")).getText());
				 
			 }
		 }
		 
		 System.out.println(eachdata);
		 
		
		
	}

}
