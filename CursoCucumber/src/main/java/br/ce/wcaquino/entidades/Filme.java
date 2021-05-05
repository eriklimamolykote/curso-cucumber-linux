//Original code author: Francisco Wagner Costa Aquino (with adaptations)
//Contact: https://www.udemy.com/user/francisco-wagner-costa-aquino/
package br.ce.wcaquino.entidades;

public class Filme {
	private int estoque;
	private int aluguel;

	public void setEstoque(Integer arg1) {
		this.estoque = arg1;
	}

	public void setAluguel(Integer arg1) {
		this.aluguel = arg1;
	}

	public int getAluguel() {
		return aluguel;
	}

	public int getEstoque() {
		return estoque;
	}

}
