package com.tom.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

  private final Locator titleText;
  private final Locator myAccountLink;

  public HomePage(Page page) {
    super(page);
    this.myAccountLink = page.locator("id=myaccount");
    this.titleText = page.locator("id=myaccount");
  }

  public MyAccountLoginPage clickMyAccountPageLinkExpectingLoginCredentials() {
    myAccountLink.click();
    return new MyAccountLoginPage(page);
  }

  public MyAccountLoginPage clickMyAccountPageLinkAsLoggedInUser() {
    myAccountLink.click();
    return new MyAccountLoginPage(page);
  }

}
