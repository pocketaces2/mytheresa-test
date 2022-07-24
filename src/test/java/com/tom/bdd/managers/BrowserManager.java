package com.tom.bdd.managers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import com.tom.bdd.environment.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages browser creation depending on properties defined in config files. Can also be used to
 * modify the browser object at runtime.
 */
public class BrowserManager {

  private final Playwright playwright;
  Logger logger = LoggerFactory.getLogger(BrowserManager.class);
  private Browser browser;

  public BrowserManager(Playwright playwright) {
    this.playwright = playwright;
  }

  public Browser getBrowser() {
    return browser == null ? createBrowser() : browser;
  }

  private Browser createBrowser() {
    BrowserType browserType = ConfigManager.getInstance().getBrowserType();

    switch (browserType) {
      case FIREFOX -> {
        browser = playwright.firefox().launch((new LaunchOptions().setHeadless(true)));
      }
      case CHROME -> {
        browser = playwright.chromium()
            .launch((new LaunchOptions().setChannel("chrome")).setHeadless(true));
      }
      default -> {
        browser = playwright.chromium().launch((new LaunchOptions().setHeadless(true)));
      }
    }
    logger.info("Using browser " + browserType + " version: " + browser.version());
    return browser;
  }

}
