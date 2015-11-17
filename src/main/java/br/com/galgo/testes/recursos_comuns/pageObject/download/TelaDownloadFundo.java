package br.com.galgo.testes.recursos_comuns.pageObject.download;

public class TelaDownloadFundo extends TelaDownload {

	@Override
	public void clicarBotaoConfirmar() {
		submeterFormulario();
	}

	private void submeterFormulario() {
		clicarItemPorClassName(classNameTeclaEnter());
	}

	private String classNameTeclaEnter() {
		return "enter";
	}

	@Override
	public String getIdCampoSenha() {
		return "pwd";
	}

}
