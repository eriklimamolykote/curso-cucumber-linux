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
public class AprenderCucumber {

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
	
	@Dado("que a entrega é dia {int}\\/{int}\\/{int}")
	public void queAEntregaÉDia(Integer dia, Integer mes, Integer ano) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, dia);
		cal.set(Calendar.MONTH, mes - 1);
		cal.set(Calendar.YEAR, ano);
		entrega = cal.getTime();
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
}