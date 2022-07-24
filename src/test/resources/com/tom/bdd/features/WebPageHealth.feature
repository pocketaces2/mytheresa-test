Feature: As a tester, I want to verify the general health of the myTheresa webpages


  Scenario: As a tester, I want to make sure no JavaScript errors when you visit the mens section of the MyTheresa website
    Given I am listening for Javascript errors
    When I go to the myTheresa men's section homepage
    Then I verify that there are no javascript errors on the men's section homepage

  Scenario: As a tester, I want to check if a page is returning the expected status code
    Given I am on the myTheresa men's section homepage
    When I create a list of hyperlinks on the page
    Then I verify that the homepage department hyperlinks return valid status codes