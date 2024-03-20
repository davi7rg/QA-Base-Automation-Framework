package com.cliente.framework.utils;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cliente.framework.hooks.Hooks;

/**
 * 
 * Classe responsavel pela implementacao de metodos gerais que sao comuns a todos os projetos de automacao desenvolvidos
 * 
 * @author Davi Rodrigues - Analista de QA Senior 1
 * @since Agosto/2022
 * @version 0.1 - Cliente XXXXX
 * 
 */

public class GeneralMethods extends ReporterMethods {

	protected WebDriverWait wait;

	/**
	 * Metodo que espera o elemento ficar visivel para prosseguir com a interacao
	 * 
	 * @param element - Elemento para interecao
	 * @throws IOException
	 */
	private void waitVisibility(WebElement element, String elementName) throws IOException {
		try {
			wait = new WebDriverWait(Hooks.getDriver(), 30);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			logFailed("Elemento \"" + elementName + "\" nao encontrado");
			Assert.fail();
		}
	}
	
	/**
	 * Metodo que recebe a informacao do elemento visivel em tela bem como a marcacao do elemento com um moldura vermelhas
	 * 
	 * @param element - Elemento para interecao
	 * @throws IOException
	 */
	public void highlightElement(WebElement element, String elementName) throws IOException {
		waitVisibility(element, elementName);
		highlight(element, 1);
	}
	
	/**
	 * Metodo que seleciona o elemento desejado com uma moldura vermelhas
	 * 
	 * @param element - Elemento para interecao
	 * @throws IOException
	 */
	private void highlight(WebElement element, int waitSeconds) {
		String style = element.getAttribute("style");
		
		JavascriptExecutor js = (JavascriptExecutor) Hooks.getDriver();
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red;')", element);
		
		try {
			Thread.sleep(waitSeconds*500);
			js.executeScript("arguments[0].setAttribute('style','"+style+"')", element);
		} catch (Exception e) {
			js.executeScript("arguments[0].setAttribute('style','"+style+"')", element);
		}
	}
	
	/**
	 * Metodo responsavel por exercer a funcao de click no elemento desejado
	 * 
	 * @param element - Elemento para interecao
	 * @throws IOException
	 */
	protected void click(WebElement element, String elementName) throws IOException {
		highlightElement(element, elementName);
		element.click();
	}

}