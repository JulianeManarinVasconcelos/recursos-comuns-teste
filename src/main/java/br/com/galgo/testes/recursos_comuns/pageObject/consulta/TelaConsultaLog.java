package br.com.galgo.testes.recursos_comuns.pageObject.consulta;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroLog;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroEntidade;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroLog;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroUsuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaUsuario;

public class TelaConsultaLog extends TelaPrincipal {

	public void incluirFiltro(CampoFiltroLog filtro) {
		incluirFiltro(filtro, "");
	}

	public void incluirFiltroBuscaUsuario(CampoFiltroLog campoFiltroLog,
			CampoFiltroUsuario filtro, String valorCampoInput) {
		TelaUsuario telaUsuario = entrarFiltroBuscaUsuario(campoFiltroLog);
		telaUsuario.incluirFiltro(filtro, valorCampoInput);
		telaUsuario.clicarBotaoConfirmar();
		telaUsuario.escolherPrimeiroItem();
	}

	public void incluirFiltroBuscaEntidade(CampoFiltroEntidade filtroEntidade,
			String valorCampoInput) {
		TelaConsultaEntidade telaEntidade = entrarFiltroBuscaEntidade();
		telaEntidade.incluirFiltro(filtroEntidade, valorCampoInput);
		telaEntidade.clicarBotaoConfirmar();
		telaEntidade.escolherPrimeiroItem();
	}

	private TelaConsultaEntidade entrarFiltroBuscaEntidade() {
		incluirFiltro(CampoFiltroLog.BUSCA_ENTIDADE);
		return new TelaConsultaEntidade();
	}

	private TelaUsuario entrarFiltroBuscaUsuario(CampoFiltroLog campoFiltroLog) {
		incluirFiltro(campoFiltroLog);
		return new TelaUsuario();
	}

	public void incluirFiltro(CampoFiltroLog filtro, String valorCampoInput) {
		FiltroLog filtroLog = filtro.getFiltro();
		if (filtroLog.getTipoCampo() == TipoCampo.RADIO) {
			clicarItemPorId(filtro.getCampo());
		} else if (filtroLog.getTipoCampo() == TipoCampo.SELECT) {
			preencherCampoSelect(filtro.getDescricao());
		} else if (filtroLog.getTipoCampo() == TipoCampo.INPUT) {
			try {
				preencheCampoPorId(filtro.getCampo(), valorCampoInput);
			} catch (Exception e) {
				preencheCampoXPath(filtro.getCampo(), valorCampoInput);
			}
		} else if (filtroLog.getTipoCampo() == TipoCampo.BUSCA) {
			clicarCampoBusca(filtro);
		}
	}

	private void clicarCampoBusca(CampoFiltroLog filtro) {
		if (filtro.getTipoAtributo() == TipoAtributo.ID) {
			clicarItemPorId(filtro.getCampo());
		} else if (filtro.getTipoAtributo() == TipoAtributo.NAME) {
			clicarItemPorName(filtro.getCampo());
		} else if (filtro.getTipoAtributo() == TipoAtributo.XPATH) {
			clicarItemPorXPath(filtro.getCampo());
		}
	}

}
