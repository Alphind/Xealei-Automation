/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.stepdefinition;

import java.net.SocketException;

import org.alphind.xealei.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	final String passed = getConfigureProperty("PassedScreenshots");
	final String failed = getConfigureProperty("FailedScreenshots");

	@Before
	public void setUp(Scenario scenario) throws Exception {

		reportSetup(scenario.getName());
		browserType();
		env();
		implicitWaitBySeconds(15);
	}

	@After
	public void tearDown() throws SocketException {

		reportFlush();
//		if (getDriver() != null) {
//			quit();
//		}
	}
}
	

//	@After(order = 2)
//	public void cleaningProcess() {
//		
//	/* cleanRecordFromDB(true, "xealeiqa", "", "");
//	 * cleanRecordFromDB(true, null, null, null);
//	 */ }
