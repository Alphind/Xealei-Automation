package org.alphind.xealei.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src//test//resources//Features", 

tags ="@NotificationAlertAllApproveScenario or "
		+ "@NotificationAlertRejectAndReapprovebyChiefNurseScenario  or "
		+ "@NotificationAlertRejectAndReapprovebyResidentialManagerScenario or "
		+ "@NotificationAlertThroughGridAllApproveScenario or "
		+ "@NotificationAlertThroughGridRejectAndReapprovebyChiefNurseScenario  or "
		+ "@NotificationAlertThroughGridRejectAndReapprovebyResidentialManagerScenario ",

glue = "org.alphind.xealei.stepdefinition", 
dryRun = !true, monochrome = true)



public class TC006IRNotificationFlowTestRunner {

	
	
}
