package com.bdd.test.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SharedDriver {
	
private static final ThreadLocal<WebDriver> driver=new ThreadLocal<>();
private SharedDriver()
{
	
}


public static WebDriver getDriver()
{
	 if(driver.get()!=null) {
			return driver.get();
     }
	WebDriver webDriver=null;
	FileReader reader;
	Properties prop=new Properties();
	try {
		reader = new FileReader("src/test/resources/Config.properties");
		prop.load(reader);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	String browser=prop.getProperty("browser");
	browser=browser.toLowerCase();
	switch (browser)
	{
	case "chrome":
		webDriver=new ChromeDriver();
		break;
	case "firefox":
		webDriver=new FirefoxDriver();
		break;
	case "edge":
		webDriver=new EdgeDriver();
		break;
	default:
		throw new IllegalArgumentException("Invalid browser");
	
	}
	
	driver.set(webDriver);

	return driver.get();
}

public static void quitDriver()
{
	if(driver.get()!=null) {
		driver.get().quit();
		driver.remove();
	}
}

}
