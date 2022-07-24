package com.tom.bdd.environment;

/**
 * Stores details on each test environment.
 */
public enum Environment {
  LOCAL("https://local.mytheresa.com/en-del"), TEST("https://test.mytheresa.com/en-de"),
  STAGING("https://staging.mytheresa.com/en-de"), PROD("https://local.mytheresa.com/en-de");

  private final String baseUrl;
  private static final String HOMEPAGE_ENDPOINT = "/men.html";

  Environment(String baseUrl){
    this.baseUrl = baseUrl;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public String getBaseHomePageUrl() {
    return baseUrl + HOMEPAGE_ENDPOINT;
  }

}
