package Login;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Base.Base;
import com.Base.CustomeListener;



public class Loginpage {
	WebDriver driver;
	
	 @BeforeTest
		public void setup() throws InterruptedException {
			
			System.setProperty("driver,gecko,webdriver", "C:\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			Thread.sleep(5000);
		}
	
	@Test(dataProvider="credentials")
	public void verifylogin(String username,String password) throws InterruptedException, IOException {
		
		
			
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.navigate().refresh();
			Thread.sleep(5000);
	
		String ActualTitle="Dashboard";
		
		String expectedtitle=driver.findElement(By.xpath("//div[@class='oxd-topbar-header-title']/span/h6")).getText();
		if(expectedtitle.equals(ActualTitle)) {
			Assert.assertTrue(true);
			System.out.println("Login Sucess");
		}else {
			System.out.println("Login failed");
		}
			
		

	}
	
	
	
	@DataProvider(name="credentials")
	public Object[][] getdata(){
		return new Object[][]{
			{"Shiva","Shiva@123"},
			{"krishna","krish@123"},
			{"rama","ram@123"},
			{"Admin","admin123"}
			
			
		};
	}

}
