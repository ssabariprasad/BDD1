package com.bdd.test.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Logintest.feature",glue={"com.bdd.test.hooks","com.bdd.test.stepdefintions"},tags="@T1 or @T2",plugin= {"html:target/report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunner {

}
