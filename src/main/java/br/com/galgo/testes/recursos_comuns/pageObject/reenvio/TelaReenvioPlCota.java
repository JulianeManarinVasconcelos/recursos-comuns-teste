package br.com.galgo.testes.recursos_comuns.pageObject.reenvio;

import java.text.ParseException;

import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaPLCota;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvio;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioPlCota;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioPlCotaArquivo;

public class TelaReenvioPlCota extends TelaPrincipal {

	public static final String CAMINHO_XML_REENVIO_PL_COTA = "xml/plcota/01 - Exemplo Arquivo Reenvio PL Cota.xml";
	public static final String CAMINHO_XML_REENVIO_INFO = "xml/info anbima/02 - Exemplo Arquivo Reenvio Info ANBIMA.xml";

	private String codSTI;
	private String dataBase;

	public TelaReenvioPlCota(String codSTI, String dataBase) {
		this.codSTI = codSTI;
		this.dataBase = dataBase;
	}

	public TelaConsultaPLCota reenviar() throws ParseException {
		try {
			clicarPrimeiroItem();
			TelaEnvioPlCota telaEnvioDeInformacao = clicarReenvio();
			telaEnvioDeInformacao.preencherValorCota(TelaEnvio.VALOR_REENVIO);
			telaEnvioDeInformacao.preencherPLFundo(TelaEnvio.VALOR_REENVIO);
			telaEnvioDeInformacao.clicarBotaoConfirmar();

			TelaJustificativaReenvioPlCotaPortal telaJusficativa = new TelaJustificativaReenvioPlCotaPortal(
					codSTI, dataBase);
			telaEnvioDeInformacao = telaJusficativa.justificar();
			telaEnvioDeInformacao.clicarBotaoVoltar();
		} catch (Exception e) {
			TelaReenvioInfoAnbima telaReenvioInfoAnbima = clicarReenvioInfoAnbima();
			telaReenvioInfoAnbima.reenviar();
		}
		return new TelaConsultaPLCota();
	}

	public TelaConsultaPLCota reenviarArquivo(Usuario usuario,
			String caminhoArquivo, String dataFiltro, String codigoSTI)
			throws ParseException {
		TelaEnvioPlCota telaEnvioDeInformacao = new TelaEnvioPlCota(codSTI,
				dataBase);

		TelaEnvioPlCotaArquivo telaEnvioPlCotaArquivo = telaEnvioDeInformacao
				.clicarUploadArquivo(usuario, caminhoArquivo, codigoSTI,
						dataBase, Operacao.REENVIO_INFORMES);
		telaEnvioPlCotaArquivo.enviar();
		telaEnvioPlCotaArquivo.clicarBotaoVoltar();
		return new TelaConsultaPLCota();
	}

	private TelaReenvioInfoAnbima clicarReenvioInfoAnbima() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[2]/div[2]/div[1]/div[2]/div/input[2]");
		return new TelaReenvioInfoAnbima(codSTI, dataBase);
	}

	private TelaEnvioPlCota clicarReenvio() {
		clicarItemPorXPath(getXPathBotaoReenviaoPlCota());
		return new TelaEnvioPlCota(codSTI, dataBase);
	}

	private String getXPathBotaoReenviaoPlCota() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[2]/div[2]/div[1]/div[2]/div/input[1]";
	}

	private void clicarPrimeiroItem() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[2]/table[1]/tbody/tr[1]/td[1]/div/div[2]/table/tbody/tr[2]/td[1]/input");
	}

}
