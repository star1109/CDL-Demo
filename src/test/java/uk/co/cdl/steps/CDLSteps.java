package uk.co.cdl.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.co.cdl.pages.Homepage;
import uk.co.cdl.pages.OurMissionPage;

public class CDLSteps {
    @Given("^User is on CDL Home Page$")
    public void userIsOnCDLHomePage() {
    }

    @When("^User clicks on CDL Menu bar$")
    public void userClicksOnCDLMenuBar() {
        new Homepage().clickOnMenuBar();

    }

    @And("^user clicks on 'ABOUT' Tab$")
    public void userClicksOnABOUTTab() throws InterruptedException {
        new Homepage().clickOnAboutTab();
        Thread.sleep(2000);
    }

    @And("^User clicks on 'Our Mission'$")
    public void userClicksOnOurMission() throws InterruptedException {
        new Homepage().clickOnOurMissionTab();
        Thread.sleep(3000);
    }

    @Then("^User should successfully navigate to 'Our Mission' Page$")
    public void userShouldSuccessfullyNavigateToOurMissionPage() {
        new OurMissionPage().verifyOurMissionPage();
    }
}
