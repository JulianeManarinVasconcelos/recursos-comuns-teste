package br.com.galgo.testes.recursos_comuns.pageObject.reenvio;

import java.text.ParseException;

import br.com.galgo.testes.recursos_comuns.file.entidades.Teste;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaPLCota;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvio;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioInfoAnbimaPortal;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioPlCotaArquivo;

public class TelaReenvioInfoAnbima extends TelaPrincipal {

	private String codSTI;
	private String dataBase;

	public TelaReenvioInfoAnbima(String codSTI, String dataBase) {
		this.codSTI = codSTI;
		this.dataBase = dataBase;
	}

	public TelaConsultaPLCota reenviar() throws ParseException {
		clicarPrimeiroItem();
		TelaEnvioInfoAnbimaPortal telaEnvioInfoAnbimaPortal = clicarReenvio();
		telaEnvioInfoAnbimaPortal.preencherValorCota(TelaEnvio.VALOR_REENVIO);
		telaEnvioInfoAnbimaPortal.preencherPLFundo(TelaEnvio.VALOR_REENVIO);
		telaEnvioInfoAnbimaPortal.clicarBotaoConfirmar();

		TelaJustificativaReenvioPlCotaPortal telaJusficativa = new TelaJustificativaReenvioPlCotaPortal(
				codSTI, dataBase);
		telaEnvioInfoAnbimaPortal = telaJusficativa.justificarInfoAnbima();
		telaEnvioInfoAnbimaPortal.clicarBotaoVoltar();
		return new TelaConsultaPLCota();
	}

	public TelaConsultaPLCota reenviarArquivo(Teste teste, Usuario usuario,
			String caminhoArquivo, String dataFiltro, String codigoSTI)
			throws ParseException {
		clicarPrimeiroItem();
		TelaEnvioInfoAnbimaPortal telaEnvioDeInformacao = clicarReenvio();
		TelaEnvioPlCotaArquivo telaEnvioPlCotaArquivo = telaEnvioDeInformacao
				.clicarUploadArquivo(usuario, caminhoArquivo);
		telaEnvioPlCotaArquivo.enviar();
		telaEnvioPlCotaArquivo.clicarBotaoVoltar();
		return new TelaConsultaPLCota();
	}

	private TelaEnvioInfoAnbimaPortal clicarReenvio() {
		if (verificaCampoVisivelPorXPath(getXPathBotaoReenviarInfo())) {
			clicarItemPorXPath(getXPathBotaoReenviarInfo());
		}
		return new TelaEnvioInfoAnbimaPortal(codSTI, dataBase);

	}

	private String getXPathBotaoReenviarInfo() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[2]/div[2]/div[1]/div[2]/div/input[2]";
	}

	private void clicarPrimeiroItem() {
		if (verificaCampoVisivelPorXPath(getPrimeiroItem())) {
			clicarItemPorXPath(getPrimeiroItem());
		}
	}

	private String getPrimeiroItem() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[2]/table[1]/tbody/tr[1]/td[1]/div/div[2]/table/tbody/tr[2]/td[1]/input";
	}

}
