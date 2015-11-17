package br.com.galgo.testes.recursos_comuns.pageObject.envio;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.config.ConfiguracaoSistema;
import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.file.ArquivoUtils;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.thread.FazerUpload;
import br.com.galgo.testes.recursos_comuns.thread.FecharTelaDeRecibo;
import br.com.galgo.testes.recursos_comuns.utils.DataUtils;

public class TelaEnvioPlCotaArquivo extends TelaPrincipal implements TelaEnvio {

	private Usuario usuario;
	private String caminhoArquivo;
	private String codSTI;
	private String dataBase;
	private Operacao operacao;

	public TelaEnvioPlCotaArquivo() {

	}

	public TelaEnvioPlCotaArquivo(Usuario usuario, String caminhoArquivo,
			String codSTI, String dataBase, Operacao operacao) {
		this.usuario = usuario;
		this.caminhoArquivo = caminhoArquivo;
		this.codSTI = codSTI;
		this.dataBase = dataBase;
		this.operacao = operacao;
	}

	public void enviar() {
		atualizaArquivo();

		clicarBotaoUploadArquivo();
		clicarSelecionarArquivo();

		FazerUpload fazerUpload = new FazerUpload(caminhoArquivo);
		fazerUpload.upload();

		preencheSenha();
		clicarEnviarArquivo();
		fecharTelaRecibos();

		if (verificaSucesso()) {
			Assert.fail("Ocorreu um erro ao enviar pl/cota. Verifique o arquivo.");
		}
	}

	private void clicarSelecionarArquivo() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/input");
	}

	private String atualizaArquivo() {
		final String pathArquivo = ConfiguracaoSistema.getPathArquivo(
				caminhoArquivo, false);

		Map<String, String> listaTags = new HashMap<String, String>();
		listaTags.put("<NAVDtTm>", DataUtils.getDataBaseXML(dataBase));
		listaTags.put("<OthrPrtryId>", codSTI);
		String valor = "";
		if (Operacao.ENVIO_INFORMES == operacao) {
			valor = TelaEnvio.VALOR_ENVIO;
		} else {
			valor = TelaEnvio.VALOR_REENVIO;
		}
		listaTags.put("<NAV>", valor);

		for (String tag : listaTags.keySet()) {
			ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, tag,
					listaTags.get(tag));
		}
		return pathArquivo;
	}

	private boolean verificaSucesso() {
		return verificaTextoNaTela("Ocorreu um erro no sistema. ")
				|| verificaTextoNaTela("O leiaute informado é inválido.");
	}

	private void fecharTelaRecibos() {
		// TODO:verificar se é para salvar arquivo
		FecharTelaDeRecibo fecharTelaDeRecibo = new FecharTelaDeRecibo();
		fecharTelaDeRecibo.fechar();
	}

	private void clicarEnviarArquivo() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[3]/td/input[3]");
	}

	private void preencheSenha() {
		removerCampoReadOnlyPorXPath(getXPathSenha());
		preencheCampoXPath(getXPathSenha(), usuario.getSenha());
	}

	private String getXPathSenha() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td[2]/input";
	}

	private void clicarBotaoUploadArquivo() {
		if (verificaCampoVisivelPorXPath(getXPathBotaoUpload())) {
			clicarItemPorXPath(getXPathBotaoUpload());
		}
	}

	private String getXPathBotaoUpload() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[4]/td/input[3]";
	}

	@Override
	public void clicarBotaoVoltar() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[3]/td/input[2]");
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table/tbody/tr[4]/td/input[1]");
	}

}
