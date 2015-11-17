package br.com.galgo.testes.recursos_comuns.pageObject.consulta;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroPLCota;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroFundosOuCarteiras;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroPosicao;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.download.TelaDownloadPosicao;
import br.com.galgo.testes.recursos_comuns.utils.ConstantesTestes;

public class TelaConsultaPosicao extends TelaPrincipal implements TelaConsulta {

	public void consultar(String codigoSTI, String dataFiltro) {
	}

	public void fazerDownload(String codigoSTI, String dataFiltro,
			Usuario usuario) {
		preencherFiltrosDataInicial(dataFiltro);
		incluirFiltroBuscaFundosOuCarteira(
				CampoFiltroFundosOuCarteiras.COD_STI, codigoSTI);
		clicarBotaoConfirmar();
		clicarSelecionarTodos();
		TelaDownloadPosicao telaDownloadPosicao = clicarBotaoConsultarViaArquivo();

		final String senha = usuario.getSenha();
		telaDownloadPosicao.preencherCampoSenha(senha);
		preencherVersao();

		telaDownloadPosicao.clicarBotaoConfirmar();
		telaDownloadPosicao
				.fazerDownload(ConstantesTestes.PATH_DOWNLOAD_POSICAO);
	}

	public void clicarSelecionarTodos() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[3]/div/p/input");
	}

	private void preencherVersao() {
		preencherCampoSelectByXPath(
				"5.0",
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/select");
	}

	public void preencherFiltrosDataInicial(String dataFiltro) {
		incluirFiltro(CampoFiltroPosicao.INPUT_DATA_POSICAO, dataFiltro);
	}

	public void incluirFiltro(CampoFiltroPosicao filtro) {
		incluirFiltro(filtro, "");
	}

	public void incluirFiltroBuscaFundosOuCarteira(
			CampoFiltroFundosOuCarteiras filtro) {
		incluirFiltroBuscaFundosOuCarteira(filtro, "");
	}

	public TelaDownloadPosicao clicarBotaoConsultarViaArquivo() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[4]/div/div[1]/div/div/input");
		return new TelaDownloadPosicao();
	}

	public void clicarPrimeiroFundo() {
		clicarItemPorName(getNamePrimeiroFundo());
	}

	public void incluirFiltroBuscaFundosOuCarteira(
			CampoFiltroFundosOuCarteiras filtro, String valorCampoInput) {
		TelaFundosOuCarteiras telaFundosOuCarteiras = entrarFiltroBuscaFundoOuCarteira();
		telaFundosOuCarteiras.incluirFiltro(filtro, valorCampoInput);
		telaFundosOuCarteiras.clicarBotaoConfirmar();
		telaFundosOuCarteiras.escolherPrimeiroItem();
	}

	private TelaFundosOuCarteiras entrarFiltroBuscaFundoOuCarteira() {
		incluirFiltro(CampoFiltroPosicao.BUSCA_FUNDO_OU_CARTEIRA);
		return new TelaFundosOuCarteiras();
	}

	public void incluirFiltro(CampoFiltroPosicao filtro, String valorCampoInput) {
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

	private void clicarCampoBusca(CampoFiltroPosicao filtro) {
		if (filtro.getTipoAtributo() == TipoAtributo.ID) {
			clicarItemPorId(filtro.getCampo());
		} else if (filtro.getTipoAtributo() == TipoAtributo.NAME) {
			clicarItemPorName(filtro.getCampo());
		} else if (filtro.getTipoAtributo() == TipoAtributo.XPATH) {
			clicarItemPorXPath(filtro.getCampo());
		}
	}

	@Override
	public void clicarBotaoConfirmar() {
		clicarItemPorId(getIdBotaoConfirmar());
	}

	private String getIdBotaoConfirmar() {
		return "confirmarFormulario";
	}

	private String getNamePrimeiroFundo() {
		return "indice";
	}

}
