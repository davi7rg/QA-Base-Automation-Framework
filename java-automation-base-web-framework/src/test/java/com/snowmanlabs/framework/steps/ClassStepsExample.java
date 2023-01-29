package com.snowmanlabs.framework.steps;

import java.io.IOException;

import com.snowmanlabs.framework.pages.ClassPageExample;

import io.cucumber.java.pt.Dado;

/**
 * 
 * Classe responsavel por definicao dos steps contidos no gherkin(cucumber)
 * 
 * @author Davi Rodrigues - Analista de QA Senior 1
 * @since Agosto/2020
 * @version 0.1 - Snowman Labs
 * 
 */

public class ClassStepsExample {
	
	@Dado ("que eu faca alguma coisa como premissa de todos os cenarios")
	public void methodExample() throws IOException {
		ClassPageExample classPageExample = new ClassPageExample();
		classPageExample.validateElementExample();
	}
	
	@Dado ("que informo a precondicao com a ([^\\\"]*)$")
	public void methodExample2() throws IOException {
		ClassPageExample classPageExample = new ClassPageExample();
		classPageExample.validateElementExample2();
	}

}