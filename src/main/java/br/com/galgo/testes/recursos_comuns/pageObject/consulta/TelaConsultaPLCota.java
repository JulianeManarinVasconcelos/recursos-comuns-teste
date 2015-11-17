package br.com.galgo.testes.recursos_comuns.pageObject.consulta;

import java.util.Date;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;
import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;
import br.com.galgo.testes.recursos_comuns.enumerador.data.FormatoData;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroPLCota;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroEntidade;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroFundosOuCarteiras;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroPLCota;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.download.TelaDownloadPLCota;

public class TelaConsultaPLCota extends TelaPrincipal {

	public void consultar(String codigoSTI, String dataFiltro) {
		preencherFiltrosDataInicialInformacao(dataFiltro);
		incluirFiltroBuscaFundosOuCarteira(
				CampoFiltroFundosOuCarteiras.COD_STI, codigoSTI);
		clicarBotaoConfirmar();
		verificarItemEncontrado();
	}

	public void fazerDownload(String codigoSTI, String dataFiltro,
			Usuario usuario, String path, Operacao operacao) {
		preencherFiltrosDataInicialInformacao(dataFiltro);
		incluirFiltroBuscaFundosOuCarteira(
				CampoFiltroFundosOuCarteiras.COD_STI, codigoSTI);
		download(usuario, path, true, operacao);
	}

	public void download(Usuario usuario, String path, Operacao operacao) {
		download(usuario, path, false, operacao);
	}

	private void download(Usuario usuario, String path,
			boolean isToDownloadArq, Operacao operacao) {
		try {
			clicarBotaoConfirmar();
			if (Operacao.CONSULTA_TRANSFERENCIA == operacao) {
				clicarSelecionarTodos();
			} else {
				clicarPrimeiroFundo();
			}
			TelaDownloadPLCota telaPLCota = clicarBotaoConsultarViaArquivo();

			final String senha = usuario.getSenha();
			telaPLCota.preencherCampoSenha(senha);
			telaPLCota.clicarBotaoConfirmar();
			if (isToDownloadArq) {
				telaPLCota.fazerDownload(path);
			}
		} catch (Exception e) {
			Assert.fail("Erro ao fazer download de Pl/Cota.");
		}
	}

