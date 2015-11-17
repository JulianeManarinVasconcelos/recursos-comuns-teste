package br.com.galgo.testes.recursos_comuns.pageObject.download;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.thread.FazerDownload;

public class TelaDownload extends TelaPrincipal {

	public void fazerDownload(String pathArquivo) {
		int tentativas = 0;
		FazerDownload fazerDownload = new FazerDownload(pathArquivo);
		
		if (!fazerDownload.download()) {
			while (continuarTentando(tentativas, getMsgErro())) {
				if (fazerDownload.download()) {
					break;
				}
			}
		}
		Assert.assertFalse("Download do arquivo não iniciado.",
				verificaTextoNaTela(getMsgErro()));
	}

	public TelaDownloadFundo download() {
		selecionarPrimeiroItem();
		return (TelaDownloadFundo) clicarBotaoDownload();
	}

	private void selecionarPrimeiroItem() {
		clicarItemPorName(getNamePrimeiroItem());
	}

	public TelaDownload clicarBotaoDownload() {
		clicarItemPorId(getIdBotaoDownload());
		return new TelaDownloadFundo();
	}

	public void preencherCampoSenha(String senha) {
		String idCampoSenha = getIdCampoSenha();

		removerCampoReadOnlyPorId(idCampoSenha);
		preencheCampoPorId(idCampoSenha, senha);
	}

	public String getIdCampoSenha() {
		return "senha";
	}

	private String getIdBotaoDownload() {
		return "btDowload";
	}

	private String getNamePrimeiroItem() {
		return "idVersaoRegistroDownload";
	}

	public String getMsgErro() {
		return "Ocorreu um erro no sistema. Por favor, entre em contato com o Suporte ao Usuário e informe a ocorrência código 53.";
	}

}
