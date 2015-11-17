package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.file.entidades.Contas;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaContasFundo extends TelaPrincipal {

	public TelaDoctosAnexadosFundo preencherAba(Contas contas) {
		escolherBancoConstaCorrenteAplicacao(contas);
		preencherAgenciaContaCorrenteAplicacao(contas);
		preencherContaCorrenteAplicacao(contas);
		preencherCodSUSEP(contas);

		clicarProxima();
		return new TelaDoctosAnexadosFundo();
	}

	private void escolherBancoConstaCorrenteAplicacao(Contas contas) {
		preencherCampoSelectByXPath(
				contas.getBancoConstaCorrenteAplicacao().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[4]/div/table/tbody/tr[1]/td[2]/select");
	}

	private void preencherAgenciaContaCorrenteAplicacao(Contas contas) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/input",
				contas.getAgenciaContaCorrenteAplicacao());
	}

	private void preencherContaCorrenteAplicacao(Contas contas) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[4]/div/table/tbody/tr[3]/td[2]/input",
				contas.getContaCorrenteAplicacao());
	}

	private void preencherCodSUSEP(Contas contas) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[4]/div/table/tbody/tr[4]/td[2]/input",
				contas.getCodSUSEP());
	}

	private void clicarProxima() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[4]/div/div[3]/button[1]");
	}

}
