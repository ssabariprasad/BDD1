package com.bdd.test.hooks;

import org.openqa.selenium.WebDriver;

import com.bdd.test.utility.SharedDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class ReportHooks {
private WebDriver driver=SharedDriver.getDriver();
private static final Logger logger=LogManager.getLogger(ReportHooks.class);
@AfterStep
public void screenshothook(Scenario scenario)
{;
	if(scenario.isFailed())
	{
		
		final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png","failure");
		logger.info("Screenshot taken for failure");
	}

}

	
	
	
}
