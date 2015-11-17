package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaFundo;

public class TelaAlteracaoCarteira extends TelaPrincipal {

	public TelaConsultaFundo clicarBotaoAlterarCarteira() {
		clicarItemPorId("btAlterarCarteira");
		return new TelaConsultaFundo();
	}

	public void validaAlteracaoSucesso() {
		try {
			verificaTextoNaTela("Em Elaboração");
		} catch (Exception e) {
			Assert.fail("Erro ao cadastrar o fundo");
		}
	}

}
