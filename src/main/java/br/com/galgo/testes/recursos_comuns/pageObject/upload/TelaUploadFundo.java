package br.com.galgo.testes.recursos_comuns.pageObject.upload;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.thread.FazerUpload;

public class TelaUploadFundo extends TelaPrincipal {

	public TelaResultadoUploadFundo incluirArquivo(final String senha,
			String path) {
		esperarSegundos(2);
		clicarBotaoAnexarArquivo();

		FazerUpload fazerUpload = new FazerUpload(path);
		fazerUpload.upload();

		preencherCampoSenha(senha);
		clicarBotaoEnviar();

		return new TelaResultadoUploadFundo();
	}

	public void clicarBotaoAnexarArquivo() {
		clicarItemPorId(getIdArquivoAnexado());
	}

	private String getIdArquivoAnexado() {
		return "arquivoAnexado";
	}

	private void clicarBotaoEnviar() {
		clicarItemPorName(getNameBotaoEnviar());
	}

	private void preencherCampoSenha(String senha) {
		String idCampoSenha = getIdCampoSenha();

		removerCampoReadOnlyPorId(idCampoSenha);
		preencheCampoPorId(idCampoSenha, senha);
	}

	private String getIdCampoSenha() {
		return "pwd";
	}

	private String getNameBotaoEnviar() {
		return "btnEnviarArquivo";
	}

}
