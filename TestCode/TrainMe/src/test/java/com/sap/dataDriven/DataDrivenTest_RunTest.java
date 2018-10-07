package com.sap.dataDriven;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/sap/features/dataDriven.feature", glue = { "com.sap.dataDriven" })

public class DataDrivenTest_RunTest {

}
