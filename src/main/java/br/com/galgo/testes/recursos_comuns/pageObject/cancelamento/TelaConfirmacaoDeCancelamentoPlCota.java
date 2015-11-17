package br.com.galgo.testes.recursos_comuns.pageObject.cancelamento;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaConfirmacaoDeCancelamentoPlCota extends TelaPrincipal {

	public void confirmarCancelamento() throws Exception {
		clicarSelecionarTodos();
		preencheJustificativa();
		clicarConfirmar();
	}

	private void clicarConfirmar() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[4]/div/div[1]/div/input[2]");
	}

	private void preencheJustificativa() {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[2]/p/textarea",
				"Teste");
	}

	public void clicarSelecionarTodos() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[1]/div[1]/p/input");
	}

}
