package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaInclusaoCarteira extends TelaPrincipal {

	public TelaIdentificacaoCarteira clicarBotaoIncluirCarteira() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[4]/table/tbody/tr[2]/td/input[1]");
		return new TelaIdentificacaoCarteira();
	}

	public void validaInclusaoSucesso() {
		try {
			verificaTextoNaTela("Em Elaboração");
		} catch (Exception e) {
			Assert.fail("Erro ao cadastrar o fundo");
		}
	}

}
