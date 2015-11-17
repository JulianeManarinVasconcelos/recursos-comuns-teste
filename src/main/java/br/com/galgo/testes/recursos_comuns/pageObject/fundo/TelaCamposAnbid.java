package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaCamposAnbid extends TelaPrincipal {

	public TelaDoctosAnexadosCarteira preencherAba(boolean divulgacaoAnbid) {
		escolherDivulgacaoAnbid(divulgacaoAnbid);

		clicarProxima();
		return new TelaDoctosAnexadosCarteira();
	}

	private void escolherDivulgacaoAnbid(boolean divulgacaoAnbid) {
		if (divulgacaoAnbid) {
			escolherSim();
		} else {
			escolherNao();
		}
	}

	private void escolherNao() {
		if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr/td[4]/input")) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr/td[4]/input");
		}
	}

	private void escolherSim() {
		if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr/td[2]/input")) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr/td[2]/input");
		}
	}

	private void clicarProxima() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/div[1]/button[1]");
	}

}
