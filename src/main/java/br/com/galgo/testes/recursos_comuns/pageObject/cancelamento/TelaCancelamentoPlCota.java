package br.com.galgo.testes.recursos_comuns.pageObject.cancelamento;

import br.com.galgo.testes.recursos_comuns.config.ConfiguracaoSistema;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroFundosOuCarteiras;
import br.com.galgo.testes.recursos_comuns.file.ArquivoUtils;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaPLCota;
import br.com.galgo.testes.recursos_comuns.utils.DataUtils;

public class TelaCancelamentoPlCota extends TelaPrincipal implements
		TelaCancelamento {

	public void cancelar(String dataFiltro, String codigoSTI) throws Exception {
		clicarRefinarBusca();
		TelaConsultaPLCota telaConsultaPLCota = new TelaConsultaPLCota();
		telaConsultaPLCota.incluirFiltroBuscaFundosOuCarteira(
				CampoFiltroFundosOuCarteiras.COD_STI, codigoSTI);
		telaConsultaPLCota.preencherFiltrosDataInicialInformacao(dataFiltro);
		clicarBotaoConfirmar();
		TelaConfirmacaoDeCancelamentoPlCota telaConfirmacaoDeCancelamentoPlCota = cancelarPrimeiroFundo();
		telaConfirmacaoDeCancelamentoPlCota.confirmarCancelamento();
	}

	private void clicarRefinarBusca() {
		if (verificaCampoVisivelPorXPath(getBotaoRefinarBusca())) {
			clicarItemPorXPath(getBotaoRefinarBusca());
		}
	}

	private String getBotaoRefinarBusca() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[3]/div/div[1]/div/input[5]";
	}

	private TelaConfirmacaoDeCancelamentoPlCota cancelarPrimeiroFundo() {
		escolerPrimeiroItem();
		clicarBotaoCancelar();
		return new TelaConfirmacaoDeCancelamentoPlCota();
	}

	private void clicarBotaoCancelar() {
		if (verificaCampoHabilitadoPorXPath(getXPathBotaoCancelarPlCota())) {
			clicarItemPorXPath(getXPathBotaoCancelarPlCota());
		} else if (verificaCampoHabilitadoPorXPath(getXPathBotaoCancelarInfoAnbima())) {
			clicarItemPorXPath(getXPathBotaoCancelarInfoAnbima());
		}
	}

	private String getXPathBotaoCancelarPlCota() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[3]/div/div[1]/div/input[2]";
	}

	private String getXPathBotaoCancelarInfoAnbima() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[3]/div/div[1]/div/input[3]";
	}

	private void escolerPrimeiroItem() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/table[1]/tbody/tr[1]/td[1]/div/div[2]/table/tbody/tr[2]/td[1]/input");
	}

	public void cancelarArquivo(String dataBase, String codigoSTI,
			Usuario usuario, String pathArquivoCancelamento) throws Exception {
		final String pathArquivo = ConfiguracaoSistema.getPathArquivo(
				pathArquivoCancelamento, false);
		String dataFiltro = DataUtils.getDataBaseXML(dataBase);

		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, "<NAVDtTm>",
				dataFiltro);
		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, "<OthrPrtryId>",
				codigoSTI);

		TelaCancelamentoPlCotaArquivo telaCancelamentoPlCotaArquivo = clicarBotaoCancelarPorArquivo();
		telaCancelamentoPlCotaArquivo.cancelarPorArquivo(usuario,
				pathArquivoCancelamento);
	}

	private TelaCancelamentoPlCotaArquivo clicarBotaoCancelarPorArquivo() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[3]/div/div[1]/div/input[4]");
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[2]/div/div[1]/div/input[2]");
		}
		return new TelaCancelamentoPlCotaArquivo();
	}

}
