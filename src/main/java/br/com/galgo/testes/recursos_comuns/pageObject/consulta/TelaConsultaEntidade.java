package br.com.galgo.testes.recursos_comuns.pageObject.consulta;

import br.com.galgo.testes.recursos_comuns.enumerador.Entidade;
import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroEntidade;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroEntidade;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaHome;

public class TelaConsultaEntidade extends TelaPrincipal {

	public void filtrarPorNomeFantasia(String nomeFantasia) {
		incluirFiltro(CampoFiltroEntidade.INPUT_NOME_FANTASIA, nomeFantasia);
		clicarBotaoConfirmar();
		escolherPrimeiroItem();
	}

	public void consultarTodasEntidadesPJ(TelaHome telaHome) {
		incluirFiltro(CampoFiltroEntidade.RADIO_PJ);
		finalizarBusca();
	}

	public void consultarEntidadePJ(Entidade entidade) {
		incluirFiltro(CampoFiltroEntidade.RADIO_PJ);
		try {
			incluirFiltro(CampoFiltroEntidade.INPUT_NOME_FANTASIA,
					entidade.getDescricao());
		} catch (Exception e) {
			System.out.println("Erro ao incluir filtro nome fantasia.");
		}
		finalizarBusca();
	}

	private void finalizarBusca() {
		clicarBotaoConfirmar();
		verificarItemEncontrado();
	}

	public void incluirFiltro(CampoFiltroEntidade filtro) {
		incluirFiltro(filtro, "");
	}

	public void incluirFiltro(CampoFiltroEntidade filtro, String valorCampoInput) {
		FiltroEntidade filtroEntidade = filtro.getFiltro();
		if (filtroEntidade.getTipoCampo() == TipoCampo.RADIO) {
			try {
				clicarItemPorId(filtro.getCampo());
			} catch (Exception e) {
				clicarItemPorXPath(filtro.getCampo());
			}
		} else if (filtroEntidade.getTipoCampo() == TipoCampo.SELECT) {
			preencherCampoSelect(filtro.getDescricao());
		} else if (filtroEntidade.getTipoCampo() == TipoCampo.INPUT) {
			try {
				preencheCampoPorId(filtro.getCampo(), valorCampoInput);
			} catch (Exception e) {
				preencheCampoXPath(filtro.getCampo(), valorCampoInput);
			}
		}
	}

	public void escolherPrimeiroItem() {
		try {
			clicarItemPorName(getNamePrimeiroItemBusca());
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[3]/tbody/tr[1]/td/div/span[1]/div[2]/input");
		}

		try {
			clicarItemPorId(getIdBotaoConfirmaResultado());
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[6]/tbody/tr[2]/td/input[2]");
		}
	}

	private String getIdBotaoConfirmaResultado() {
		return "ConfirmarResultado";
	}

	private String getNamePrimeiroItemBusca() {
		return "linhasChecked";
	}
}
