package br.com.galgo.testes.recursos_comuns.pageObject.compromisso;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaCompromissosDetalhes extends TelaPrincipal {

	public TelaPainelCompromissos clicarVoltar() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[24]/td/input");
		return new TelaPainelCompromissos();
	}

	public String getNomeFundo() {
		return encontrarCampoPorXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[7]/td[2]")
				.getText();
	}

	public String getFundoCotista() {
		return encontrarCampoPorXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[8]/td[2]")
				.getText();
	}

}
