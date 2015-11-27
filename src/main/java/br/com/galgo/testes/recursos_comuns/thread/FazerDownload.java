package br.com.galgo.testes.recursos_comuns.thread;

import br.com.galgo.testes.recursos_comuns.file.ArquivoUtils;
import br.com.galgo.testes.recursos_comuns.utils.ConstantesTestes;

public class FazerDownload {

	private String pathArquivo;

	public FazerDownload(String pathArquivo) {
		this.pathArquivo = pathArquivo;

	}

	public String getPathArquivo() {
		return pathArquivo;
	}

	public boolean download() {
		return true;
		// pathArquivo = ArquivoUtils.getPathConsulta(pathArquivo, ".xml");
		// ExecutarAutoIt executarAutoIt = new ExecutarAutoIt();
		// boolean retorno = executarAutoIt.executar(
		// ConstantesTestes.PATH_EXECUTAVEL_DOWNLOAD, pathArquivo, true);
		// pathArquivo = executarAutoIt.getPathArquivo();
		// return retorno;
	}
}
