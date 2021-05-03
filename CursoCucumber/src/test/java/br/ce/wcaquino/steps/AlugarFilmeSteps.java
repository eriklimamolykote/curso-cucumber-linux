package br.ce.wcaquino.steps;

import io.cucumber.java.pt.Então;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert.*;

import br.ce.wacquino.utils.DateUtils;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.NotaAluguel;
import br.ce.wcaquino.entidades.TipoAluguel;
import br.ce.wcaquino.servicos.AluguelService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import junit.framework.Assert;

public class AlugarFilmeSteps {
	
	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel tipoAluguel = TipoAluguel.COMUM;
	
	@Dado("um filme com estoque de {int} unidades")
	public void um_filme_com_estoque_de_unidades(Integer arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		filme = new Filme();
		filme.setEstoque(arg1);
	    throw new cucumber.api.PendingException();
	}

	@Dado("que o preço do aluguel seja R$ {int}")
	public void que_o_preço_do_aluguel_seja_R$(Integer arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		filme.setAluguel(arg1);
	    throw new cucumber.api.PendingException();
	}

	@Quando("alugar")
	public void alugar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try{
			// nota = aluguel.alugar(filme, "extendido");
		} catch(RuntimeException e){
			erro = e.getMessage();
			throw new cucumber.api.PendingException();
		}
	    
	}

	@SuppressWarnings("deprecation")
	@Então("o preço do aluguel será R$ {int}")
	public void o_preço_do_aluguel_será_R$(Integer arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// Assert.assertEquals(arg1, nota.getPreco());
	    throw new cucumber.api.PendingException();
	}

	@Então("o estoque do filme será {int} unidade")
	public void o_estoque_do_filme_será_unidade(Integer arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// Assert.assertEquals(arg1, filme.getEstoque());
	    throw new cucumber.api.PendingException();
	}
	
	@Dado("um filme estoque de {int} unidades")
	public void um_filme_estoque_de_unidades(Integer int1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@SuppressWarnings("deprecation")
	@Então("não será possível por falta de estoque")
	public void não_será_possível_por_falta_de_estoque() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("Filme sem estoque", erro);
	    throw new cucumber.api.PendingException();
	}
	
	@Dado("que o tipo do aluguel seja {string}")
	public void que_o_tipo_do_aluguel_seja_extendido(String tipo) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	    throw new cucumber.api.PendingException();
	}

	@SuppressWarnings("deprecation")
	@Então("a data de entrega será em {int} dias")
	public void a_data_de_entrega_será_em_dias(Integer arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Date dataEsperada = DateUtils.obterDataDiferencaDias(arg1);
		Date dataReal = nota.getDataEntrega();
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	    throw new cucumber.api.PendingException();
	}

	@SuppressWarnings("deprecation")
	@Então("a pontuação será de {int} pontos")
	public void a_pontuação_será_de_pontos(Integer arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// Assert.assertEquals(arg1, nota.getPontuacao());
	    throw new cucumber.api.PendingException();
	}
	
}
