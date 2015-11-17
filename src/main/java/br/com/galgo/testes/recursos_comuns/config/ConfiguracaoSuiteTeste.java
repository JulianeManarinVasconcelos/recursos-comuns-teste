package br.com.galgo.testes.recursos_comuns.config;

import static br.com.galgo.testes.recursos_comuns.enumerador.data.FormatoData.DDMMYYYYHH;

import java.util.Date;

import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;

public class ConfiguracaoSuiteTeste {

	private Ambiente ambiente = Ambiente.PRODUCAO;
	private boolean usarPastaEvidenciaSuite;
	private boolean concatenarPastaSuiteETeste;
	private boolean usarAmbienteEvidenciaSuite;
	private String pastaEvidencia;

	public ConfiguracaoSuiteTeste(Ambiente ambiente, String nomeSuite,
			boolean usarAmbienteEvidenciaSuite, boolean usarCaminhoEvidenciaSuite,
			boolean concatenarPastaSuiteETeste) {
		this.ambiente = ambiente;
		this.pastaEvidencia = nomeSuite + " "
				+ DDMMYYYYHH.formata(new Date());
		this.usarPastaEvidenciaSuite = usarCaminhoEvidenciaSuite;
		this.usarAmbienteEvidenciaSuite = usarAmbienteEvidenciaSuite;
		this.concatenarPastaSuiteETeste = concatenarPastaSuiteETeste;
	}

	public boolean isConcatenarPastaSuiteETeste() {
		return concatenarPastaSuiteETeste;
	}

	public boolean isUsarPastaEvidenciaSuite() {
		return usarPastaEvidenciaSuite;
	}

	public boolean isUsarAmbienteEvidenciaSuite() {
		return usarAmbienteEvidenciaSuite;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public String getPastaEvidencia() {
		return pastaEvidencia;
	}

}
