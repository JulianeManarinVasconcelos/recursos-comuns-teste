package br.com.galgo.testes.recursos_comuns.file.entidades;

import br.com.galgo.testes.recursos_comuns.enumerador.fundo.DataBaseAmortizacao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PeriodicidadeAmortizacao;

public class Amortizacao {

	private boolean possuiMecanismoAmortizacao;
	private String dataPrimeiraAmortizacao;
	private PeriodicidadeAmortizacao periodicidadeAmortizacao;
	private DataBaseAmortizacao dataBaseAmortizacao;
	private String diaUtilAmortizacao;
	private String observacoesAmortizacao;

	public Amortizacao(boolean possuiMecanismoAmortizacao,//
			String dataPrimeiraAmortizacao,//
			PeriodicidadeAmortizacao periodicidadeAmortizacao,//
			DataBaseAmortizacao dataBaseAmortizacao,//
			String diaUtilAmortizacao,//
			String observacoesAmortizacao) {
		super();
		this.possuiMecanismoAmortizacao = possuiMecanismoAmortizacao;
		this.dataPrimeiraAmortizacao = dataPrimeiraAmortizacao;
		this.periodicidadeAmortizacao = periodicidadeAmortizacao;
		this.dataBaseAmortizacao = dataBaseAmortizacao;
		this.diaUtilAmortizacao = diaUtilAmortizacao;
		this.observacoesAmortizacao = observacoesAmortizacao;
	}

	public boolean isPossuiMecanismoAmortizacao() {
		return possuiMecanismoAmortizacao;
	}

	public void setPossuiMecanismoAmortizacao(boolean possuiMecanismoAmortizacao) {
		this.possuiMecanismoAmortizacao = possuiMecanismoAmortizacao;
	}

	public String getDataPrimeiraAmortizacao() {
		return dataPrimeiraAmortizacao;
	}

	public void setDataPrimeiraAmortizacao(String dataPrimeiraAmortizacao) {
		this.dataPrimeiraAmortizacao = dataPrimeiraAmortizacao;
	}

	public PeriodicidadeAmortizacao getPeriodicidadeAmortizacao() {
		return periodicidadeAmortizacao;
	}

	public void setPeriodicidadeAmortizacao(
			PeriodicidadeAmortizacao periodicidadeAmortizacao) {
		this.periodicidadeAmortizacao = periodicidadeAmortizacao;
	}

	public DataBaseAmortizacao getDataBaseAmortizacao() {
		return dataBaseAmortizacao;
	}

	public void setDataBaseAmortizacao(DataBaseAmortizacao dataBaseAmortizacao) {
		this.dataBaseAmortizacao = dataBaseAmortizacao;
	}

	public String getDiaUtilAmortizacao() {
		return diaUtilAmortizacao;
	}

	public void setDiaUtilAmortizacao(String diaUtilAmortizacao) {
		this.diaUtilAmortizacao = diaUtilAmortizacao;
	}

	public String getObservacoesAmortizacao() {
		return observacoesAmortizacao;
	}

	public void setObservacoesAmortizacao(String observacoesAmortizacao) {
		this.observacoesAmortizacao = observacoesAmortizacao;
	}

}
