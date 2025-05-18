package com.bdd.test.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SharedDriver {
	
private static WebDriver driver;

private SharedDriver()
{
	
}

public static WebDriver getDriver()
{
	if(driver==null) {
		driver=new ChromeDriver();
	    driver.manage().window().maximize();
	}
	
	
	return driver;
}

public static void quitDriver()
{
	if(driver!=null) {
		driver.quit();
		driver=null;
	}
}

}
