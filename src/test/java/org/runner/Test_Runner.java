package org.runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features",
    glue = "org.def",
    dryRun = false,
    monochrome = true,
    plugin = {
        "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-reports/Cucumber.html",
        "junit:target/cucumber-reports/Cucumber.xml",
        "de.monochromata.cucumber.report.PrettyReports:target/cucumber-reports"
    }
)
public class Test_Runner {

}
