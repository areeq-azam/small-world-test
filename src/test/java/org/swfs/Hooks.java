package org.swfs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.swfs.coreUtils.selenium.DriverManager;

import java.io.IOException;

public class Hooks {


    @Before(value = "@WebSuite")
    public void beforeWeb() throws Exception {
        DriverManager.initializeDriver("chrome", "https://www.saucedemo.com/");
    }

    @After("@WebSuite")
    public void afterWeb() {
        DriverManager.getDriver().quit();
    }
}
