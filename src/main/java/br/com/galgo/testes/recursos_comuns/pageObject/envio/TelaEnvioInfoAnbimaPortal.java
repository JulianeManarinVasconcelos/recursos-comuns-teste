package br.com.galgo.testes.recursos_comuns.pageObject.envio;

import java.text.ParseException;

import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela.CampoFiltroFundosOuCarteiras;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaFundosOuCarteiras;

public class TelaEnvioInfoAnbimaPortal extends TelaPrincipal implements TelaEnvio {

	private String codSTI;
	private String dataBase;

	public TelaEnvioInfoAnbimaPortal(String codSTI, String dataBase) {
		this.codSTI = codSTI;
		this.dataBase = dataBase;
	}

	public void enviar() throws ParseException {
		final String valor = TelaEnvio.VALOR_ENVIO;
		if (codSTI != null) {
			selecionarEnvioInfoAnbima();
			incluirFundo();
		}
		preencherDataBase();
		preencherValorCota();
		preencherPLFundo();
		preencheCampoPorId("aplicacoes", valor);
		preencheCampoPorId("valorComeCotas", valor);
		preencheCampoPorId("resgate", "0");
		preencheCampoPorId("numeroCotistas", valor);
		clicarBotaoConfirmar();
		validaReenvio();
	}

	private void validaReenvio() {
		if (verificaCampoVisivelPorXPath(getXPathJustificativa())) {
			preencheCampoXPath(getXPathJustificativa(), "justificativa teste");
			clicarBotaoConfirmar();
		}
	}

	private String getXPathJustificativa() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/textarea";
	}

	private void selecionarEnvioInfoAnbima() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/input[2]");
	}

	private void incluirFundo() {
		clicarBuscaFundos();
		TelaFundosOuCarteiras telaConsultaFundos = new TelaFundosOuCarteiras();
		telaConsultaFundos.incluirFiltro(CampoFiltroFundosOuCarteiras.COD_STI,
				codSTI);
		clicarBotaoConfirmar();
		clicarPrimeiroItem();
		clicarConfirmarItem();
	}

	private void preencherDataBase() {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input",
				dataBase);
	}

	private void clicarConfirmarItem() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[5]/tbody/tr[2]/td/input[2]");
	}

	private void clicarPrimeiroItem() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[3]/tbody/tr[1]/td/div/span[1]/div[2]/input");
	}

	private void clicarBuscaFundos() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input[3]");
	}

	public TelaEnvioPlCotaArquivo clicarUploadArquivo(Usuario usuario,
			String caminhoArquivo) {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[4]/td/input[3]");
		return new TelaEnvioPlCotaArquivo(usuario, caminhoArquivo, codSTI,
				dataBase, Operacao.REENVIO_INFORMES);
	}

	public void preencherPLFundo(String valor) {
		preencheCampoPorId("plFundo", valor);
	}

	public void preencherPLFundo() {
		preencheCampoPorId("plFundo", TelaEnvio.VALOR_ENVIO);
	}

	public void preencherValorCota() {
		preencherValorCota(TelaEnvio.VALOR_ENVIO);
	}

	public void preencherValorCota(String cota) {
		preencheCampoPorId("valorCota", cota);
	}

}
