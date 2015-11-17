package br.com.galgo.testes.recursos_comuns.exception;

public class ErroAplicacao extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	public ErroAplicacao(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
