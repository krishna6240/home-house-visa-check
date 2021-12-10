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

public class WorkTypePage extends Utility {
    public WorkTypePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextPage;


    public void selectJobType(String jobType) {
        /*CustomListeners.node.log(Status.PASS, "Click on job type : " + jobType);
        Reporter.log("Clicking on job type " +jobType + "<br>");*/
        clickOnElement(By.xpath("//label[contains(text(),'"+jobType+"')]"));
    }
    public void clickOnNextStep(){
       /* CustomListeners.node.log(Status.PASS, "Click on next step button: " + nextPage.getText());
        Reporter.log("Clicking on next step button" + nextPage.getText() + "<br>");*/
        clickOnElement(nextPage);}

}
