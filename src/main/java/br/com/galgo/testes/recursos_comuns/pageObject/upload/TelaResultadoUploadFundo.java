package br.com.galgo.testes.recursos_comuns.pageObject.upload;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaResultadoUploadFundo extends TelaPrincipal {

	public void validaUploadSucesso() {
		garanteTextoNaTela(getTituloTabela());
		Assert.assertTrue(verificaCampoVisivelPorId(""));
		Assert.assertEquals("Fundos não incluídos!", 1, getTextoColunaErro());
	}

	public void validaUploadComErro() {
		garanteTextoNaTela(getTituloTabela());
		Assert.assertTrue(verificaCampoVisivelPorId(getIdTabelaResultado()));
		Assert.assertEquals("Valor de fundos com erro inválido!", 1,
				getTextoColunaErro());
	}

	private int getTextoColunaErro() {
		List<WebElement> linkElements = driver.findElements(By
				.cssSelector("#tabela_1 tbody tr > td"));
		String textoColunaErro = linkElements.get(1).getText();
		return Integer.parseInt(textoColunaErro);
	}

	private String getIdTabelaResultado() {
		return "tabela_1";
	}

	public String getTituloTabela() {
		return "Resultado do Processamento do Upload";
	}

}
