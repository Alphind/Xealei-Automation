package org.alphind.xealei.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src//test//resources//Features//TC7_Incident Reports.feature", 
tags = "not @Don'tRun",
glue = "org.alphind.xealei.stepdefinition", 
dryRun = true, monochrome = true)


public class TC7IncidentReportsTestRunner {

	
	
}
