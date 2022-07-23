package com.tom.bdd.enums;

public enum EnvironmentType {
  LOCAL("https://local.mytheresa.com/en-de/men.html"), TEST("https://test.mytheresa.com/en-de/men.html"),
  STAGING("https://staging.mytheresa.com/en-de/men.html"), PRODUCTION("https://local.mytheresa.com/en-de/men.html");

  String url;

  EnvironmentType(String url){
    this.url = url;
  }

}