	public void clicarSelecionarTodos() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[2]/div[1]/p/input");
	}

	public void consultarDetalhes() {
		TelaDetalhesPLCota telaDetalhesPLCota = clicarDetalhesFundo();
		telaDetalhesPLCota.esperarSegundos(1);
		telaDetalhesPLCota.garanteDetalhesFundoOk();
	}

	public String consultarPlCota(Date dataEnvioInicial, Date dataEnvioFinal) {
		preencherFiltrosDataInicial(dataEnvioInicial);
		preencherFiltrosDataFinal(dataEnvioFinal);
		clicarBotaoConfirmar();
		return getTextoPorXPath(getXPathResultado());
	}

	public void consultarFundosAtivosNoMercado(Ambiente ambiente) {
		if (ambiente == Ambiente.PRODUCAO) {
			incluirFiltroBuscaFundosOuCarteira(CampoFiltroFundosOuCarteiras.STATUS_ATIVO_MERCADO);
		}
	}

	public void preencherFiltrosDataInicial(Date dataFiltro) {
		String dataInicial = FormatoData.DD_MM_YYYY.formata(dataFiltro);
		String horaInicial = FormatoData.HH.formata(dataFiltro);
		String minutoInicial = FormatoData.MM.formata(dataFiltro);
		incluirFiltro(CampoFiltroPLCota.INPUT_DATA_INICIAL_ENVIO, dataInicial);
		incluirFiltro(CampoFiltroPLCota.INPUT_HORA_INICIAL_ENVIO, horaInicial);
		incluirFiltro(CampoFiltroPLCota.INPUT_MIN_INICIAL_ENVIO, minutoInicial);
	}

	public void preencherFiltrosDataInicialInformacao(String dataFiltro) {
		incluirFiltro(CampoFiltroPLCota.INPUT_DATA_INICIAL_INFO, dataFiltro);
	}

	public void selecionarFilttroStatusEnviada() {
		incluirFiltro(CampoFiltroPLCota.SELECT_STATUS_ENVIADA);
	}

	public void preencherFiltrosDataFinal(Date dataFiltro) {
		String dataInicial = FormatoData.DD_MM_YYYY.formata(dataFiltro);
		String horaInicial = FormatoData.HH.formata(dataFiltro);
		String minutoInicial = FormatoData.MM.formata(dataFiltro);
		incluirFiltro(CampoFiltroPLCota.INPUT_DATA_FINAL_ENVIO, dataInicial);
		incluirFiltro(CampoFiltroPLCota.INPUT_HORA_FINAL_ENVIO, horaInicial);
		incluirFiltro(CampoFiltroPLCota.INPUT_MIN_FINAL_ENVIO, minutoInicial);
	}

	public void incluirFiltro(CampoFiltroPLCota filtro) {
		incluirFiltro(filtro, "");
	}

	public void incluirFiltroBuscaFundosOuCarteira(
			CampoFiltroFundosOuCarteiras filtro) {
		incluirFiltroBuscaFundosOuCarteira(filtro, "");
	}

	public TelaDownloadPLCota clicarBotaoConsultarViaArquivo() {
		clicarItemPorId(getIdBotaoConsultarViaArquivo());
		return new TelaDownloadPLCota();
	}

	public void clicarPrimeiroFundo() {
		clicarItemPorName(getNamePrimeiroFundo());
	}

	public TelaDetalhesPLCota clicarDetalhesFundo() {
		clicarItemPorLink(getXPathDetalhesFundo());
		return new TelaDetalhesPLCota();
	}

	public void incluirFiltroBuscaFundosOuCarteira(
			CampoFiltroFundosOuCarteiras filtro, String valorCampoInput) {
		incluirFiltroBuscaFundosOuCarteira(filtro, valorCampoInput, true);
	}

	public void incluirFiltroBuscaFundosOuCarteira(
			CampoFiltroFundosOuCarteiras filtro, String valorCampoInput,
			boolean clicarBotao) {
		TelaFundosOuCarteiras telaFundosOuCarteiras = entrarFiltroBuscaFundoOuCarteira(clicarBotao);
		telaFundosOuCarteiras.incluirFiltro(filtro, valorCampoInput);
		telaFundosOuCarteiras.clicarBotaoConfirmar();
		telaFundosOuCarteiras.escolherPrimeiroItem();
	}

	public void incluirFiltroBuscaEntidade(CampoFiltroEntidade filtroEntidade,
			String valorCampoInput) {
		TelaConsultaEntidade telaEntidade = entrarFiltroBuscaEntidade();
		telaEntidade.incluirFiltro(filtroEntidade, valorCampoInput);
		telaEntidade.clicarBotaoConfirmar();
		telaEntidade.escolherPrimeiroItem();
	}

	private TelaConsultaEntidade entrarFiltroBuscaEntidade() {
		incluirFiltro(CampoFiltroPLCota.BUSCA_ENTIDADE);
		return new TelaConsultaEntidade();
	}

	private TelaFundosOuCarteiras entrarFiltroBuscaFundoOuCarteira(
			boolean clicarBotao) {
		if (clicarBotao) {
			try {
				incluirFiltro(CampoFiltroPLCota.BUSCA_FUNDO_OU_CARTEIRA);
			} catch (Exception e) {
				System.out.println("erro na busca");
			}
		}
		return new TelaFundosOuCarteiras();
	}

	public void incluirFiltro(CampoFiltroPLCota filtro, String valorCampoInput) {
		FiltroPLCota filtroLog = filtro.getFiltro();
		if (filtroLog.getTipoCampo() == TipoCampo.RADIO) {
			clicarItemPorId(filtro.getCampo());
		} else if (filtroLog.getTipoCampo() == TipoCampo.SELECT) {
			if (filtro.getTipoAtributo() == TipoAtributo.XPATH) {
				preencherCampoSelectByXPath(filtro.getDescricao(),
						filtro.getCampo());
			} else {
				preencherCampoSelect(filtro.getDescricao());
			}
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

	private void clicarCampoBusca(CampoFiltroPLCota filtro) {
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

	private String getIdBotaoConsultarViaArquivo() {
		return "operacaoConsultarViaArquivo";
	}

	private String getNamePrimeiroFundo() {
		return "indice";
	}

	private String getXPathDetalhesFundo() {
		return "ENVIO";
	}

	private String getXPathResultado() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[2]/table[2]/tbody/tr/td";
	}

}
