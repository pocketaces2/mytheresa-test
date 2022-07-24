package com.tom.bdd.steps;

import com.tom.bdd.context.TestContext;
import io.cucumber.java.After;

public class CommonSteps {

  TestContext testContext;

  public CommonSteps(TestContext testContext){
    this.testContext = testContext;
  }

  @After
  public void cleanUpEnvironment(){
    testContext.closePlaywright();
  }

}
