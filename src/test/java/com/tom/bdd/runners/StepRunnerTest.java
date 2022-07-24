package com.tom.bdd.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
    "html:target/cucumber"}, features = "src/test/resources/com/tom/bdd/features", glue = "com.tom.bdd.steps", publish = true)
public class StepRunnerTest {

}
