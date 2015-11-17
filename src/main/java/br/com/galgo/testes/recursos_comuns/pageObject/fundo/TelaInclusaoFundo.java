package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.upload.TelaUploadFundo;

public class TelaInclusaoFundo extends TelaPrincipal {

	public TelaIdentificacaoFundo clicarBotaoIncluirFundo() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[5]/table/tbody/tr[2]/td/input[1]");
		return new TelaIdentificacaoFundo();
	}

	public TelaUploadFundo clicarBotaoUpload() {
		esperarSegundos(3);
		clicarItemPorName(getNameBotaoUpload());
		return new TelaUploadFundo();
	}

	public void validaInclusaoSucesso() {
		try {
			verificaTextoNaTela("Em Elaboração");
		} catch (Exception e) {
			Assert.fail("Erro ao cadastrar o fundo");
		}
	}

	private String getNameBotaoUpload() {
		return "btnAnexarDocumento";
	}

}
