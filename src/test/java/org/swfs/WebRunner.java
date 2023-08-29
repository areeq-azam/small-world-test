package org.swfs;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = { "src/test/java/org/swfs/webSuite/Feature" },
        glue = { "." },
        tags = ("@WebSuite"),
        publish = true,
        plugin = { "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }
)
public class WebRunner extends AbstractTestNGCucumberTests {}
