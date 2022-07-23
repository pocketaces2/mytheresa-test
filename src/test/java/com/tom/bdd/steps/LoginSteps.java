package com.tom.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;


import com.microsoft.playwright.Page;
import com.tom.bdd.context.TestContext;
import com.tom.pageObjects.HomePage;
import com.tom.pageObjects.MyAccountLoginPage;
import com.tom.pageObjects.MyAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

  private final TestContext testContext;
  Page page;

  public LoginSteps(TestContext testContext){
    this.testContext = testContext;
  }

  @Given("I am on the myAccount login page")
  public void i_Am_On_The_myTheresa_HomePage(){
    page = testContext.getBrowserContext().newPage();
    HomePage homePage = new HomePage(page);
    homePage.navigate();
    homePage.clickMyAccountLink();
  }

  @When("I input my email: {word} and my password: {word} into the my account login page")
  public void i_Input_Login_Details(String emailUser, String password){
    MyAccountLoginPage myAccountLoginPage = new MyAccountLoginPage(page);
    myAccountLoginPage.enterAccountLoginDetails(emailUser, password);
    myAccountLoginPage.clickAccountLoginButton();
  }

  @Then("I verify that I have successfully logged in to the account page")
  public void i_Verify_I_Have_Logged_In(){
    MyAccountPage myAccountPage = new MyAccountPage(page);
    assertThat(myAccountPage.getPageTitleText()).withFailMessage("Invalid title text for user account page, indicating the login request failed")
        .isEqualTo("MY OVERVIEW");

  }
}
