//Original code author: Francisco Wagner Costa Aquino (with adaptations)
//Contact: https://www.udemy.com/user/francisco-wagner-costa-aquino/
package br.ce.wcaquino.steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import cucumber.api.PendingException;
import io.cucumber.core.cli.Main;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;


@SuppressWarnings("unused")
public class AprenderCucumberSteps {

// public void que_criei_o_arquivo_corretamente() throws Throwable {
	@Dado("que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable{
		System.out.println("qualquer coisa");
	}
	
	@Quando("executá-lo$")
	public void executáLo() throws Throwable{
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
	
	@Então("a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
	
	private int contador = 0;
	
	@Dado("que o valor do contador é {int}")
	public void queOValorDoContadorÉ(Integer int1) throws Throwable {
	    contador = int1;
	    String valorContador = Integer.toString(contador);
	}

	@Quando("eu incrementar em {int}")
	public void euIncrementarEm(Integer int1) throws Throwable {
	    contador = contador + int1;
	}

	@Então("o valor do contador será {int}")
	public void oValorDoContadorSerá(Integer int1) throws Throwable {
		contador = int1;
	    // Assert.assertEquals(int1, contador);
	}
	
	Date entrega = new Date();
	
	@Dado("que a entrega é dia (.*)$")
	public void queAEntregaÉDia(Date data) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		entrega = data;
		System.out.println(entrega);
	    throw new cucumber.api.PendingException();
	}

	@Quando("a entrega atrasar em {int} dias")
	public void aEntregaAtrasarEmDias(Integer dia, String tempo) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		if (tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, dia);
		}
		if (tempo.equals("meses")) {
			cal.add(Calendar.MONTH, dia);
		}
		entrega = cal.getTime();
	    throw new cucumber.api.PendingException();
	}
	
	@Quando("a entrega atrasar em {int} meses")
	public void aEntregaAtrasarEmMeses(Integer meses) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Então("a entrega será efetuada em {int}\\/{int}\\/{int}")
	public void aEntregaSeráEfetuadaEm(String data) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data, dataFormatada);
	    throw new cucumber.api.PendingException();
	}
	
	@Dado("que o ticket é AF{int}")
	public void que_o_ticket_é_AF(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@Dado("que o ticket é AB{int}")
	public void que_o_ticket_é_AB(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Dado("que o ticket especial é AB{int}")
	public void que_o_ticket_especial_é_AB(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Dado("que o valor da passagem é R$ {double}")
	public void queOValorDaPassagemÉR$(Double valorPassagem) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Dado("que o nome do passageiro é {string}")
	public void queONomeDoPassageiroÉ(String nomePassageiro) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Dado("que o telefone do passageiro é {int}{int}")
	public String queOTelefoneDoPassageiroÉ(Integer num1, Integer num2) {
	    // Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}
	
	@Dado("que o ticket é CD{int}")
	public void queOTicketÉCD(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Dado("que o ticket é AG{int}")
	public void queOTicketÉAG(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Dado("que o valor da passagem é R$ {double}{double}")
	public void queOValorDaPassagemÉR$(Double double1, Double double2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Quando("criar os steps")
	public void criarOsSteps() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Então("o teste vai funcionar")
	public void oTesteVaiFuncionar() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
}