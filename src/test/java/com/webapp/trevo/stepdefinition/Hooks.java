package com.webapp.trevo.stepdefinition;

import com.webapp.trevo.utility.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    public static String scenarioName;

    @Before
    public void beforeScenarioStart(Scenario scenario) {
        System.out.println("--------------------------------------------------------------------Start of Scenario------------------------------------------------------------------");
        scenarioName = scenario.getName();
        System.out.println("Scenario Started: " + scenarioName);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    @After
    public void afterScenarioFinish(Scenario scenario) {
        if (scenario.isFailed()) {
            DriverManager.saveScreenshot();
        }
        System.out.println("--------------------------------------------------------------------End of Scenario--------------------------------------------------------------------");
        scenarioName = scenario.getName();
        System.out.println(scenarioName + " Status - " + scenario.getStatus());
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

}