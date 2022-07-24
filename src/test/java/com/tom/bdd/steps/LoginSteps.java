package com.tom.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.tom.bdd.context.TestContext;
import com.tom.pageObjects.HomePage;
import com.tom.pageObjects.MyAccountLoginPage;
import com.tom.pageObjects.MyAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

  protected final TestContext testContext;
  private final CommonSteps commonSteps;

  public LoginSteps(TestContext testContext, CommonSteps commonSteps) {
    this.testContext = testContext;
    this.commonSteps = commonSteps;
  }

  @Given("I am on the myAccount login page")
  public void i_Am_On_The_myTheresa_HomePage() {
    //TEST CASE 2: Could go straight to myAccount URL here or use the flyout login box
    HomePage homePage = new HomePage(testContext.getCurrentPage());
    homePage.navigateToHomePage(testContext.getEnvironment());
    homePage.clickMyAccountPageLinkExpectingLoginCredentials();
  }

  @When("I input my email: {word} and my password: {word} into the my account login page")
  public void i_Input_Login_Details(String emailUser, String password) {
    MyAccountLoginPage myAccountLoginPage = new MyAccountLoginPage(testContext.getCurrentPage());
    myAccountLoginPage.enterAccountLoginDetails(emailUser, password);
    myAccountLoginPage.clickAccountLoginButton();
  }

  @Then("I verify that I have successfully logged in to the account page")
  public void i_Verify_I_Have_Logged_In() {
    MyAccountPage myAccountPage = new MyAccountPage(testContext.getCurrentPage());
    assertThat(myAccountPage.getPageTitleText()).withFailMessage(
        "Invalid title text for user account page, indicating the login request failed")
        .isEqualTo("MY OVERVIEW");

  }
}
