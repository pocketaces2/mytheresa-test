package com.tom.pageObjects;

import com.microsoft.playwright.Page;
import com.tom.bdd.environment.Environment;

public abstract class BasePage {

  protected final Page page;

  public BasePage (Page page){
    this.page = page;
  }

  public void navigateToHomePage(Environment environment) {
    page.navigate(environment.getBaseHomePageUrl());
  }


}
