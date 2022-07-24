package com.tom.bdd.context;

import java.util.EnumMap;
import java.util.Map;

/**
 * Used for sharing test data between steps classes
 * <p>
 * Example usage would be:
 * <p>
 * scenarioContext.setContext(Context.CHECKOUT_TOTAL, "$15.00); scenarioContext.get(Context.CHECKOUT_TOTAL);
 */
public class ScenarioContext {

  private final Map<Context, Object> scenarioContext;

  public ScenarioContext() {
    scenarioContext = new EnumMap<Context, Object>(Context.class);
  }

  public void setContext(Context key, Object value) {
    scenarioContext.put(key, value);
  }

  public <T> T get(Context key) {
    return (T) scenarioContext.get(key);
  }
}
