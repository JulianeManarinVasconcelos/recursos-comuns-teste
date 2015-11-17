package br.com.galgo.testes.recursos_comuns.thread;

import br.com.galgo.testes.recursos_comuns.utils.ConstantesTestes;

public class FecharTelaDeRecibo {

	public String PATH_ARQUIVO;

	public FecharTelaDeRecibo() {
		PATH_ARQUIVO = "";
	}

	public FecharTelaDeRecibo(String pathArquivo) {
		PATH_ARQUIVO = pathArquivo;
	}

	public void fechar() {
		ExecutarAutoIt executarAutoIt = new ExecutarAutoIt();
		executarAutoIt.executar(ConstantesTestes.PATH_EXECUTAVEL_FECHA_RECIBO,
				"", false);
	}
}
