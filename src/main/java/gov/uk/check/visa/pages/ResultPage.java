package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ResultPage extends Utility {
    public ResultPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@id='result-info']//h2[@class='gem-c-heading gem-c-heading--font-size-27 govuk-!-margin-bottom-6']")
    WebElement result;

    public String getResultMsg(){
        /*CustomListeners.node.log(Status.PASS, "Get result text : " + result.getText());
        Reporter.log("Get result text : " + result.getText() + "<br>");*/
        String resultMsg = getTextFromElement(result);
        return resultMsg;
    }

    public void confirmResultMessage(String expectedMessage) {
        Assert.assertTrue(expectedMessage.equals(getResultMsg()));
    }

}