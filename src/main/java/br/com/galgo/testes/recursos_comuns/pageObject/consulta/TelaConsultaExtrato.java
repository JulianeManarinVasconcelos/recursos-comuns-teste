package br.com.galgo.testes.recursos_comuns.pageObject.consulta;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroPLCota;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroExtrato;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroFundosOuCarteiras;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.download.TelaDownloadExtrato;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioExtrato;
import br.com.galgo.testes.recursos_comuns.utils.ConstantesTestes;
import br.com.galgo.testes.recursos_comuns.utils.DataUtils;

public class TelaConsultaExtrato extends TelaPrincipal {

	public void consultar(String codigoSTICotista, String codigoSTI,
			String dataFiltro) {
		consultar(codigoSTICotista, codigoSTI, dataFiltro, 2, true);
	}

	public void consultar(String codigoSTICotista, String codigoSTI,
			String dataFiltro, boolean valida) {
		consultar(codigoSTICotista, codigoSTI, dataFiltro, 2, valida);
	}

	public void consultar(String codigoSTICotista, String codigoSTI,
			String dataFiltro, int idInput) {
		consultar(codigoSTICotista, codigoSTI, dataFiltro, idInput, true);
	}

	public void consultar(String codigoSTICotista, String codigoSTI,
			String dataFiltro, int idInput, boolean valida) {
		preencherFiltrosDataInicial(dataFiltro);
		filtrarFundo(codigoSTI);
		filtrarCotista(codigoSTICotista);
		clicarBotaoConfirmar();
		if (valida) {
			verificarItemEncontrado();
		}
	}

	public TelaEnvioExtrato clicarBotaoDownload(String dataBase,
			String codigoSTI, String codSTICotista) {
		clicarItemPorId("download");
		return new TelaEnvioExtrato(dataBase, codigoSTI, codSTICotista);
	}

	public TelaEnvioExtrato clicarBotaoEnviar(String dataBase,
			String codigoSTI, String codSTICotista) {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[4]/table/tbody/tr[3]/td/input[2]");
		return new TelaEnvioExtrato(dataBase, codigoSTI, codSTICotista);
	}

	public void escolherPrimeiroItem() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[4]/table/tbody/tr[2]/td/div/table[1]/tbody/tr[1]/td[1]/div[2]/div[2]/table/tbody/tr[2]/td[1]/input");
	}

	private void filtrarCotista(String codigoSTICotista) {
		incluirFiltroBuscaFundosOuCarteira(CampoFiltroExtrato.BUSCA_COTISTA,
				CampoFiltroFundosOuCarteiras.COD_STI, codigoSTICotista);
	}

	private void filtrarFundo(String codigoSTI) {
		incluirFiltroBuscaFundosOuCarteira(
				CampoFiltroExtrato.BUSCA_FUNDO_OU_CARTEIRA,
				CampoFiltroFundosOuCarteiras.COD_STI, codigoSTI);
	}

	public void fazerDownload(String codigoSTICotista, String codigoSTI,
			String dataFiltro, Usuario usuario) {
		consultar(codigoSTICotista, codigoSTI, dataFiltro);
		clicarSelecionarTodos();

		final String dataBase = DataUtils.getDataBase(dataFiltro);
		TelaDownloadExtrato telaDownloadExtrato = clicarBotaoConsultarViaArquivo(
				codigoSTI, dataBase, codigoSTICotista);

		telaDownloadExtrato.selecionarXML();

		final String senha = usuario.getSenha();
		telaDownloadExtrato.preencherCampoSenha(senha);

		telaDownloadExtrato.clicarBotaoConfirmar();
		telaDownloadExtrato
				.fazerDownload(ConstantesTestes.PATH_DOWNLOAD_EXTRATO);
	}

	@Override
	public void clicarSelecionarTodos() {
		clicarItemPorId("selectAll");
	}

	public void preencherFiltrosDataInicial(String dataFiltro) {
		incluirFiltro(CampoFiltroExtrato.INPUT_DATA_INICIAL_INFO, dataFiltro);
	}

	public void incluirFiltro(CampoFiltroExtrato filtro) {
		incluirFiltro(filtro, "");
	}

	public TelaDownloadExtrato clicarBotaoConsultarViaArquivo(String codigoSTI,
			String dataBase, String codSTICotista) {
		clicarBotaoDownload(dataBase, codigoSTI, codSTICotista);
		return new TelaDownloadExtrato();
	}

	public void clicarPrimeiroFundo() {
		clicarItemPorName(getNamePrimeiroFundo());
	}

	public void incluirFiltroBuscaFundosOuCarteira(
			CampoFiltroExtrato filtroExtrato,
			CampoFiltroFundosOuCarteiras filtro, String valorCampoInput) {
		TelaFundosOuCarteiras telaFundosOuCarteiras = entrarFiltroBuscaFundoOuCarteira(filtroExtrato);
		telaFundosOuCarteiras.incluirFiltro(filtro, valorCampoInput);
		telaFundosOuCarteiras.clicarBotaoConfirmar();
		telaFundosOuCarteiras.escolherPrimeiroItem(5, 2);
	}

	private TelaFundosOuCarteiras entrarFiltroBuscaFundoOuCarteira(
			CampoFiltroExtrato filtro) {
		incluirFiltro(filtro);
		return new TelaFundosOuCarteiras();
	}

	public void incluirFiltro(CampoFiltroExtrato filtro, String valorCampoInput) {
		FiltroPLCota filtroLog = filtro.getFiltro();
		if (filtroLog.getTipoCampo() == TipoCampo.RADIO) {
			clicarItemPorId(filtro.getCampo());
		} else if (filtroLog.getTipoCampo() == TipoCampo.SELECT) {
			preencherCampoSelect(filtro.getDescricao());
		} else if (filtroLog.getTipoCampo() == TipoCampo.INPUT) {
			if (filtro.getTipoAtributo() == TipoAtributo.XPATH) {
				preencheCampoXPath(filtro.getCampo(), valorCampoInput);
			} else {
				preencheCampoPorId(filtro.getCampo(), valorCampoInput);
			}
		} else if (filtroLog.getTipoCampo() == TipoCampo.BUSCA) {
			clicarCampoBusca(filtro);
		}
	}

	private void clicarCampoBusca(CampoFiltroExtrato filtro) {
		if (filtro.getTipoAtributo() == TipoAtributo.ID) {
			clicarItemPorId(filtro.getCampo());
		} else if (filtro.getTipoAtributo() == TipoAtributo.NAME) {
			clicarItemPorName(filtro.getCampo());
		} else if (filtro.getTipoAtributo() == TipoAtributo.XPATH) {
			clicarItemPorXPath(filtro.getCampo());
		}
	}

	private String getNamePrimeiroFundo() {
		return "indice";
	}

}
