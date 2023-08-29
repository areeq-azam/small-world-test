package org.swfs.webSuite.StepDefinitions;

import org.swfs.pageFactory.Page;
import org.swfs.coreUtils.excel.ExcelReader;
import org.swfs.coreUtils.selenium.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WebSteps {

    SeleniumHelper seleniumHelper = new SeleniumHelper();
    public static List<Map<String, String>> testData;
    static int rowNumber;

    @When("user enters {string} against field {string} on {string}")
    public void userEntersAgainstField(String textField, String elementName, String pageName) throws IOException {
        //Conditional variable decoration on the basis of Excel parameterization
        elementName = elementName.contains("[") ? testData.get(rowNumber).get(elementName) : elementName;
        pageName = pageName.contains("[") ? testData.get(rowNumber).get(pageName) : pageName;
        textField = textField.contains("[") ? testData.get(rowNumber).get(textField) : textField;

        //Actual step
        seleniumHelper.fillTextBox(textField, Page.getElement(pageName, elementName));
    }

    @And("user clicks a {string} on {string}")
    public void userClicks(String elementName, String pageName) throws IOException {
        //Conditional variable decoration on the basis of Excel parameterization
        elementName = elementName.contains("[") ? testData.get(rowNumber).get(elementName) : elementName;
        pageName = pageName.contains("[") ? testData.get(rowNumber).get(pageName) : pageName;

        //Actual step
        seleniumHelper.performTapOrClickAction(Page.getElement(pageName, elementName));
    }

    @Then("user expects visibility of {string} against {string} on {string}")
    public void userExpectsVisibilityOfText(String expectedText, String elementName, String pageName) throws IOException {
        //Conditional variable decoration on the basis of Excel parameterization
        elementName = elementName.contains("[") ? testData.get(rowNumber).get(elementName) : elementName;
        pageName = pageName.contains("[") ? testData.get(rowNumber).get(pageName) : pageName;
        expectedText = expectedText.contains("[") ? testData.get(rowNumber).get(expectedText) : expectedText;

        //Actual Step
        seleniumHelper.validateElementText(
            Page.getElement(pageName, elementName),
            expectedText,
            "expected text and actual text mismatched"
        );
    }

    @Given("Framework reads the web data from {string} having row number {string}")
    public void frameworkReadsTheDataFromHavingRowNumber(String filename, String rowNum) throws IOException {
        ExcelReader reader = new ExcelReader();
        testData = reader.getData("src/test/java/org/swfs/webSuite/Data/"+ filename, 0);
        rowNumber = Integer.parseInt(rowNum) - 1;
    }

    

    @When("user verifies that the {string} is displayed on {string}")
    public void userVerifiesThatTheElementIsDisplayed(String elementName, String pageName) throws IOException {
        //Conditional variable decoration on the basis of Excel parameterization
        elementName = elementName.contains("[") ? testData.get(rowNumber).get(elementName) : elementName;
        pageName = pageName.contains("[") ? testData.get(rowNumber).get(pageName) : pageName;

        //Actual Step
        seleniumHelper.validateElementVisibility(Page.getElement(pageName, elementName));
    }
}
