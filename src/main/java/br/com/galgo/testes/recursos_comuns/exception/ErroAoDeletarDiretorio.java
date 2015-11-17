package br.com.galgo.testes.recursos_comuns.exception;

public class ErroAoDeletarDiretorio extends Exception {

	private static final long serialVersionUID = 1L;
	private String diretorio;

	public ErroAoDeletarDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	@Override
	public String getMessage() {
		return "Nao foi possivel deletar o arquivo do diretório " + diretorio;
	}

}
