package com.sap.postRequests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/sap/features", glue = { "com.sap.postRequests" })
public class Post_RunTest {

}
