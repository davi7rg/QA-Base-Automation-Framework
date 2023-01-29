package com.snowmanlabs.framework.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.snowmanlabs.framework.hooks.Hooks;
import com.snowmanlabs.framework.utils.GeneralMethods;

/**
 * 
 * Classe reponsavel por mapeamento de objetos e implementacao dos metodos de validacao dos steps dos testes
 * 
 * @author Davi Rodrigues - Analista de QA Senior 1
 * @since Agosto/2020
 * @version 0.1 - Snowman Labs
 * 
 */

public class ClassPageExample extends GeneralMethods {
	
	/**
	 * Contrutor da classe inicializando a pagina acessada atraves do PageFactory
	 */
	public ClassPageExample() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}
	
	//Mapeamento de Elementos
	
	@FindBy(id = "buttonOK")
	protected WebElement buttonOKID;
	
	@FindBy(xpath = "//div[@id='buttonOK']//a[contains(text(),'OK')]")
	protected WebElement buttonOKXpath;
	
	//Metodos para validacao dos Steps(Passos dos cenarios)
	
	public void validateElementExample() {
		
		try {
			highlightElement(buttonOKID, "Botao 'ENTRAR'");
			logPassed("Botao OK via ID encontrado com sucesso");
		} catch (IOException e) {
			logFailed("Botao OK via ID nao encontrado");
		}
		
	}
	
	public void validateElementExample2() {
		
		try {
			highlightElement(buttonOKXpath, "Botao 'ENTRAR'");
			logPassed("Botao OK via Xpath encontrado com sucesso");
		} catch (IOException e) {
			logFailed("Botao OK via Xpath nao encontrado");
		}
		
	}

}