package br.com.galgo.testes.recursos_comuns.pageObject.consulta;

import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroFundosOuCarteiras;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaConsultaCarteiras extends TelaPrincipal {

	public TelaFundosOuCarteiras clicarFiltroFundo() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[1]/tbody/tr[1]/td[3]/a/input");
		return new TelaFundosOuCarteiras();
	}

	public void buscarFundo(String cnpj) {
		TelaFundosOuCarteiras telaFundosOuCarteiras = clicarFiltroFundo();

		telaFundosOuCarteiras.incluirFiltro(CampoFiltroFundosOuCarteiras.CNPJ,
				cnpj);
		telaFundosOuCarteiras.clicarBotaoConfirmar();
		clicarPrimeiroItem();
		clicarConfirmar();
	}

	public void clicarConfirmar() {
		clicarItemPorName("btconfirmar");
	}

	public void clicarPrimeiroItem() {
		clicarItemPorName("listaFundoCarteiraSelecionados");
	}

}
