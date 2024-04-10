package com.Base;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomeListener extends Base implements ITestListener {
	
	// we get the Overriden method from the ITestListener Interface
	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			capturedscreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
