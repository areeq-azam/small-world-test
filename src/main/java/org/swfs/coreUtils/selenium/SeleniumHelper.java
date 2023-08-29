package org.swfs.coreUtils.selenium;

import org.swfs.pageFactory.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SeleniumHelper {

    public void performTapOrClickAction(By element) {
        Page.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void fillTextBox(String text, By elementSelector) {
        WebElement element = DriverManager.getDriver().findElement(elementSelector);
        element.sendKeys(text);
    }

    public void validateElementText(By elementSelector, String elementText, String assertionMessage){
        Page.wait.until(ExpectedConditions.presenceOfElementLocated(elementSelector));
        WebElement element = DriverManager.getDriver().findElement(elementSelector);
        Page.wait.until(ExpectedConditions.visibilityOf(element));
        Page.wait.until(ExpectedConditions.textToBePresentInElement(element, elementText));
        Assert.assertTrue(element.getText().contains(elementText), assertionMessage);
    }

    public void validateElementVisibility(By elementLocator) {
        Page.wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void isButtonEnabled(By elementSelector) {
        Page.wait.until(ExpectedConditions.presenceOfElementLocated(elementSelector));
        WebElement element = DriverManager.getDriver().findElement(elementSelector);
        Assert.assertTrue(element.isEnabled());
    }

    public void isButtonDisabled(By elementSelector) {
        Page.wait.until(ExpectedConditions.presenceOfElementLocated(elementSelector));
        WebElement element = DriverManager.getDriver().findElement(elementSelector);
        Assert.assertFalse(element.isEnabled());
    }
}
