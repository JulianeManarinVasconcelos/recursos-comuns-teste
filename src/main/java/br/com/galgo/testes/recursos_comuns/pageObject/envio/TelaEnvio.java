package br.com.galgo.testes.recursos_comuns.pageObject.envio;

import java.text.ParseException;

import br.com.galgo.testes.recursos_comuns.pageObject.Tela;

public interface TelaEnvio extends Tela {

	public final int MAX_TENTATIVAS = 5;
	public static final String VALOR_ENVIO = "1";
	public static final String VALOR_REENVIO = "2";

	public void enviar() throws ParseException;

}
