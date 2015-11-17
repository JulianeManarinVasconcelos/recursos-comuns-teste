package br.com.galgo.testes.recursos_comuns.exception;

public class ErroAoMudarLocalArquivo extends Exception {

	private static final long serialVersionUID = 1L;
	private String pathAtual;
	private String novoPath;

	public ErroAoMudarLocalArquivo(String pathAtual, String novoPath) {
		this.pathAtual = pathAtual;
		this.novoPath = novoPath;
	}

	@Override
	public String getMessage() {
		return "Nao foi possivel mover o arquivo do diretório " + pathAtual
				+ " para o diretório " + novoPath;
	}

}
