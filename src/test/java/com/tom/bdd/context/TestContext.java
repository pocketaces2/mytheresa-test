package com.tom.bdd.context;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.tom.bdd.environment.Environment;
import com.tom.bdd.managers.BrowserManager;
import com.tom.bdd.managers.ConfigManager;


/**
 * Main context object that allows for accessing and modifying test environment properties.
 * Test data specifically should be stored in the ScenarioContext object.
 *
 * @see  ScenarioContext
 */
public class TestContext {

  private final Playwright playwright;
  private final BrowserContext browserContext;
  private final Environment environment;
  private final Page currentPage;

  private final ScenarioContext scenarioContext;

  public TestContext(){
    playwright = Playwright.create();
    BrowserManager browserManager = new BrowserManager(playwright);
    browserContext = browserManager.getBrowser().newContext();
    environment = ConfigManager.getInstance().getEnvironmentType();
    scenarioContext = new ScenarioContext();
    currentPage = browserContext.newPage();
  }

  public void closePlaywright(){
     playwright.close();
  }

  public BrowserContext getBrowserContext() {
    return browserContext;
  }

  public Environment getEnvironment() {
    return environment;
  }

  public Page getCurrentPage(){
    return currentPage;
  }

  public ScenarioContext getScenarioContext() {
    return scenarioContext;
  }
}
