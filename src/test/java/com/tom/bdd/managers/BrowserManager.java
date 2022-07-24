package com.tom.bdd.managers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import com.tom.bdd.environment.BrowserType;

/**
 * Manages browser creation depending on properties defined in config files. Can also be used to
 * modify the browser object at runtime.
 */
public class BrowserManager {

  private final Playwright playwright;
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
        browser = playwright.firefox().launch((new LaunchOptions().setHeadless(false)));
      }
      case CHROME -> {
        browser = playwright.chromium().launch((new LaunchOptions().setChannel("chrome")).setHeadless(false));
      }
      default -> {
        browser = playwright.chromium().launch((new LaunchOptions().setHeadless(false)));
      }
    }
    return browser;
  }

}
