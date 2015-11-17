package br.com.galgo.testes.recursos_comuns.pageObject.compromisso;

import java.io.IOException;
import java.util.Date;

import br.com.galgo.testes.recursos_comuns.enumerador.Servico;
import br.com.galgo.testes.recursos_comuns.enumerador.data.FormatoData;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroFundosOuCarteiras;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaFundosOuCarteiras;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvio;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioExtrato;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioInfoAnbimaPortal;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioPlCota;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioPosicaoArquivo;

public class TelaPainelCompromissos extends TelaPrincipal {

	public static final int DEFAULT_VALOR_OCORRENCIA = 2;

	public boolean abriuPainelCompromissos() {
		try {
			return verificaCampoVisivelPorXPath(getXPathBarraDeProgressoVencidosDiasAnteriores());
		} catch (Exception e) {
			return false;
		}
	}

	public int pegarQtdDeEventosPendentes() {
		final String valor = getTextoPorXPath(getXPathBarraEventosPendentes());
		int inicio = valor.indexOf("(");
		int fim = valor.indexOf(")");

		final String qtd = valor.substring(inicio + 1, fim).trim()
				.replace(".", "");

		return Integer.valueOf(qtd);
	}

	private String getXPathBarraEventosPendentes() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div/div[12]/div[1]/a/p";
	}

	public int getQtdEventosASeremCumpridos() {
		String valor = "";
		try {
			valor = getTextoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[5]/table[2]/tbody/tr/td");
		} catch (Exception e) {
			valor = getTextoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[5]/table[2]/tbody/tr/td");
		}
		int fim = valor.indexOf("itens");
		if (fim == -1) {
			fim = valor.indexOf("item");
		}

		String qtd = valor.substring(0, fim).trim();
		return Integer.parseInt(qtd);
	}

	public void preecherDataFinal(Date data) {
		preencheCampoPorId("fim", FormatoData.DD_MM_YYYY.formata(data));
	}

	public void preecherDataInicial(Date data) {
		preencheCampoPorId("inicio", FormatoData.DD_MM_YYYY.formata(data));
	}

	public void preecherServico(Servico servico) {
		preencherCampoSelect(servico.getValue(), getNameSelectServico());
	}

	public void clicarVisaoConsolidada() {
		clicarItemPorId(getIdVisaoConsolidada());
	}

	public void clicarVisaoNaoConsolidada() {
		clicarItemPorId(getIdVisaoNaoConsolidada());
	}

	private String getIdVisaoConsolidada() {
		return "visaoConsolidadaSim";
	}

	private String getIdVisaoNaoConsolidada() {
		return "visaoConsolidadaNao";
	}

	public void clicarFiltrosDeBusca() {
		esperarSegundos(2);
		clicarItemPorLink(getXLinkBotaoMostrarFiltros());
	}

	public boolean clicarVencidosDiasAnteriores() {
		if (pegarQtdDeEventosPendentes() != 0) {
			clicarBarraEventosAnteriores();
			return true;
		}
		return false;
	}

	private void clicarBarraEventosAnteriores() {
		clicarItemPorXPath(getXPathBotaoBarraDeProgressoVencidosDiasAnteriores());
	}

	public void clicarGrafico() {
		esperarSegundos(5);
		clicarItemPorXPath(getXPathGrafico());
	}

	public TelaEnvio clicarBotaoEnviar(Servico servico, Usuario usuario,
			String codigoSTI, String dataBase, String cotista, int posicao)
			throws IOException {
		if (Servico.EXTRATO == servico) {
			return enviarExtrato(codigoSTI, dataBase, cotista, posicao);
		} else if (Servico.PL_COTA == servico) {
			return enviarPlCotaPortal(codigoSTI, dataBase, posicao);
		} else if (Servico.INFO_ANBIMA == servico) {
			return enviarInfoAmbina(codigoSTI, dataBase, posicao);
		} else {
			return enviarPosicaoAtivos(usuario, codigoSTI, dataBase, posicao);
		}
	}

	private TelaEnvio enviarPlCotaPortal(String codigoSTI, String dataBase,
			int posicao) {
		clicarBotaoEnviar(posicao);
		return new TelaEnvioPlCota(codigoSTI, dataBase);
	}

	private TelaEnvioPosicaoArquivo enviarPosicaoAtivos(Usuario usuario,
			String codigoSTI, String dataBase, int posicao) {
		clicarBotaoEnviar(posicao);
		return new TelaEnvioPosicaoArquivo(usuario, dataBase, codigoSTI);
	}

	public String getDataBase(int posicao) {
		String dataBase = encontrarCampoPorXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[5]/table[1]/tbody/tr["
						+ posicao + "]/td[2]").getText();
		return dataBase;
	}

	public String getCodSTI() {
		TelaCompromissosDetalhes telaCompromissosDetalhes = clicarCompromisso();
		String nomeFundo = telaCompromissosDetalhes.getNomeFundo();
		TelaPainelCompromissos telaPainelCompromissos = telaCompromissosDetalhes
				.clicarVoltar();
		TelaFundosOuCarteiras telaFundosOuCarteiras = telaPainelCompromissos
				.clicarBuscaFundo();
		telaFundosOuCarteiras.incluirFiltro(
				CampoFiltroFundosOuCarteiras.RAZAO_SOCIAL, nomeFundo);
		telaFundosOuCarteiras.clicarBotaoConfirmar();
		String codigoSTI = telaFundosOuCarteiras.getCodSTI().trim()
				.replace("-", "");
		telaFundosOuCarteiras.clicarCancelar();
		clicarBotaoConfirmar();
		return codigoSTI;
	}

	public String getCodSTICotista() {
		TelaCompromissosDetalhes telaCompromissosDetalhes = clicarCompromisso();
		String nomeFundo = telaCompromissosDetalhes.getFundoCotista();
		TelaPainelCompromissos telaPainelCompromissos = telaCompromissosDetalhes
				.clicarVoltar();
		TelaFundosOuCarteiras telaFundosOuCarteiras = telaPainelCompromissos
				.clicarBuscaFundo();
		telaFundosOuCarteiras.incluirFiltro(
				CampoFiltroFundosOuCarteiras.RAZAO_SOCIAL, nomeFundo);
		telaFundosOuCarteiras.clicarBotaoConfirmar();
		String codigoSTICotista = telaFundosOuCarteiras.getCodSTI().trim()
				.replace("-", "");
		telaFundosOuCarteiras.clicarCancelar();
		clicarBotaoConfirmar();
		return codigoSTICotista;
	}

	public void incluirFiltroFundo(String codigoSTI) {
		TelaFundosOuCarteiras telaFundosOuCarteiras = clicarBuscaFundo();
		telaFundosOuCarteiras.incluirFiltro(
				CampoFiltroFundosOuCarteiras.COD_STI, codigoSTI);
		telaFundosOuCarteiras.clicarBotaoConfirmar();
		telaFundosOuCarteiras.escolherPrimeiroItem();
		clicarBotaoConfirmar();
	}

	private TelaEnvio enviarInfoAmbina(String codigoSTI, String dataBase,
			int posicao) {
		clicarBotaoEnviar(posicao);
		return new TelaEnvioInfoAnbimaPortal(codigoSTI, dataBase);
	}

	private TelaEnvio enviarExtrato(String codigoSTI, String dataBase,
			String cotista, int posicao) {
		clicarBotaoEnviar(posicao);
		return new TelaEnvioExtrato(dataBase, codigoSTI, cotista);
	}

	private TelaFundosOuCarteiras clicarBuscaFundo() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[4]/div[7]/p/img[2]");
		return new TelaFundosOuCarteiras();
	}

	private TelaCompromissosDetalhes clicarCompromisso() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[5]/table[1]/tbody/tr[1]/td[5]/img[3]");
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[5]/table[1]/tbody/tr[1]/td[6]/img[3]");
		}
		return new TelaCompromissosDetalhes();
	}

	private void clicarBotaoEnviar(int posicao) {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[5]/table[1]/tbody/tr["
					+ posicao + "]/td[6]/img[1]");
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[5]/table[1]/tbody/tr["
					+ posicao + "]/td[5]/img[1]");
		}

	}

	private String getXPathGrafico() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[3]/div[4]/div[2]/div/map/area[1]";
	}

	private String getXPathBotaoBarraDeProgressoVencidosDiasAnteriores() {
		return "//div[@id='anbima-content-main']/div/div[12]/div/a/p";
	}

	private String getXPathBarraDeProgressoVencidosDiasAnteriores() {
		return "//div[@class='ui-progressbar-value ui-widget-header ui-corner-left']";
	}

	private String getNameSelectServico() {
		return "servico";
	}

	private String getXLinkBotaoMostrarFiltros() {
		return "clique aqui para mostrar os filtros de busca";
	}

}
