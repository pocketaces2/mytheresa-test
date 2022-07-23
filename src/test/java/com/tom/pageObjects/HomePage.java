package com.tom.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

  private final Page page;
  private final Locator myAccountLink;

  public HomePage(Page page){
    this.page = page;
    this.myAccountLink = page.locator("id=myaccount");
  }

  public void navigate() {
    page.navigate("https://www.mytheresa.com/ende/men.html");
  }

  public void clickMyAccountLink(){
    myAccountLink.click();
  }



}
