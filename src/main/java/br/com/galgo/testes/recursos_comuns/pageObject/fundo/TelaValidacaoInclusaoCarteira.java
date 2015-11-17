package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaValidacaoInclusaoCarteira extends TelaPrincipal {

	public void clicarValidacaoInclusaoRegistro(
			TelaValidacaoInclusaoCarteira telaValidacaoInclusaoFundos) {
		telaValidacaoInclusaoFundos
				.clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td[1]/input");
	}

}

