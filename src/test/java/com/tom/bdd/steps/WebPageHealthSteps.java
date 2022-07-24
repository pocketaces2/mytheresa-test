package com.tom.bdd.steps;

import static com.tom.bdd.context.Context.DEPARTMENT_HYPERLINKS;
import static com.tom.bdd.context.Context.PAGE_ERRORS;
import static org.assertj.core.api.Assertions.assertThat;

import com.tom.bdd.context.TestContext;
import com.tom.pageObjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

public class WebPageHealthSteps {

  protected final TestContext testContext;
  private final CommonSteps commonSteps;

  public WebPageHealthSteps(TestContext testContext, CommonSteps commonSteps) {
    this.testContext = testContext;
    this.commonSteps = commonSteps;
  }

  @Given("I am listening for Javascript errors")
  public void i_Am_Listening_For_Javascript_Errors() {
    List<String> pageErrors = new ArrayList<>();
    testContext.getCurrentPage().onPageError(pageErrors::add);
    testContext.getScenarioContext().setContext(PAGE_ERRORS, pageErrors);
  }

  @Given("I am on the myTheresa men's section homepage")
  @When("I go to the myTheresa men's section homepage")
  public void i_Am_On_The_myTheresa_HomePage() {
    HomePage homePage = new HomePage(testContext.getCurrentPage());
    homePage.navigateToHomePage(testContext.getEnvironment());
  }

  @When("I create a list of hyperlinks on the page")
  public void i_Create_A_List_Of_HyperLinks() {
    HomePage homePage = new HomePage(testContext.getCurrentPage());
    List<String> pageHyperLinks = homePage.getDepartmentHyperLinks();
    testContext.getScenarioContext().setContext(DEPARTMENT_HYPERLINKS, pageHyperLinks);

  }

  @Then("I verify that the homepage department hyperlinks return valid status codes")
  public void i_Verify_Department_Hyperlinks() {
    List<String> pageHyperLinks = testContext.getScenarioContext().get(DEPARTMENT_HYPERLINKS);
    for (String hyperlink : pageHyperLinks) {
      int statusCode = testContext.getCurrentPage().navigate(hyperlink).status();
      assertThat(statusCode).satisfiesAnyOf(
          status -> assertThat(status).isEqualTo(200),
          status -> assertThat(status).isGreaterThanOrEqualTo(300),
          status -> assertThat(status).isLessThanOrEqualTo(309)
      );
    }
  }

  @Then("I verify that there are no javascript errors on the men's section homepage")
  public void i_Verify_No_Javascript_Errors() {
    List<String> pageErrors = testContext.getScenarioContext().get(PAGE_ERRORS);
    assertThat(pageErrors).isEmpty();
  }


}
