package br.com.galgo.testes.recursos_comuns.pageObject.envio;

import java.text.ParseException;
import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.enumerador.TipoExtrato;
import br.com.galgo.testes.recursos_comuns.enumerador.data.FormatoData;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaExtrato;
import br.com.galgo.testes.recursos_comuns.utils.DataUtils;

public class TelaEnvioExtrato extends TelaPrincipal implements TelaEnvio {

	private String dataBase;
	private String codigoSTI;
	private String cotista;

	public TelaEnvioExtrato(String dataBase, String codigoSTI, String cotista) {
		this.dataBase = dataBase;
		this.codigoSTI = codigoSTI;
		this.cotista = cotista;
	}

	public TelaEnvioExtrato() {
	}

	public void enviar() throws ParseException {
		final TipoExtrato tipoExtrato = TipoExtrato.CONSOLIDADO;
		final String valorLiquido = TelaEnvio.VALOR_ENVIO;
		Date dataBaseAtual = FormatoData.DD_MM_YYYY.getData(dataBase);
		LocalDate dataBaseAnterior = DataUtils
				.getDataBaseAnterior(dataBaseAtual);
		if (ehEnvioComParam()) {
			TelaConsultaExtrato telaConsultaExtrato = new TelaConsultaExtrato();
			telaConsultaExtrato.consultar(cotista, codigoSTI, dataBase, false);
			clicarEnviarPorId();
		}
		fazerEnvio(tipoExtrato, dataBaseAnterior, valorLiquido);
		validaEnvio(tipoExtrato, dataBaseAnterior);
		if (ehEnvioComParam()) {
			clicarVoltarPorId();
		}
	}

	private boolean ehEnvioComParam() {
		return codigoSTI != null;
	}

	private void clicarVoltarPorId() {
		clicarItemPorId("voltar");
	}

