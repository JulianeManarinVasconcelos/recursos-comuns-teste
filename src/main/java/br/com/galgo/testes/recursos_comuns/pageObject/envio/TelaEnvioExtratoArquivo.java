package br.com.galgo.testes.recursos_comuns.pageObject.envio;

import java.text.ParseException;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.config.ConfiguracaoSistema;
import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.enumerador.menu.SubMenu;
import br.com.galgo.testes.recursos_comuns.file.ArquivoUtils;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaHome;
import br.com.galgo.testes.recursos_comuns.thread.FazerUpload;
import br.com.galgo.testes.recursos_comuns.thread.FecharTelaDeRecibo;
import br.com.galgo.testes.recursos_comuns.utils.ConstantesTestes;
import br.com.galgo.testes.recursos_comuns.utils.DataUtils;

public class TelaEnvioExtratoArquivo extends TelaPrincipal implements TelaEnvio {

	private Usuario usuario;
	private String dataBase;
	private String codigoSTI;
	private String codSTICotista;

	public TelaEnvioExtratoArquivo() {

	}

	public TelaEnvioExtratoArquivo(Usuario usuario, String dataBase,
			String codigoSTI, String codSTICotista) {
		this.usuario = usuario;
		this.codigoSTI = codigoSTI;
		this.dataBase = dataBase;
		this.codSTICotista = codSTICotista;
	}

	public boolean salvar(Operacao operacao) throws ParseException {
		esperarSegundos(2);
		ArquivoUtils.atualizarArquivoSalvarExtrato(
				ConstantesTestes.PATH_ARQUIVO_SALVAR_EXTRATO, dataBase,
				codigoSTI, codSTICotista, operacao);

		clicarSelecionarArquivo();

		FazerUpload fazerUpload = new FazerUpload(
				ConstantesTestes.PATH_ARQUIVO_SALVAR_EXTRATO);
		fazerUpload.upload();

		selecionarTipoUpload("1");
		selecionarVersao();
		preencherSenha();
		clicarEnviarArquivo();
		fecharTelaRecibos();

		if (verificaSucesso()) {
			Assert.fail("Ocorreu um erro ao enviar pl/cota. Verifique o arquivo.");
			return false;
		}
		return true;
	}

	private void clicarBotaoUploadPorXpath() {
		if (verificaCampoVisivelPorXPath(getXPathUpload())) {
			clicarItemPorXPath(getXPathUpload());
		}
	}

	private String getXPathUpload() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table/tbody/tr/td/input[3]";
	}

	private boolean verificaSucesso() {
		esperarSegundos(2);
		return verificaTextoNaTela("Ocorreu um erro no sistema. ")
				|| verificaTextoNaTela("O leiaute informado é inválido.");
	}

	public void enviar() throws ParseException {
		enviar(Operacao.ENVIO_INFORMES);
	}

	public void enviar(Operacao operacao) throws ParseException {
		acessarMenuDeEnvio();
		clicarBotaoUploadPorXpath();
		esperarSegundos(2);
		if (salvar(operacao)) {
			clicarBotaoVoltar();
			//escolhePrimeiroItem();
			clicarBotaoUpload();
			atualizaArquivo(operacao);
			clicarSelecionarArquivo();

			FazerUpload fazerUpload = new FazerUpload(
					ConstantesTestes.PATH_ARQUIVO_ENVIAR_EXTRATO);
			fazerUpload.upload();

			selecionarTipoUpload("2");
			selecionarVersao();
			preencherSenha();
			clicarEnviarArquivo();
			esperarSegundos(2);
			fecharTelaRecibos();

			if (verificaSucesso()) {
				Assert.fail("Ocorreu um erro ao enviar posição. Verifique o arquivo.");
			}
		} else {
			Assert.fail("Ocorreu um erro ao salvar posição. Verifique o arquivo.");
		}
	}

	private void clicarBotaoUpload() {
		clicarItemPorId("upload");
	}

	private void escolhePrimeiroItem() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[4]/table[1]/tbody/tr/td[1]/div[2]/div[2]/table/tbody/tr[2]/td[1]/input");
	}

	private void atualizaArquivo(Operacao operacao) {
		if (Operacao.REENVIO_INFORMES == operacao) {
			atualizarArquivoReenviar();
		} else {
			atualizarArquivoEnviar();
		}
	}

	private void acessarMenuDeEnvio() {
		TelaHome telaHome = new TelaHome(usuario);
		telaHome.acessarSubMenu(SubMenu.ENVIA_EXTRATO);
	}

	private void atualizarArquivoReenviar() {
		final String pathArquivo = ConfiguracaoSistema.getPathArquivo(
				ConstantesTestes.PATH_ARQUIVO_ENVIAR_EXTRATO, false);
		ArquivoUtils.alterarTagXML(pathArquivo, "<sch:CdSTI>", codigoSTI);

		ArquivoUtils.alterarTagXML(pathArquivo, "<sch:CdSTICotista>",
				codSTICotista);

		ArquivoUtils.alterarTagXML(pathArquivo, "<sch:DtBase>",
				DataUtils.getDataBaseXML(dataBase));

		// Alterar id para reenvio e colocar justificativa
	}

	private void atualizarArquivoEnviar() {
		final String pathArquivo = ConfiguracaoSistema.getPathArquivo(
				ConstantesTestes.PATH_ARQUIVO_ENVIAR_EXTRATO, false);
		ArquivoUtils.alterarTagXML(pathArquivo, "<sch:CdSTI>", codigoSTI);

		ArquivoUtils.alterarTagXML(pathArquivo, "<sch:CdSTICotista>",
				codSTICotista);

		ArquivoUtils.alterarTagXML(pathArquivo, "<sch:DtBase>",
				DataUtils.getDataBaseXML(dataBase));
	}

	private void fecharTelaRecibos() {
		FecharTelaDeRecibo fecharTelaDeRecibo = new FecharTelaDeRecibo();
		fecharTelaDeRecibo.fechar();
	}

	private void clicarEnviarArquivo() {
		clicarItemPorId("enviar");
	}

	private void selecionarTipoUpload(String tipo) {
		preencherCampoSelectByXPath(
				tipo,
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/select");
	}

	private void clicarSelecionarArquivo() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/input");
	}

	private void selecionarVersao() {
		preencherCampoSelectByXPath(
				"2.1",
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td[2]/select");
	}

	private void preencherSenha() {
		removerCampoReadOnlyPorXPath(getXPathSenha());
		preencheCampoXPath(getXPathSenha(), usuario.getSenha());
	}

	private String getXPathSenha() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[4]/td[2]/input";
	}

	@Override
	public void clicarBotaoVoltar() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[3]/td/input[2]");
	}

}
