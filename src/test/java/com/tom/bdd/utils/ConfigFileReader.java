package com.tom.bdd.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *  Utility class for reading config files
 */
public class ConfigFileReader {

  /**
   * Reads a config file at the given path and returns a properties object.
   *
   * @param path - the path to the configuration properties file
   * @return - a properties file with configuration properties
   */
  public static Properties readProperties(String path){
    Properties properties = new Properties();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
      properties.load(bufferedReader);
    }
    catch (IOException exception){
      exception.printStackTrace();
    }

    return properties;
  }

}