	private TelaConsultaExtrato clicarBuscar() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table/tbody/tr/td/input[4]");
		return new TelaConsultaExtrato();
	}

	private TelaConsultaExtrato clicarEnviarPorId() {
		clicarItemPorId("enviar");
		return new TelaConsultaExtrato();
	}

	public void validaEnvio(TipoExtrato tipoExtrato, LocalDate dataBaseAnterior)
			throws ParseException {
		validaReenvio();
		validaErroCompromissoSuspenso();
		validaDataAnterior(dataBaseAnterior);
	}

	public void validaReenvio() {
		if (verificaTextoNaTela("Justificativa")) {
			preencheCampoPorName(getNameCampoJustificativa(),
					"automatizacao de cumprir eventos");
			clicarBotaoConfirmar();
		}
	}

	private String getNameCampoJustificativa() {
		return "justificativa";
	}

	private void validaErroCompromissoSuspenso() throws ParseException {
		int tentativas = 0;
		while (temErroNaTela() && tentativas < MAX_TENTATIVAS) {
			String valorLiquido = "1,00";
			clicarMaisSaldoConsolidado();
			preencherCamposValoresAnteriores(valorLiquido);
			preencherCamposValoresAtuais(valorLiquido);
			clicarBotaoEnviar();
			tentativas++;
		}
		if (temErroNaTela()) {
			Assert.fail("Verifique se o compromisso está suspenso e se o valor liquido da cota no extrato não está zerado.");
		}
	}

	private void validaDataAnterior(LocalDate dataBaseAnterior)
			throws ParseException {
		int tentativas = 0;
		while (haErroDeDataAnterior() && tentativas < MAX_TENTATIVAS) {
			System.out.println("Erro de data base anterior "
					+ dataBaseAnterior.toString() + " inválida.");
			dataBaseAnterior = DataUtils.getDataBaseAnterior(dataBaseAnterior
					.toDate());
			preencherDataBaseAnterior(dataBaseAnterior);
			clicarBotaoEnviar();
			tentativas++;
		}
		if (haErroDeDataAnterior()) {
			Assert.fail("Erro de data base anterior "
					+ dataBaseAnterior.toString() + " inválida.");
		}
	}

	private boolean haErroDeDataAnterior() {
		return verificaTextoNaTela("A data informada no campo Data Base Anterior não é válida.");
	}

	private void fazerEnvio(TipoExtrato tipoExtrato,
			LocalDate dataBaseAnterior, String valorLiquido)
			throws ParseException {
		preecherTipoExtrato(tipoExtrato);
		preencherCondicaoTributariaCLEN();
		preencherDataBaseAtual();
		preencherDataBaseAnterior(dataBaseAnterior);
		preencherIndicadorFundoNao();
		clicarMaisSaldoConsolidado();
		preencherCampoMoeda();
		preencherCamposValoresAnteriores(valorLiquido);
		preencherCamposValoresAtuais(valorLiquido);
		clicarBotaoEnviar();
	}

	private void preencherDataBaseAtual() {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/table/tbody/tr[8]/td[2]/input",
				dataBase);
	}

	private void preencherCampoMoeda() {
		preencherCampoSelectByXPath(
				"BRL",
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/table/tbody/tr[10]/td[2]/select");
	}

	private void preencherDataBaseAnterior(LocalDate databaseAnterior)
			throws ParseException {
		preencheCampoPorId(getIdDataBaseAnterior(),
				FormatoData.DD_MM_YYYY.formata(databaseAnterior.toDate()));
	}

	public void clicarBotaoEnviar() {
		clicarItemPorId(getIdBotaoEnviar());
	}

	private String getIdBotaoEnviar() {
		return "enviar";
	}

	private void preencherCamposValoresAtuais(String valorLiquido) {
		preencheCampoPorId("qtdCotasSaldoAtualCons", valorLiquido);
		preencheCampoPorId("cotaSaldoAtualCons", valorLiquido);
		preencheCampoPorId("valorBrutoAtualCons", valorLiquido);
		preencheCampoPorId("provisaoIRAtualCons", valorLiquido);
		preencheCampoPorId("provisaoIOFAtualCons", valorLiquido);
		preencheCampoPorId("taxaPerformanceAtualCons", valorLiquido);
		preencheCampoPorId("taxaSaidaAtualCons", valorLiquido);
		preencheCampoPorId("valorLiquidoAtualCons", valorLiquido);

	}

	public TelaConsultaExtrato clicarBotaoBuscar() {
		clicarBuscar();
		return new TelaConsultaExtrato();
	}

	public void clicarMaisSaldoConsolidado() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/table/tbody/tr[12]/td/div[1]/ul/li/div");
	}

	private String getIdDataBaseAnterior() {
		return "dataBaseAnterior";
	}

	public void preencherCamposValoresAnteriores(String valorLiquido) {
		final String valorEnvio = TelaEnvio.VALOR_ENVIO;
		preencheCampoPorId("qtdCotasSaldoAnteriorCons", valorEnvio);
		preencheCampoPorId("cotaSaldoAnteriorCons", valorEnvio);
		preencheCampoPorId("valorBrutoAnteriorCons", valorEnvio);
		preencheCampoPorId("provisaoIRAnteriorCons", valorEnvio);
		preencheCampoPorId("provisaoIOFAnteriorCons", valorEnvio);
		preencheCampoPorId("taxaPerformanceAnteriorCons", valorEnvio);
		preencheCampoPorId("taxaSaidaAnteriorCons", valorEnvio);
		preencheCampoPorId("valorLiquidoAnteriorCons", valorLiquido);
	}

	public void preecherTipoExtrato(TipoExtrato tipoExtrato) {
		preencherCampoSelect(tipoExtrato.getValue(), getNameSelectTipoExtrato());
	}

	public void preencherCondicaoTributariaCLEN() {
		preencherCampoSelect("CLEN", getNameCondicaoTributaria());
	}

	public void preencherIndicadorFundoNao() {
		preencherCampoSelect("false", getIdIndicadorFundo());
	}

	private String getIdIndicadorFundo() {
		return "indicadorFundoDuplo";
	}

	private String getNameCondicaoTributaria() {
		return "condicaoTributariaCotista";
	}

	private String getNameSelectTipoExtrato() {
		return "tipoExtrato";
	}

	public TelaEnvioExtratoArquivo clicarUpload(Usuario usuario,
			String dataBase, String codigoSTI, String codSTICotista) {
		clicarItemPorId("upload");
		return new TelaEnvioExtratoArquivo(usuario, dataBase, codigoSTI,
				codSTICotista);
	}

}
