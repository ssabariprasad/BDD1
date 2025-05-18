package com.bdd.test.stepdefintions;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bdd.test.hooks.LoginHooks;
import com.bdd.test.utility.SharedDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
private WebDriver driver;
private static final Logger logger=LogManager.getLogger(LoginSteps.class);
@Given("user is in login page of sauce demo")
public void user_is_in_login_page_of_sauce_demo() {
    driver=SharedDriver.getDriver();
    driver.getTitle().equalsIgnoreCase("Swag Labs");
    logger.info("User is in login page");
}

@When("user enters valid {string} and password {string}")
public void user_enters_valid_and_password(String username, String password) {

WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2000));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user-name']"))).sendKeys(username);
driver.findElement(By.cssSelector("input#password")).sendKeys(password);
driver.findElement(By.id("login-button")).click();
logger.info("User entered valid credentials and clicked submit button in login page");
}

@Then("user should be logged in successfully to inventory page")
public void user_should_be_logged_in_successfully_to_inventory_page()  {
WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3000));
String page=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Products']"))).getText();
Assert.assertTrue(page.equals("Products"));
logger.info("User logged in and navigated to inventory page");
}

@When("user enters invalid credentials")
public void user_enters_invalid_credentials(DataTable dataTable) {
	
List<List<String>> data=dataTable.asLists(String.class);
WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2000));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user-name']"))).sendKeys(data.get(0).get(0));
driver.findElement(By.cssSelector("input#password")).sendKeys(data.get(0).get(1));
driver.findElement(By.id("login-button")).click();
logger.info("User entered invalid credentials and clicked submit button in login page");

	
}

@Then("user should not be logged in successfully to inventory page")
public void user_should_not_be_logged_in_successfully_to_inventory_page() {
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3000));
	String page=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'sadface')]"))).getText();
	Assert.assertTrue(page.equals("Epic sadface: Username and password do not match any user in this service"));
logger.info("User logged in and navigated to inventory page");
}
}
