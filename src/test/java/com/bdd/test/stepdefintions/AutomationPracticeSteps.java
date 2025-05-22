package com.bdd.test.stepdefintions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.bdd.test.utility.LoggerUtility;
import com.bdd.test.utility.SharedDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomationPracticeSteps {
private WebDriver driver=SharedDriver.getDriver();
private static final Logger logger=LoggerUtility.getLogger(AutomationPracticeSteps.class);

@Given("user is in practice page")
public void user_is_in_practice_page() {
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	logger.info("Automation practice site launched");
}

@When("user clicks radio button")
public void user_clicks_radio_button() {
 FluentWait <WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1))
		 .ignoring(NoSuchElementException.class);
 
 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='autocomplete']")))).sendKeys("Sabari");
	logger.info("Selected send text to text box");

}

@Then("button should be selected")
public void button_should_be_selected() {
    System.out.println(driver.findElement(By.xpath("//*[@id='autocomplete']")).getText().equalsIgnoreCase("sabari"));
	logger.info("text displayed in text box successfully");

}



	
}
