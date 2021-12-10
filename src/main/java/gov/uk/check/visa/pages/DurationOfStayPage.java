package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class DurationOfStayPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'6 months or less')]")
    WebElement lessThan6months;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'longer than 6 months')]")
    WebElement moreThan6months;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueAfterDuration;

    public void selectLengthOfStay(String moreOrLess) {
        moreOrLess = "more than 6 months";
        switch (moreOrLess) {
            case "more than 6 months":
              /*  CustomListeners.node.log(Status.PASS, "Click on '" + moreThan6months + "' link");
                Reporter.log("Click on '" + moreThan6months + "' link <br>");*/
                clickOnElement(moreThan6months);
                break;
            case "6 months or less":
               /* CustomListeners.node.log(Status.PASS, "Click on '" + lessThan6months + "' link");
                Reporter.log("Click on '" + lessThan6months + "' link <br>");*/
                clickOnElement(lessThan6months);
                break;
            default:
                System.out.println("nothing selected");
        }
    }

    public void clickNextStep() {
       /* CustomListeners.node.log(Status.PASS, "Click on continue'" + continueAfterDuration + "' link");
        Reporter.log("Click on continue'" + continueAfterDuration + "' link <br>");*/
        clickOnElement(continueAfterDuration);
    }
}

