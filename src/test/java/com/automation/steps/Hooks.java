package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Initialize the Extent Report only once
    static {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Before(order = 0)
    public void setUpReporter() {
        // The Extent Report setup is already handled statically above.
    }

    @Before(order = 1)
    public void setUp(Scenario scenario) {
        // Existing setup steps
        ConfigReader.initConfig();
        DriverManager.createDriver();

        // Create a new test for the scenario and set it in ThreadLocal
        ExtentTest test = extent.createTest(scenario.getName());
        extentTest.set(test);
    }

    @After
    public void cleanUp(Scenario scenario) {
        // Log the scenario outcome in the Extent Report
        if (scenario.isFailed()) {
            extentTest.get().fail("Scenario failed: " + scenario.getName());
        } else {
            extentTest.get().pass("Scenario passed: " + scenario.getName());
        }

        // Existing clean-up steps
        DriverManager.getDriver().quit();

        // Flush the report to write the details
        extent.flush();
    }
}
