package br.com.galgo.testes.recursos_comuns.config;

import static br.com.galgo.testes.recursos_comuns.enumerador.data.FormatoData.DDMMYYYYHH;

import java.util.Date;

import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;

public class ConfiguracaoTeste {

	private Ambiente ambiente;
	private String pastaEvidencia;

	public ConfiguracaoTeste(Ambiente ambiente, String pastaTeste) {
		this.ambiente = ambiente;
		this.pastaEvidencia = pastaTeste + " "
				+ DDMMYYYYHH.formata(new Date());
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public String getPastaEvidencia() {
		return pastaEvidencia;
	}

	public void setPastaEvidencia(String pastaEvidencia) {
		this.pastaEvidencia = pastaEvidencia;
	}

}
