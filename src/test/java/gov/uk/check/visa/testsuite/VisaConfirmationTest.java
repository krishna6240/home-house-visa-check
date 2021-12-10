package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;

public class VisaConfirmationTest extends TestBase {
    StartPage startPage;
    DurationOfStayPage durationOfStayPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    ReasonForTravelPage reasonForTravelPage;
    SelectNationalityPage selectNationalityPage;
    WorkTypePage workTypePage;
    ResultPage resultPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt1() {
        startPage = new StartPage();
        durationOfStayPage = new DurationOfStayPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        reasonForTravelPage = new ReasonForTravelPage();
        resultPage = new ResultPage();
        workTypePage = new WorkTypePage();
        selectNationalityPage = new SelectNationalityPage();
    }

    @Test(priority = 1, groups = {"smoke","regression"})
    public void anAustralianComingToUKForTourism() {
        //startPage.clickOnRejectCookies();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Australia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("Tourism");
        reasonForTravelPage.clickOnNextStepButton();
        resultPage.confirmResultMessage("You will not need a visa to come to the UK");
    }

    @Test(priority = 2, groups = {"sanity","regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() {
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Chile");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        reasonForTravelPage.clickOnNextStepButton();
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        durationOfStayPage.clickNextStep();
        workTypePage.selectJobType("Health and care professional");
        workTypePage.clickOnNextStep();
        resultPage.confirmResultMessage("You need a visa to work in health and care");
    }

    @Test(priority = 3, groups = {"sanity","regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() {
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Colombia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
        reasonForTravelPage.clickOnNextStepButton();
        familyImmigrationStatusPage.selectImmigrationStatus("yes");
        familyImmigrationStatusPage.clickOnContinue();
        resultPage.confirmResultMessage("You’ll need a visa to join your family or partner in the UK");
    }
}
