package br.com.galgo.testes.recursos_comuns.pageObject.reenvio;

import java.text.ParseException;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioInfoAnbimaPortal;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioPlCota;

public class TelaJustificativaReenvioPlCotaPortal extends TelaPrincipal {

	private String codSTI;
	private String dataBase;

	public TelaJustificativaReenvioPlCotaPortal(String codSTI, String dataBase) {
		this.codSTI = codSTI;
		this.dataBase = dataBase;
	}

	public TelaEnvioPlCota justificar() throws ParseException {
		preencherJustificativa();
		clicarConfirmar();
		return new TelaEnvioPlCota(codSTI, dataBase);
	}

	public TelaEnvioInfoAnbimaPortal justificarInfoAnbima()
			throws ParseException {
		preencherJustificativa();
		clicarConfirmar();
		return new TelaEnvioInfoAnbimaPortal(codSTI, dataBase);
	}

	private void clicarConfirmar() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[2]/td/input[2]");
	}

	private void preencherJustificativa() {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/textarea",
				"Teste");
	}

}
