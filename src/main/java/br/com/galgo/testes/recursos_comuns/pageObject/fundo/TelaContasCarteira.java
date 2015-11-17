package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaContasCarteira extends TelaPrincipal {

	public TelaCamposAnbid preencherAba(String codSUSEP) {
		preencherCodSUSEP(codSUSEP);

		clicarProxima();
		return new TelaCamposAnbid();
	}

	private void preencherCodSUSEP(String codSusep) {
		preencheCampoPorId("codigoSUSEP", codSusep);
	}

	private void clicarProxima() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/div[1]/button[1]");
	}

}
