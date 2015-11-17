package br.com.galgo.testes.recursos_comuns.pageObject.consulta;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;


public class TelaDetalhesPLCota extends TelaPrincipal {

	public TelaConsultaPLCota voltar(){
		clicarItemPorId("voltar");
		return new TelaConsultaPLCota();
	}
	
	public void garanteDetalhesFundoOk(){
		garanteTextoNaTela("Código STI");
	}

}
