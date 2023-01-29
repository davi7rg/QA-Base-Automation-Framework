package com.snowmanlabs.framework.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.snowmanlabs.framework.hooks.Hooks;

/**
 * 
 * Classe reponsavel pela captura dos logs e evidencias para formacao do report de execucao
 * 
 * @author Davi Rodrigues - Analista de QA Senior 1
 * @since Agosto/2020
 * @version 0.1 - Snowman Labs
 * 
 */

public class ReporterMethods {
	
	/**
	 * Metodo para gerar arquivo de captura de tela do teste
	 * 
	 * @param log - Nome do arquivo
	 * @throws IOException
	 */
	private static void printScreen(String log) throws IOException {
		
		File file = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,
				new File(System.getProperty("user.dir") + "/src/test/resources/evidencias/" + log +".png"));
		
	}
	
	/**
	 * Metodo para adicionar evidencia de tela do teste no relatorio
	 * 
	 * @param log - Nome do arquivo
	 * @throws IOException
	 */
	public static void logPrintScreen(String log) throws IOException {
		String nomeLogFormatado = formatarNomeLog(log);
		
		ExtentTest extentTest = Hooks.getExtentTest();
		printScreen(nomeLogFormatado);
		extentTest.log(Status.INFO, log,
				MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") + 
						"/src/test/resources/evidencias/" + nomeLogFormatado + ".png").build());
		
	}
	
	/**
	 * Metodo para formatar nome do print de evidencia com dia e horario precisos
	 * 
	 * @param log - Nome do arquivo
	 * @return nomeLogFormatado
	 */
	private static String formatarNomeLog(String log) {
		LocalDateTime dataHoraAgora = LocalDateTime.now();
		DateTimeFormatter dataHoraFormatada = DateTimeFormatter.ofPattern("dd_MM_yy_HH_mm_ss");
		String nomeLogFormatado = log + "_" + dataHoraAgora.format(dataHoraFormatada);
		
		return nomeLogFormatado;
	}
	
	/**
	 * Metodo para inserir mensagem no relatorio quando a validacao e realizada com sucesso
	 * 
	 * @param log - Mensagem que sera inserida no relatorio
	 */
	public static void logPassed(String log) {
		
		ExtentTest extentTest = Hooks.getExtentTest();
		extentTest.log(Status.PASS, log);
		
	}
	
	/**
	 * Metodo para inserir mensagem no relatorio quando a validacao nao e realizada com sucesso
	 * 
	 * @param log - Mensagem que sera inserida no relatorio
	 */
	public static void logFailed(String log) {
		
		ExtentTest extentTest = Hooks.getExtentTest();
		extentTest.log(Status.FAIL, log);
		
	}


}