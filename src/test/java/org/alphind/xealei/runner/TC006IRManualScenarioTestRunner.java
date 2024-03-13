package org.alphind.xealei.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src//test//resources//Features", 

tags ="@IRManual-AllApproveScenario or @RejectAndReapprovebyChiefNurseScenario or"
		+ " @RejectAndReapprovebyResidentialManagerScenario",


glue = "org.alphind.xealei.stepdefinition", 
dryRun = !true, monochrome = true)


public class TC006IRManualScenarioTestRunner {

	
	
}
