package br.com.galgo.testes.recursos_comuns.thread;

public class FazerUpload {

	public String PATH_ARQUIVO_UPLOAD;

	public FazerUpload(String pathArquivo) {
		PATH_ARQUIVO_UPLOAD = pathArquivo;
	}

	public void upload() {
		upload(true);
	}

	public void upload(boolean alterarPath) {
		// executarAutoIt.executar(ConstantesTestes.PATH_EXECUTAVEL_UPLOAD,
		// PATH_ARQUIVO_UPLOAD, false, alterarPath);
	}
}
