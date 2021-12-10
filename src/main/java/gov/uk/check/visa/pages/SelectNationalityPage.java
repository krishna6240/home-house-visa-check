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

public class SelectNationalityPage extends Utility {
    public SelectNationalityPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//select[@id='response']")
    WebElement nationalityDropDownList;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueAfterNationality;

    public void selectNationality(String nationality) {
        selectByVisibleTextFromDropDown(nationalityDropDownList, nationality);
      //  CustomListeners.node.log(Status.PASS, "Country '" + nationality + "' selected");
       // Reporter.log("Country '" + nationality + "' selected <br>");
    }

    public void clickNextStepButton() {
        /*CustomListeners.node.log(Status.PASS, "Click on registerLink : " + continueAfterNationality.getText());
        Reporter.log("Clicking on register link " + continueAfterNationality.getText() + "<br>");*/
        clickOnElement(continueAfterNationality);
    }

}
