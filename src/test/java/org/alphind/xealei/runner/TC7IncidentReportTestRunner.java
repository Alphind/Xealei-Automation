/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src//test//resources//Features//TC7_Incident Reports.feature", 
tags = "@RejectAndReapprovebyResidentialManager",
glue = "org.alphind.xealei.stepdefinition",
dryRun = !true, monochrome = true)



public class TC7IncidentReportTestRunner { 

	
	
}