package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    public ReasonForTravelPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Tourism')]")
    WebElement tourism;
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Work, academic visit or business')]")
    WebElement workAcademic;
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Join partner or family for a long stay')]")
    WebElement joinFamily;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueAfterReason;

    public void selectReasonForVisit(String reason) {
       /* CustomListeners.node.log(Status.PASS, "Click on '" + reason + "' link");
        Reporter.log("Click on '" + reason + "' link <br>");*/
        clickOnElement(By.xpath("//div[@id='current-question']//label[contains(.,'"+reason+"')]"));
    }

    public void clickOnNextStepButton() {
       /* CustomListeners.node.log(Status.PASS, "Click on '" + continueAfterReason + "' link");
        Reporter.log("Click on '" + continueAfterReason + "' link <br>");*/
        clickOnElement(continueAfterReason);
    }
}

