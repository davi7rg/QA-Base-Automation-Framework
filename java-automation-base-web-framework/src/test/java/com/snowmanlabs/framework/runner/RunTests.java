package com.snowmanlabs.framework.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * 
 * Classe que sera executada para que se inicie a bateria de testes
 * 
 * @author Davi Rodrigues - Analista de QA Senior 1
 * @since Agosto/2020
 * @version 0.1 - Snowman Labs
 * 
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@exemplo"},
		features = {"src/test/resources/features"},
		plugin = {"pretty", "html:target/cucumber-html-report"},
		glue = {""},
		monochrome = true,
		strict = true,
		dryRun = false)
public class RunTests {

}