package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaDatasCarteira extends TelaPrincipal {

	public TelaPrestadoresServicoCarteira preencherAba(
			String dataInicioAtividade) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr/td[2]/div[1]/input",
				dataInicioAtividade);
		clicarProxima();
		return new TelaPrestadoresServicoCarteira();
	}

	public TelaPrestadoresServicoCarteira preencherAba(
			String dataVigenciaAteracao, String dataVinculacaoANBID,
			String dataDesvinculacaoANBID) {
		preencheCampoPorId("", dataVigenciaAteracao);
		preencheCampoPorId("", dataVinculacaoANBID);
		preencheCampoPorId("", dataDesvinculacaoANBID);
		clicarProxima();
		return new TelaPrestadoresServicoCarteira();
	}

	private void clicarProxima() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/div[1]/button[1]");
	}

}
