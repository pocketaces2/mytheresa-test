package com.tom.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MyAccountPage extends BasePage {

  private final Locator myAccountTitleText;

  public MyAccountPage(Page page) {
    super(page);
    this.myAccountTitleText = page.locator("[class=\"page-title\"]");
  }

  public String getPageTitleText() {
    return myAccountTitleText.innerText();
  }


}
