package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FamilyImmigrationStatusPage extends Utility {
    public FamilyImmigrationStatusPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@id='current-question']//div[@class='gem-c-radio govuk-radios__item']/input[@id='response-0']")
    WebElement yesRB;
    @CacheLookup
    @FindBy(css = "#response-1")
    WebElement noRB;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement next;

    public void selectImmigrationStatus(String status) {
        switch (status) {
            case "yes":
               /* CustomListeners.node.log(Status.PASS, "Click on yes'" + yesRB + "' link");
                Reporter.log("Click on yes'" + yesRB + "' link <br>");*/
                clickOnElement(yesRB);
                break;
            case "no":
              /*  CustomListeners.node.log(Status.PASS, "Click on no'" + noRB + "' link");
                Reporter.log("Click on no'" + noRB + "' link <br>");*/
                clickOnElement(noRB);
                break;
            default:
                System.out.println("Please select an option");
        }
    }
    public void clickOnContinue(){
       /* CustomListeners.node.log(Status.PASS, "Click on next'" + next + "' link");
        Reporter.log("Click on next'" + next + "' link <br>");*/
        clickOnElement(next);
    }
}