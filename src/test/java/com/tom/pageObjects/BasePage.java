package com.tom.pageObjects;

import com.microsoft.playwright.Page;
import com.tom.bdd.environment.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {

  protected final Page page;
  Logger logger = LoggerFactory.getLogger(BasePage.class);

  public BasePage(Page page) {
    this.page = page;
  }

  public void navigateToHomePage(Environment environment) {
    logger.info("Navigating to URL: " + environment.getBaseHomePageUrl());
    page.navigate(environment.getBaseHomePageUrl());
  }


}
