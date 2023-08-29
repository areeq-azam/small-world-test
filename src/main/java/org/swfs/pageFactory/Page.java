package org.swfs.pageFactory;

import org.swfs.coreUtils.json.JsonReader;
import org.swfs.coreUtils.selenium.DriverManager;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Page {

    public static WebDriverWait wait;

    public static By getElement(String fileName, String elementName) throws IOException {
        JsonObject elementObject = JsonReader.readElementFromJson(fileName, elementName);

        String elementType = elementObject.get("type").getAsString();
        String elementLocator = elementObject.get("value").getAsString();
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(100));

        switch (elementType.toLowerCase()) {
            case "css" -> {
                return By.cssSelector(elementLocator);
            }
            case "id" -> {
                return By.id(elementLocator);
            }
            case "xpath" -> {
                return By.xpath(elementLocator);
            }
            case "name" -> {
                return By.name(elementLocator);
            }
            case "classname" -> {
                return By.className(elementLocator);
            }
            case "linktext" -> {
                return By.linkText(elementLocator);
            }
            default -> System.out.println("please pass the right locator type and value.....");
        }
        return null;
    }
}
