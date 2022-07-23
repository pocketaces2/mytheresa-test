package com.tom.bdd.context;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import com.tom.bdd.managers.BrowserManager;

public class TestContext {

  private final Playwright playwright;
  private final Browser browser;
  private final BrowserContext browserContext;

  public TestContext(){
    playwright = Playwright.create();
    BrowserManager browserManager = new BrowserManager(playwright);
    browser = browserManager.getBrowser();
    browserContext = browser.newContext();
  }

  public Playwright getPlaywright(){
    return playwright;
  }

  public Browser getBrowser(){
    return browser;
  }

  public BrowserContext getBrowserContext() {
    return browserContext;
  }
}
