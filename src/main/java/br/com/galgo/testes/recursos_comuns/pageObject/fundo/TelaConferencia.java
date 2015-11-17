package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaEntidade;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaFundo;

public class TelaConferencia extends TelaPrincipal {

	public TelaConsultaFundo clicarBotaoIncluirFundo() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[2]/tbody/tr[1]/td[3]/a/input");
		return new TelaConsultaFundo();
	}

	public TelaConsultaEntidade clicarBotaoIncluirAdmin() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[2]/tbody/tr[2]/td[3]/a/img");
		return new TelaConsultaEntidade();
	}

	public void preencheDataEvento(String dataEvento) {
		preencheCampoPorId("id_evento_dia", dataEvento);
	}

	@Override
	public void clicarBotaoConfirmar() {
		clicarItemPorId("btnConfirmar");
	}

	public void clicarItem() {
		clicarItemPorId("radMarcar");
	}

	public void clicarConfirmar() {
		clicarItemPorId("btConfirmar");
	}

	public void clicarAceitar() {
		clicarItemPorId("btaceitar");
	}
}
