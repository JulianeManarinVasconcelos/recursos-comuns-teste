package br.com.galgo.testes.recursos_comuns.pageObject.cancelamento;

import java.text.ParseException;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.enumerador.TipoExtrato;
import br.com.galgo.testes.recursos_comuns.enumerador.data.FormatoData;
import br.com.galgo.testes.recursos_comuns.file.ArquivoUtils;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaExtrato;
import br.com.galgo.testes.recursos_comuns.utils.ConstantesTestes;
import br.com.galgo.testes.recursos_comuns.utils.DataUtils;

public class TelaCancelamentoExtrato extends TelaPrincipal {

	public void cancelar() throws ParseException {
		TipoExtrato tipoExtrato = TipoExtrato.CONSOLIDADO;

		Date dataBaseAtual = FormatoData.DD_MM_YYYY
				.getData(getValorDataAtual());

		DateTime dt = new DateTime(DataUtils.subtrairDias(1, dataBaseAtual));
		LocalDate dataBaseAnterior = dt.toLocalDate();

		String valorLiquido = "0,00";

		fazerEnvio(tipoExtrato, dataBaseAnterior, valorLiquido);
		validaEnvio(tipoExtrato, dataBaseAnterior, valorLiquido);
		clicarBotaoConfirmar();
	}

	private void validaEnvio(TipoExtrato tipoExtrato,
			LocalDate dataBaseAnterior, String valorLiquido)
			throws ParseException {
		validaReenvio();
		validaErroCompromissoSuspenso();
		validaDataAnterior(dataBaseAnterior);
	}

	private void validaReenvio() {
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
		while (temErroNaTela() && tentativas < TelaCancelamento.MAX_TENTATIVAS) {
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
		while (haErroDeDataAnterior()
				&& tentativas < TelaCancelamento.MAX_TENTATIVAS) {
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
		preencherDataBaseAnterior(dataBaseAnterior);
		preencherIndicadorFundoNao();
		clicarMaisSaldoConsolidado();
		preencherCamposValoresAnteriores(valorLiquido);
		preencherCamposValoresAtuais(valorLiquido);
		clicarBotaoEnviar();
	}

	private void preencherDataBaseAnterior(LocalDate databaseAnterior)
			throws ParseException {
		preencheCampoPorId(getIdDataBaseAnterior(),
				FormatoData.DD_MM_YYYY.formata(databaseAnterior.toDate()));
	}

	private void clicarBotaoEnviar() {
		clicarItemPorId(getIdBotaoEnviar());
	}

	private String getIdBotaoEnviar() {
		return "enviar";
	}

	private void preencherCamposValoresAtuais(String valorLiquido) {
		preencheCampoPorId("qtdCotasSaldoAtualCons", "200,00");
		preencheCampoPorId("cotaSaldoAtualCons", "2000,00");
		preencheCampoPorId("valorBrutoAtualCons", "0,00");
		preencheCampoPorId("provisaoIRAtualCons", "0,00");
		preencheCampoPorId("provisaoIOFAtualCons", "0,00");
		preencheCampoPorId("taxaPerformanceAtualCons", "0,00");
		preencheCampoPorId("taxaSaidaAtualCons", "0,00");
		preencheCampoPorId("valorLiquidoAtualCons", valorLiquido);
	}

	private void clicarMaisSaldoConsolidado() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/table/tbody/tr[12]/td/div[1]/ul/li/div");
	}

	private String getIdDataBaseAnterior() {
		return "dataBaseAnterior";
	}

	private String getValorDataAtual() {
		return getValorCampoPorXPath(getXPathDataBaseAtual());
	}

	private void preencherCamposValoresAnteriores(String valorLiquido) {
		preencheCampoPorId("qtdCotasSaldoAnteriorCons", "100,00");
		preencheCampoPorId("cotaSaldoAnteriorCons", "1000,00");
		preencheCampoPorId("valorBrutoAnteriorCons", "0,00");
		preencheCampoPorId("provisaoIRAnteriorCons", "0,00");
		preencheCampoPorId("provisaoIOFAnteriorCons", "0,00");
		preencheCampoPorId("taxaPerformanceAnteriorCons", "0,00");
		preencheCampoPorId("taxaSaidaAnteriorCons", "0,00");
		preencheCampoPorId("valorLiquidoAnteriorCons", valorLiquido);
	}

	private String getXPathDataBaseAtual() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/table/tbody/tr[8]/td[2]/input";
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

	public void cancelar(String dataFiltro, String codigoSTI,
			String codSTICotista) throws Exception {
		TelaConsultaExtrato telaConsultaExtrato = new TelaConsultaExtrato();
		telaConsultaExtrato.consultar(codSTICotista, codigoSTI, dataFiltro, 4);
		clicarPrimeiroItem();
		preencherJustificativa();
		clicarBotaoCancelar();
	}

	private void clicarBotaoCancelar() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[4]/table/tbody/tr[4]/td/input[2]");
	}

	private void preencherJustificativa() {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[4]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/textarea",
				"Teste");
	}

	private void clicarPrimeiroItem() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[4]/table/tbody/tr[2]/td/div/table[1]/tbody/tr[1]/td[1]/div[2]/div[2]/table/tbody/tr[2]/td[1]/input");
	}

	public void cancelarArquivo(String dataBase, String codigoSTI,
			String codSTICotista, Usuario usuario,
			String pathArquivoCancelamento) throws Exception {
		ArquivoUtils.atualizarArquivoSalvarExtrato(
				ConstantesTestes.PATH_CANCELAMENTO_EXTRATO, dataBase,
				codigoSTI, codSTICotista, Operacao.CANCELA_INFORMES);

		TelaCancelamentoExtratoArquivo telaCancelamentoExtratoArquivo = clicarBotaoCancelarPorArquivo();
		telaCancelamentoExtratoArquivo.cancelarPorArquivo(usuario,
				pathArquivoCancelamento);
	}

	private TelaCancelamentoExtratoArquivo clicarBotaoCancelarPorArquivo() {
		clicarItemPorId("upload");
		return new TelaCancelamentoExtratoArquivo();
	}

}
