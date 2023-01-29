package com.snowmanlabs.framework.hooks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * Classe responsavel por organizar as configuracoes iniciais e finais referente a bateria de execucao
 * dos testes
 * 
 * @author Davi Rodrigues - Analista de QA Senior 1
 * @since Agosto/2020
 * @version 0.1 - Snowman Labs
 * 
 */

public class Hooks {

	private static WebDriver driver;
	private static ExtentHtmlReporter extentHtmlReporter;
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	Properties properties = System.getProperties();
	
	/**
	 * Metodo para retornar a instancia do driver
	 * @return driver
	 */
	public static WebDriver getDriver() {
		
		return driver;
		
	}
	
	/**
	 * Metodo para retonar o teste que esta sendo efetuado
	 * @return extentTest
	 */
	public static ExtentTest getExtentTest() {
		
		return extentTest;
		
	}
	
	/**
	 * Metodo para formatar nome do Report de execucao com dia e horario precisos
	 * @return nomeReportFormatado
	 */
	private static String formatarNomeReport() {
		LocalDateTime dataHoraAgora = LocalDateTime.now();
		DateTimeFormatter dataHoraFormatada = DateTimeFormatter.ofPattern("dd_MM_yy_HH_mm_ss");
		String nomeReportFormatado = dataHoraAgora.format(dataHoraFormatada);
		
		return nomeReportFormatado;
		
	}
	
	/**
	 * Metodo executado antes da iniciacao dos testes
	 * @param scenario
	 */
	@Before
	public void beforeScenario(Scenario scenario) {
		String nomeReportFormatado = formatarNomeReport();

		try {
			if (extentReports == null) {
				extentReports = new ExtentReports();
				extentHtmlReporter = new ExtentHtmlReporter("src/test/resources/evidencias/Reporter_" + nomeReportFormatado + ".html");
				extentReports.attachReporter(extentHtmlReporter);
			}
			extentTest = extentReports.createTest(scenario.getName());

			if (properties.getProperty("os.name").toUpperCase().contains("WINDOWS")) {

				System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");

			} else {

				System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver");
			}

			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to("https://www.google.com/");
		} catch (Exception e) {
			Assert.fail("Falha na inicialização do framework");
		}
		
	}
	
	/**
	 * Metodo executado apos a conclusao dos testes
	 * @param scenario
	 */
	@After
	public void afterScenario(Scenario scenario) {

		try {

			if (scenario.isFailed()) {
				extentTest.log(Status.FAIL, "Cenário \"" + scenario.getName() + "\" executado com falhas");
				extentReports.flush();
			} else {
				extentTest.log(Status.PASS, "Cenário \"" + scenario.getName() + "\" executado com sucesso");
				extentReports.flush();
			}

			if (driver != null) {
				driver.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Falha na finalização do framework");
		}
	}
	
}