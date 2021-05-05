//Original code author: Francisco Wagner Costa Aquino (with adaptations)
//Contact: https://www.udemy.com/user/francisco-wagner-costa-aquino/
package br.ce.wcaquino.steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import junit.framework.Assert;

public class InserirContasStep {
	
	private WebDriver driver;
	
	@Dado("que desejo adicionar uma conta")
	public void que_desejo_adicionar_uma_conta() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "/home/erik/Área de Trabalho/curso-cucumber-linux/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/");
		driver.findElement(By.id("email")).sendKeys("a@a");
		driver.findElement(By.id("senha")).sendKeys("a");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("Contas")).click();
		driver.findElement(By.linkText("Adicionar")).click();
	    
	}

	@Quando("adiciono a conta {string}")
	public void adiciono_a_conta(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("nome")).sendKeys(arg1);
		driver.findElement(By.tagName("button")).click();
	}
	
	@SuppressWarnings("deprecation")
	@Então("recebo a mensagem {string}")
	public void receboAMensagem(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String texto = driver.findElement(By.xpath("//div[starts-with(@class='alert alert-')]")).getText();
	    Assert.assertEquals(arg1, texto);
	}
	
	@After(order = 1, value = "@funcionais")
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(order = 0, value = "@funcionais")
	public void fecharBrowser() {
		driver.quit();
		System.out.println("terminado");
	}
}