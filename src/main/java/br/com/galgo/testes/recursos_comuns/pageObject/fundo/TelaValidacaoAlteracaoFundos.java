package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaValidacaoAlteracaoFundos extends TelaPrincipal {

	public void clicarValidacaoInclusaoRegistro(
			TelaValidacaoAlteracaoFundos telaValidacao) {
		telaValidacao
				.clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td[1]/input");
	}

	public void verificaUltimaPagina() {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div[2]/div[6]/table[3]/tbody/tr/td[3]/a[2]")) {
			clicarItemPorXPath(getUltimaPagina());
		}
	}

	private String getUltimaPagina() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div[2]/div[6]/table[3]/tbody/tr/td[3]/a[2]";
	}
}
