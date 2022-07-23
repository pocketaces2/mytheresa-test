package com.tom.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MyAccountPage {

  private final Page page;
  private final Locator myAccountTitleText;

  public MyAccountPage(Page page){
    this.page = page;
    this.myAccountTitleText = page.locator("[class=\"page-title\"]");
  }

  public String getPageTitleText(){
    return myAccountTitleText.innerText();
  }


}
