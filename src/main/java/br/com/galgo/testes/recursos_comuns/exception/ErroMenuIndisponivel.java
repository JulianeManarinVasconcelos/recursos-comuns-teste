package br.com.galgo.testes.recursos_comuns.exception;

public class ErroMenuIndisponivel extends ErroAplicacao {

	private static final long serialVersionUID = 1L;

	public ErroMenuIndisponivel(String link, String nomeUsuario) {
		super("Menu " + link + " não encontrado para o usuário " + nomeUsuario
				+ ".");
	}

}
