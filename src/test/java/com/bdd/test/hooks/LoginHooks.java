package com.bdd.test.hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

import com.bdd.test.utility.SharedDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class LoginHooks {
private WebDriver driver;
private static final Logger logger=LogManager.getLogger(LoginHooks.class);
@Before
public void setUp()
{

	driver=SharedDriver.getDriver();
	driver.manage().window().maximize();

}


@After
public void tearDown()
{
	SharedDriver.quitDriver();
	logger.info("driver quit");
}


}
