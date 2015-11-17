package br.com.galgo.testes.recursos_comuns.file.entidades;

public class Evento {

	public boolean fundoInicializadoPorEventoCorp;
	public String evento;
	public String fundoInvestimentoOrigem;

	public Evento(boolean fundoInicializadoPorEventoCorp, String evento,
			String fundoInvestimentoOrigem) {
		super();
		this.fundoInicializadoPorEventoCorp = fundoInicializadoPorEventoCorp;
		this.evento = evento;
		this.fundoInvestimentoOrigem = fundoInvestimentoOrigem;
	}

	public boolean isFundoInicializadoPorEventoCorp() {
		return fundoInicializadoPorEventoCorp;
	}

	public void setFundoInicializadoPorEventoCorp(
			boolean fundoInicializadoPorEventoCorp) {
		this.fundoInicializadoPorEventoCorp = fundoInicializadoPorEventoCorp;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getFundoInvestimentoOrigem() {
		return fundoInvestimentoOrigem;
	}

	public void setFundoInvestimentoOrigem(String fundoInvestimentoOrigem) {
		this.fundoInvestimentoOrigem = fundoInvestimentoOrigem;
	}

}
