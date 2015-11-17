package br.com.galgo.testes.recursos_comuns.pageObject.consulta;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;
import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroFundos;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroFundos;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroFundosOuCarteiras;
import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.download.TelaDownload;
import br.com.galgo.testes.recursos_comuns.pageObject.download.TelaDownloadFundo;

public class TelaConsultaFundo extends TelaPrincipal {

	public void incluirFiltroSigla(String sigla) {
		TelaFundosOuCarteiras telaFundosOuCarteiras = entrarFiltroBuscaEntidade();
		telaFundosOuCarteiras.incluirFiltro(CampoFiltroFundosOuCarteiras.SIGLA,
				sigla);
		telaFundosOuCarteiras.clicarBotaoConfirmar();
		clicarPrimerioItem();
		clicarConfirmar("2");
	}

	public void incluirFiltroCNPJ(String cnpj) {
		incluirFiltroCNPJ(cnpj, "2");
	}

	public void incluirFiltroCNPJ(String cnpj, String id) {
		TelaFundosOuCarteiras telaFundosOuCarteiras = entrarFiltroBuscaEntidade();
		telaFundosOuCarteiras.incluirFiltro(CampoFiltroFundosOuCarteiras.CNPJ,
				cnpj);
		telaFundosOuCarteiras.clicarBotaoConfirmar();
		clicarPrimerioItem();
		clicarConfirmar(id);
	}

	public void consultarFundosViaArquivo(Usuario usuario, String pathArquivo)
			throws ErroAplicacao {
		consultarFundosViaArquivo(usuario, pathArquivo, false);
	}

	public void consultarFundosViaArquivo(Usuario usuario, String pathArquivo,
			boolean ehParaFazerDownloadArq) throws ErroAplicacao {
		TelaDownload telaDownload = clicarBotaoDownload();
		TelaDownloadFundo telaDownloadFundo = telaDownload.download();

		final String senha = usuario.getSenha();

		telaDownloadFundo.preencherCampoSenha(senha);
		clicarBotaoEnter(usuario, telaDownloadFundo);
		if (ehParaFazerDownloadArq) {
			telaDownloadFundo.fazerDownload(pathArquivo);
		}
	}

	private void clicarBotaoEnter(Usuario usuario,
			TelaDownloadFundo telaDownloadFundo) {
		if (Ambiente.HOMOLOGACAO == usuario.getAmbiente()) {
			telaDownloadFundo.clicarItemPorClassName("submit_ativo");
		} else {
			telaDownloadFundo.clicarItemPorClassName("enter");
		}
	}

	public void consultarFundo(String codSTI) {
		incluirFiltroBuscaFundoOuCarteira(CampoFiltroFundosOuCarteiras.COD_STI,
				codSTI);
		clicarBotaoConfirmar();
		escolherPrimeiroItem();
	}

	public TelaDetalhesFundos consultarDetalhes() {
		TelaDetalhesFundos telaDetalhesFundos = clicarDetalhes();
		telaDetalhesFundos.esperarSegundos(2);
		telaDetalhesFundos.garanteTextoNaTela("Identificação do Fundo");
		return telaDetalhesFundos;
	}

	public void consultarFundosAtivosAnbid() {
		incluirFiltroBuscaFundoOuCarteira(CampoFiltroFundosOuCarteiras.STATUS_ATIVO_ANBIMA);
		clicarBotaoConfirmar();
		verificarItemEncontrado();
	}

	public void incluirFiltro(CampoFiltroFundos filtro) {
		incluirFiltro(filtro, "");
	}

	public void incluirFiltro(CampoFiltroFundos filtro, String valorCampoInput) {
		FiltroFundos filtroFundos = filtro.getFiltro();
		if (filtroFundos.getTipoCampo() == TipoCampo.RADIO) {
			clicarItemPorId(filtro.getCampo());
		} else if (filtroFundos.getTipoCampo() == TipoCampo.SELECT) {
			preencherCampoSelect(filtro.getDescricao(), filtro.getCampo());
		} else if (filtroFundos.getTipoCampo() == TipoCampo.INPUT) {
			preencheCampoPorId(filtro.getCampo(), valorCampoInput);
		} else if (filtroFundos.getTipoCampo() == TipoCampo.BUSCA) {
			clicarCampoBusca(filtro);
		}
	}

	private void clicarCampoBusca(CampoFiltroFundos filtro) {
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

	public void incluirFiltroBuscaFundoOuCarteira(
			CampoFiltroFundosOuCarteiras filtro) {
		incluirFiltroBuscaFundoOuCarteira(filtro, "");
	}

	public void incluirFiltroBuscaFundoOuCarteira(
			CampoFiltroFundosOuCarteiras filtro, String valorCampoInput) {
		TelaFundosOuCarteiras telaFundosOuCarteiras = entrarFiltroBuscaEntidade();
		telaFundosOuCarteiras.incluirFiltro(filtro, valorCampoInput);
		telaFundosOuCarteiras.clicarBotaoConfirmar();
		telaFundosOuCarteiras.clicarSelecionarTodos();
		telaFundosOuCarteiras.clicarConfirmar2();
		// telaFundosOuCarteiras.escolherPrimeiroItem();
	}

	public TelaFundosOuCarteiras entrarFiltroBuscaEntidade() {
		incluirFiltro(CampoFiltroFundos.BUSCA_FUNDO_SERIE_COTA);
		return new TelaFundosOuCarteiras();
	}

	public void escolherPrimeiroItem() {
		clicarPrimerioItem();
		clicarItemPorDom(getDomBotaoConfirmaResultado());
	}

	public void clicarConfirmar(String id) {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[5]/tbody/tr[2]/td/input["
				+ id + "]");
	}

	public void clicarPrimerioItem() {
		clicarItemPorName(getPrimeiroItem());
	}

	public TelaDetalhesFundos clicarDetalhes() {
		clicarItemPorLink(getLinkCodigoSTI());
		return new TelaDetalhesFundos();
	}

	public TelaDownload clicarBotaoDownload() {
		clicarItemPorName(getNameBotaoDownload());
		return new TelaDownload();
	}

	private String getNameBotaoDownload() {
		return "btdowload";
	}

	private String getLinkCodigoSTI() {
		List<WebElement> linkElements = driver.findElements(By
				.cssSelector("table tr.linha_destaque2 > td"));
		String linkCodigoSTI = linkElements.get(1).getText();
		return linkCodigoSTI;
	}

	public void clicarDetalhesFundo() {
		clicarItemPorName("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[3]/tbody/tr/td/table[1]/tbody/tr[2]/td[2]/a");
	}

	private String getDomBotaoConfirmaResultado() {
		return "document.ns_7_43BQ4C020GPU30IPK5SL683O60_BuscarFundoCarteiraForm.elements['org.apache.struts.taglib.html.CANCEL'][1]";
	}

	private String getPrimeiroItem() {
		return "listaFundoCarteiraSelecionados";
	}

}
