package br.com.galgo.testes.recursos_comuns.exception;

public class ErroAoInstanciarTelaDeBusca extends Exception {

	private static final long serialVersionUID = 1L;
	private String tela;

	public ErroAoInstanciarTelaDeBusca(String tela) {
		this.tela = tela;
	}

	@Override
	public String getMessage() {
		return "Nao foi possivel instanciar a tela de busca " + tela;
	}

}
