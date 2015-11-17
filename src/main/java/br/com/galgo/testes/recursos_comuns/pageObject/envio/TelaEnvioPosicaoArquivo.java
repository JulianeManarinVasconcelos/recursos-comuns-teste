package br.com.galgo.testes.recursos_comuns.pageObject.envio;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.config.ConfiguracaoSistema;
import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.file.ArquivoUtils;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.thread.FazerDownload;
import br.com.galgo.testes.recursos_comuns.thread.FazerUpload;
import br.com.galgo.testes.recursos_comuns.thread.FecharTelaDeRecibo;
import br.com.galgo.testes.recursos_comuns.utils.ConstantesTestes;
import br.com.galgo.testes.recursos_comuns.utils.DataUtils;

public class TelaEnvioPosicaoArquivo extends TelaPrincipal implements TelaEnvio {

	private Usuario usuario;
	private String dataBase;
	private String codigoSTI;

	public TelaEnvioPosicaoArquivo() {

	}

	public TelaEnvioPosicaoArquivo(Usuario usuario, String dataBase,
			String codigoSTI) {
		this.usuario = usuario;
		this.codigoSTI = codigoSTI;
		this.dataBase = dataBase;
	}

	public boolean salvar(Operacao operacao) {
		return salvar(operacao, false);
	}

	public boolean salvar(Operacao operacao, boolean ehSegundaTentativa) {
		ArquivoUtils.atualizarArquivoSalvarPosicao(
				ConstantesTestes.PATH_ARQUIVO_SALVAR_POSICAO, dataBase,
				codigoSTI, operacao);

		selecionarTipoUpload("1", operacao);
		clicarSelecionarArquivo(operacao);
		esperarSegundos(4);

		FazerUpload fazerUpload = new FazerUpload(
				ConstantesTestes.PATH_ARQUIVO_SALVAR_POSICAO);
		fazerUpload.upload();

		esperarSegundos(4);
		selecionarVersao();
		preencherSenha(operacao);
		clicarEnviarArquivo(operacao, ehSegundaTentativa);
		esperarSegundos(4);
		FecharTelaDeRecibo fecharTelaDeRecibo = new FecharTelaDeRecibo();
		fecharTelaDeRecibo.fechar();

		if (verificaSucesso()) {
			Assert.fail("Ocorreu um erro ao enviar pl/cota. Verifique o arquivo.");
			return false;
		}
		return true;

	}

	private String fazerDownloadRecibo(String path) {
		FazerDownload fazerDownload = new FazerDownload(path);
		fazerDownload.download();
		return fazerDownload.getPathArquivo();
	}

	private boolean verificaSucesso() {
		return verificaTextoNaTela("Ocorreu um erro no sistema. ")
				|| verificaTextoNaTela("O leiaute informado é inválido.");
	}

	public void enviar() {
		enviar(Operacao.ENVIO_INFORMES);
	}

	public void enviar(Operacao operacao) {
		enviar(operacao, false);
	}

	public void enviar(Operacao operacao, boolean ehSegundaTentativa) {
		if (salvar(operacao, ehSegundaTentativa)) {
			final String pathArquivo = ConfiguracaoSistema.getPathArquivo(
					ConstantesTestes.PATH_ARQUIVO_ENVIAR_POSICAO, false);

			ArquivoUtils.alterarTagXML(pathArquivo, "<sch:CdSTI>", codigoSTI);
			ArquivoUtils.alterarTagXML(pathArquivo, "<sch:DtBase>",
					DataUtils.getDataBaseXML(dataBase));

			selecionarTipoUpload("2", operacao);
			clicarSelecionarArquivo(operacao);

			FazerUpload fazerUpload = new FazerUpload(
					ConstantesTestes.PATH_ARQUIVO_ENVIAR_POSICAO);
			fazerUpload.upload();

			selecionarVersao();
			preencherSenha(operacao);
			clicarEnviarArquivo(operacao, ehSegundaTentativa);
			esperarSegundos(4);
			String path = fazerDownloadRecibo(ConstantesTestes.PATH_RECIBO_ENVIAR_POSICAO);
			validaSucesso();
			validaReenvio(path);
		} else {
			Assert.fail("Ocorreu um erro ao salvar posição. Verifique o arquivo.");
		}
	}

	private void validaSucesso() {
		if (verificaSucesso()) {
			Assert.fail("Ocorreu um erro ao enviar posição. Verifique o arquivo.");
		}
	}

	private void validaReenvio(String path) {
		if (ArquivoUtils.verificaEhReenvio(path)) {
			System.out.println("entrou como reenvio");
			clicarSegundoBotao();
			enviar(Operacao.REENVIO_INFORMES, true);
		}
	}

	private void clicarSegundoBotao() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[6]/td[2]/input[2]");
		} catch (Exception ex) {
			clicarItemPorId("enviar");
		}
	}

	private void clicarEnviarArquivo(Operacao operacao,
			boolean ehSegundaTentativa) {
		if (ehSegundaTentativa) {
			clicarConfirmarEnvio();
		} else if (Operacao.CANCELA_INFORMES == operacao) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[3]/td/input[3]");
		} else if (Operacao.REENVIO_INFORMES == operacao) {
			clicarSegundoBotao();
		} else {
			clicarConfirmarEnvio();
		}

	}

	private void clicarConfirmarEnvio() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[6]/td[2]/input[3]");
		} catch (Exception e) {
			clicarSegundoBotao();
		}
	}

	private void selecionarTipoUpload(String tipo, Operacao operacao) {
		if (Operacao.CANCELA_INFORMES == operacao) {
			preencherCampoSelectByXPath(
					"5.0",
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/select");
		} else {
			preencherCampoSelectByXPath(
					tipo,
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td[2]/select");
		}
	}

	private void clicarSelecionarArquivo(Operacao operacao) {
		if (Operacao.CANCELA_INFORMES == operacao) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/input");
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[2]/td[2]/input");
		}

	}

	private void selecionarVersao() {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[3]/td[2]/select")) {
			preencherCampoSelectByXPath(
					"5.0",
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[3]/td[2]/select");
		}
	}

	private void preencherSenha(Operacao operacao) {
		if (Operacao.CANCELA_INFORMES == operacao) {
			removerCampoReadOnlyPorXPath(getSenhaCancelar());
			preencheCampoXPath(getSenhaCancelar(), usuario.getSenha());
		} else {
			removerCampoReadOnlyPorXPath(getXPathSenha());
			preencheCampoXPath(getXPathSenha(), usuario.getSenha());
		}
	}

	private String getSenhaCancelar() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td[2]/input";
	}

	private String getXPathSenha() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[4]/td[2]/input";
	}

	@Override
	public void clicarBotaoVoltar() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[6]/td[2]/input[1]");
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[3]/td/input[2]");
		}
	}
}
