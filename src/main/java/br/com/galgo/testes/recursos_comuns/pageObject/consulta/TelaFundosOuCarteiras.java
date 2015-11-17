package br.com.galgo.testes.recursos_comuns.pageObject.consulta;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroFundosOuCarteira;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroFundosOuCarteiras;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaFundosOuCarteiras extends TelaPrincipal {

	public void incluirFiltro(CampoFiltroFundosOuCarteiras filtro,
			String valorCampoInput) {
		FiltroFundosOuCarteira filtroFundosOuCarteira = filtro.getFiltro();
		if (filtroFundosOuCarteira.getTipoCampo() == TipoCampo.RADIO) {
			clicarItemPorId(filtro.getCampo());
		} else if (filtroFundosOuCarteira.getTipoCampo() == TipoCampo.SELECT) {
			if (TipoAtributo.XPATH == filtro.getTipoAtributo()) {
				preencherCampoSelectByXPath(filtro.getDescricao(),
						filtro.getCampo());
			} else {
				preencherCampoSelect(filtro.getDescricao(), filtro.getCampo());
			}
		} else if (filtroFundosOuCarteira.getTipoCampo() == TipoCampo.INPUT) {
			if (TipoAtributo.ID == filtro.getTipoAtributo()) {
				preencheCampoPorId(filtro.getCampo(), valorCampoInput);
			} else {
				if (TipoAtributo.XPATH == filtro.getTipoAtributo()) {
					preencheCampoXPath(filtro.getCampo(), valorCampoInput);
				}
			}
		} else if (filtroFundosOuCarteira.getTipoCampo() == TipoCampo.BUSCA) {
			clicarCampoBusca(filtro);
		}
	}

	private void clicarCampoBusca(CampoFiltroFundosOuCarteiras filtro) {
		if (filtro.getTipoAtributo() == TipoAtributo.ID) {
			clicarItemPorId(filtro.getCampo());
		} else if (filtro.getTipoAtributo() == TipoAtributo.NAME) {
			clicarItemPorName(filtro.getCampo());
		} else if (filtro.getTipoAtributo() == TipoAtributo.XPATH) {
			clicarItemPorXPath(filtro.getCampo());
		} else if (filtro.getTipoAtributo() == TipoAtributo.CSS) {
			clicarItemPorCss(filtro.getCampo());
		}
	}

	public void escolherPrimeiroItem() {
		try {
			escolherPrimeiroItem(5, 3);
		} catch (Exception e) {
			escolherPrimeiroItem(6, 3);
		}
	}

	public void clicarConfirmar2() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[6]/tbody/tr[2]/td/input[3]");
	}

	public void escolherPrimeiroItem(int idTable, int id) {
		selecionarPrimeiroItem();
		try {
			clicarConfirmar(idTable, id);
		} catch (Exception e) {
			clicarConfirmar(6, 3);
		}
	}

	private void selecionarPrimeiroItem() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[3]/tbody/tr[1]/td/div/span[1]/div[2]/input");
	}

	private void clicarConfirmar(int idTable, int idInput) {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table["
				+ idTable + "]/tbody/tr[2]/td/input[" + idInput + "]");
	}

	public void incluirFiltro(CampoFiltroFundosOuCarteiras filtro) {
		incluirFiltro(filtro, "");
	}

	public String getCodSTI() {
		return encontrarCampoPorXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[3]/tbody/tr[1]/td/div/span[2]/div[2]")
				.getText();
	}

	public void clicarCancelar() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[5]/tbody/tr[2]/td/input[1]");
	}

}
