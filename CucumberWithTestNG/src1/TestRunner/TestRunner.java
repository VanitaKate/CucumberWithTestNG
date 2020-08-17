package TestRunner;

import java.util.Iterator;
import java.util.List;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
	features= {".//Features/Login.feature"},
	glue="StepDefinitions",
			plugin = {
            "pretty",
            "html:target/HTMLReport",
            "json:target/cucumber-reports/CucumberTestReport.json",
            "rerun:target/cucumber-reports/rerun.txt"
    },
	dryRun=false
		)




public class TestRunner extends AbstractTestNGCucumberTests{
	public TestNGCucumberRunner testNGCucumberRunner;



}
