package com.tom.bdd.managers;


import com.tom.bdd.environment.BrowserType;
import com.tom.bdd.environment.Environment;
import com.tom.bdd.utils.ConfigFileReader;
import java.util.Properties;

/**
 * Singleton used for reading configuration of tests from properties files.
 */
public class ConfigManager {

  private static final String DEFAULT_CONFIG_FILE_BASE_PATH = "src/test/resources/com/tom/bdd/config/";
  private static final String DEFAULT_CONFIG_FILE = "Chromium_Local_Config.properties";

  private static final ConfigManager configManager = new ConfigManager();
  private static String configFilePath;
  private Properties properties;

  private ConfigManager(){

    if (System.getProperty("configFile") != null){
      configFilePath = DEFAULT_CONFIG_FILE_BASE_PATH + System.getProperty("configFile");
    }
    else {
      configFilePath = DEFAULT_CONFIG_FILE_BASE_PATH + DEFAULT_CONFIG_FILE;
    }

    properties = ConfigFileReader.readProperties(configFilePath);
  }

  public static ConfigManager getInstance(){ return configManager; }

  public BrowserType getBrowserType() {
    String browserType = properties.getProperty("BROWSER");

    switch (browserType.toUpperCase()) {
      case "FIREFOX" -> {
        return BrowserType.FIREFOX;
      }
      case "CHROMIUM" -> {
        return BrowserType.CHROMIUM;
      }
      case "CHROME" -> {
        return BrowserType.CHROME;
      }
      default -> {
        throw new IllegalArgumentException(
            "Invalid or unsupported browser specified to run tests with, browser specified: "
                + browserType +
                "see README for details how to specify this correctly");
      }
    }
  }

    public Environment getEnvironmentType() {
      String environmentType = properties.getProperty("ENVIRONMENT");

      switch (environmentType.toUpperCase()){
        case "LOCAL" -> {
          return Environment.LOCAL;
        }
        case "STAGING" -> {
          return Environment.STAGING;
        }
        case "TEST" -> {
          return Environment.TEST;
        }
        default -> {
          //Defaulting to prod as other URLs don't work/unreliable
          return Environment.PROD;
        }

      }
    }


}
