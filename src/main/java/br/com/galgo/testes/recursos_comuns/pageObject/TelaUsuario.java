package br.com.galgo.testes.recursos_comuns.pageObject;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroUsuario;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroUsuario;

public class TelaUsuario extends TelaPrincipal {

	public void incluirFiltro(CampoFiltroUsuario filtro) {
		incluirFiltro(filtro, "");
	}

	public void incluirFiltro(CampoFiltroUsuario filtro, String valorCampoInput) {
		FiltroUsuario filtroUsuario = filtro.getFiltro();
		if (filtroUsuario.getTipoCampo() == TipoCampo.RADIO) {
			clicarItemPorId(filtro.getCampo());
		} else if (filtroUsuario.getTipoCampo() == TipoCampo.SELECT) {
			preencherCampoSelect(filtro.getDescricao());
		} else if (filtroUsuario.getTipoCampo() == TipoCampo.INPUT) {
			preencherCampoInput(filtro, valorCampoInput);
		} else if (filtroUsuario.getTipoCampo() == TipoCampo.BUSCA) {
			clicarCampoBusca(filtro);
		}
	}

	private void clicarCampoBusca(CampoFiltroUsuario filtro) {
		if (filtro.getTipoAtributo() == TipoAtributo.ID) {
			clicarItemPorId(filtro.getCampo());
		} else if (filtro.getTipoAtributo() == TipoAtributo.NAME) {
			clicarItemPorName(filtro.getCampo());
		} else if (filtro.getTipoAtributo() == TipoAtributo.XPATH) {
			clicarItemPorXPath(filtro.getCampo());
		}
	}

	private void preencherCampoInput(CampoFiltroUsuario filtro,
			String valorCampoInput) {
		if (filtro.getTipoAtributo() == TipoAtributo.ID) {
			preencheCampoPorId(filtro.getCampo(), valorCampoInput);
		} else if (filtro.getTipoAtributo() == TipoAtributo.NAME) {
			preencheCampoPorName(filtro.getCampo(), valorCampoInput);
		} else if (filtro.getTipoAtributo() == TipoAtributo.XPATH) {
			preencheCampoXPath(filtro.getCampo(), valorCampoInput);
		}
	}

	public void escolherPrimeiroItem() {
		clicarItemPorName(getNamePrimeiroItemBusca());
		clicarBotaoConfirmar2();
	}

	private void clicarBotaoConfirmar2() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[5]/tbody/tr[2]/td/input");
	}


	private String getNamePrimeiroItemBusca() {
		return "usuariosSelecionados";
	}
}
