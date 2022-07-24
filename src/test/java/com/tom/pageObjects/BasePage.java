package com.tom.pageObjects;

import com.microsoft.playwright.Page;
import com.tom.bdd.environment.Environment;
import com.tom.bdd.managers.BrowserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {

  Logger logger = LoggerFactory.getLogger(BrowserManager.class);

  protected final Page page;

  public BasePage(Page page) {
    this.page = page;
  }

  public void navigateToHomePage(Environment environment) {
    logger.info("Navigating to URL: " + environment.getBaseHomePageUrl());
    page.navigate(environment.getBaseHomePageUrl());
  }


}
