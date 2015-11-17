package br.com.galgo.testes.recursos_comuns.pageObject.cancelamento;

import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.Tela;

public interface TelaCancelamento extends Tela {

	public final int MAX_TENTATIVAS = 5;

	public void cancelar(String dataFiltro, String codigoSTI) throws Exception;

	public void cancelarArquivo(String dataFiltro, String codigoSTI,
			Usuario usuario, String pathArquivoCancelamento) throws Exception;

}
