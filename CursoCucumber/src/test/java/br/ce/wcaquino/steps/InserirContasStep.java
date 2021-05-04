package br.ce.wcaquino.steps;

import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import junit.framework.Assert;

public class InserirContasStep {
	
	private WebDriver driver;
	
	@Dado("que estou acessando a aplicação")
	public void que_estou_acessando_a_aplicação() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "/home/erik/Área de Trabalho/curso-cucumber-linux/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/");
	}

	@Quando("informo o usuário {string}")
	public void informo_o_usuário(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@Quando("a senha {string}")
	public void a_senha(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("senha")).sendKeys(arg1);
	}

	@Quando("seleciono entrar")
	public void seleciono_entrar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.tagName("button")).click();
	}

	@Então("visualizo a página inicial")
	public void visualizo_a_página_inicial() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String texto = driver.findElement(By.xpath("// div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Bem vindo, a!", texto);
	}

	@Quando("seleciono Contas")
	public void seleciono_Contas() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Contas")).click();
	}

	@Quando("seleciono Adicionar")
	public void seleciono_Adicionar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("informo a conta {string}")
	public void informo_a_conta(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("nome")).sendKeys(arg1);
	}

	@Quando("seleciono Salvar")
	public void seleciono_Salvar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.tagName("button")).click();
	}

	@Então("a conta é inserida com sucesso")
	public void a_conta_é_inserida_com_sucesso() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Conta adicionada com sucesso!", texto);
	}
	
	@Então("sou notificado que o nome da conta é obrigatório")
	public void sou_notificado_que_o_nome_da_conta_é_obrigatório() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	    Assert.assertEquals("Informe o nome da conta", texto);
	}
}