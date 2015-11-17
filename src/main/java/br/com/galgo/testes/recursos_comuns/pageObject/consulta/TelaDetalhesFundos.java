package br.com.galgo.testes.recursos_comuns.pageObject.consulta;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaDetalhesFundos extends TelaPrincipal {


	public void garanteDetalhesFundoOk() {
		garanteTextoNaTela("Código STI");
	}

	public TelaConsultaFundo voltar() {
		clicarItemPorName(getNameBotaoVoltar());
		return new TelaConsultaFundo();
	}

	private String getNameBotaoVoltar() {
		return "btvoltar";
	}
}
