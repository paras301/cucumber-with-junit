package com.company.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/featureFiles"},
		glue = {"com.company.step.definitions"},
		monochrome = true,
		dryRun = false,
		plugin = {
				"json:build/cucumber-reports/cucumber.json",
				"rerun:build/cucumber-reports/rerun.txt"
		})
public class TestRunner {
}
