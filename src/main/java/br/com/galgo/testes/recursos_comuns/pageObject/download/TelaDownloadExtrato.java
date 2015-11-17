package br.com.galgo.testes.recursos_comuns.pageObject.download;

public class TelaDownloadExtrato extends TelaDownload {

	public void selecionarXML() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input");
	}

	@Override
	public void clicarBotaoConfirmar() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[3]/td/input[3]");
	}

}
