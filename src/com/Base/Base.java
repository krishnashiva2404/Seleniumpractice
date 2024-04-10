package com.Base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;


public class Base {
	
	static  WebDriver driver;
	 
	
	 
	 
	 @AfterTest
	 public void teardown() {
		 driver.quit();
	 }
	
	

	public  void capturedscreenshot(String methodname) throws IOException {
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File sourceobject=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationobject=new File("C:\\Users\\Dell\\eclipse-workspace\\SeleniumPractice" + methodname + ".png");
		Files.copy(sourceobject, destinationobject);
		System.out.println("Screenshot captured");
		
	}
	

}
