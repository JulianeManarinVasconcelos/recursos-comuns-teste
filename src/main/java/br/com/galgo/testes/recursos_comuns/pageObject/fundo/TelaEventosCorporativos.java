package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaEventosCorporativos extends TelaPrincipal {

	public TelaAlteracaoAdmin clicarBotaoAlterarAdmin() {
		clicarItemPorId("alterarAdministrador");
		return new TelaAlteracaoAdmin();
	}

	public TelaIncorporacao clicarBotaoIncorporacao() {
		clicarItemPorId("incorporacaoFusao");
		return new TelaIncorporacao();
	}

	public TelaConferencia clicarBotaoConferencia() {
		clicarItemPorId("confirmarEventos");
		return new TelaConferencia();
	}

}
