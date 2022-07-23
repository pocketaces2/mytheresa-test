Feature: As a tester owner, I want to verify I can log in to the men's section of the MyTheresa website

  Scenario Outline: As a test owner, I want to verify I can login to the men's section
    Given I am on the myAccount login page
    When I input my email: <emailUser> and my password: <password> into the my account login page
    Then I verify that I have successfully logged in to the account page
    Examples:
      | emailUser                    | password    |
      | winstonchurchill@maildrop.cc | password123 |