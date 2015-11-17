package br.com.galgo.testes.recursos_comuns.file.entidades;

import br.com.galgo.testes.recursos_comuns.enumerador.fundo.BancoContaCorrente;

public class Contas {

	private BancoContaCorrente bancoConstaCorrenteAplicacao;
	private String agenciaContaCorrenteAplicacao;
	private String contaCorrenteAplicacao;
	private String codSUSEP;

	public Contas(BancoContaCorrente bancoConstaCorrenteAplicacao,
			String agenciaContaCorrenteAplicacao,
			String constaCorrenteAplicacao, String codSUSEP) {
		super();
		this.bancoConstaCorrenteAplicacao = bancoConstaCorrenteAplicacao;
		this.agenciaContaCorrenteAplicacao = agenciaContaCorrenteAplicacao;
		this.contaCorrenteAplicacao = constaCorrenteAplicacao;
		this.codSUSEP = codSUSEP;
	}

	public BancoContaCorrente getBancoConstaCorrenteAplicacao() {
		return bancoConstaCorrenteAplicacao;
	}

	public void setBancoConstaCorrenteAplicacao(
			BancoContaCorrente bancoConstaCorrenteAplicacao) {
		this.bancoConstaCorrenteAplicacao = bancoConstaCorrenteAplicacao;
	}

	public String getAgenciaContaCorrenteAplicacao() {
		return agenciaContaCorrenteAplicacao;
	}

	public void setAgenciaContaCorrenteAplicacao(
			String agenciaContaCorrenteAplicacao) {
		this.agenciaContaCorrenteAplicacao = agenciaContaCorrenteAplicacao;
	}

	public String getContaCorrenteAplicacao() {
		return contaCorrenteAplicacao;
	}

	public void setContaCorrenteAplicacao(String contaCorrenteAplicacao) {
		this.contaCorrenteAplicacao = contaCorrenteAplicacao;
	}

	public String getCodSUSEP() {
		return codSUSEP;
	}

	public void setCodSUSEP(String codSUSEP) {
		this.codSUSEP = codSUSEP;
	}

}
