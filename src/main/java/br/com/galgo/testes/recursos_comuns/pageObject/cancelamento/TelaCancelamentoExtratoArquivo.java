package br.com.galgo.testes.recursos_comuns.pageObject.cancelamento;

import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.thread.FazerUpload;
import br.com.galgo.testes.recursos_comuns.thread.FecharTelaDeRecibo;

public class TelaCancelamentoExtratoArquivo extends TelaPrincipal {

	public void cancelarPorArquivo(Usuario usuario, String pathArquivo)
			throws Exception {
		clicarSelecionarArquivo();

		FazerUpload fazerUpload = new FazerUpload(pathArquivo);
		fazerUpload.upload();

		preencherSenha(usuario);
		clicarEnviarArquivo();

		FecharTelaDeRecibo fecharTelaDeRecibo = new FecharTelaDeRecibo();
		fecharTelaDeRecibo.fechar();
		clicarVoltar();
	}

	private void clicarVoltar() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[3]/td/input[2]");
	}

	private void preencherSenha(Usuario usuario) {
		removerCampoReadOnlyPorXPath(getXPathSenha());
		preencheCampoXPath(getXPathSenha(), usuario.getSenha());
	}

	private String getXPathSenha() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td[2]/input";
	}

	private void clicarSelecionarArquivo() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/input");
	}

	private void clicarEnviarArquivo() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[3]/td/input[3]");
	}

}
