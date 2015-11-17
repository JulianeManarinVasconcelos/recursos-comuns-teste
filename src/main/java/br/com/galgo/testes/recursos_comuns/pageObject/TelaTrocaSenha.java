package br.com.galgo.testes.recursos_comuns.pageObject;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.exception.MensagemErro;
import br.com.galgo.testes.recursos_comuns.file.ArquivoUtils;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;

public class TelaTrocaSenha extends TelaPrincipal {

	public boolean trocarSenha(Usuario usuario) {
		removerCampoReadOnlyPorXPath(getXPathCampoSenhaAtual());
		final String senha = usuario.getSenha();
		preencheCampoXPath(getXPathCampoSenhaAtual(), senha);

		String novaSenha = geraNovaSenha(senha);

		removerCampoReadOnlyPorXPath(getXPathCampoNovaSenha());
		preencheCampoXPath(getXPathCampoNovaSenha(), novaSenha);

		removerCampoReadOnlyPorXPath(getXPathCampoConfirmacaoSenha());
		preencheCampoXPath(getXPathCampoConfirmacaoSenha(), novaSenha);

		clicarItemPorXPath(getXPathCampoConfirmacaoSenha());
		clicarItemPorClassName(getClassNameTeclaEnter());

		try {
			return ArquivoUtils.trocaSenha(usuario, novaSenha);
		} catch (Exception e) {
			Assert.fail(MensagemErro.EXCEL_ERRO);
		}
		return false;
	}

	public boolean estaNaTeladeTrocaDeSenha() {
		return verificaCampoVisivelPorXPath(getXPathCampoSenhaAtual());
	}

	private String geraNovaSenha(String senha) {
		
		String senhaAlfanumerica = "";
		Integer senhaNumerica = 0;

		try {
			senhaNumerica = Integer
					.valueOf(senha.substring(senha.length() - 3)) + 111;
			senhaAlfanumerica = senha.substring(0, senha.length() - 3);
		} catch (Exception e) {
			senhaNumerica = (int) (100 + Math.random() * 899);
			senhaAlfanumerica = "Galgo";
		}

		return senhaAlfanumerica + senhaNumerica;
	}

	private String getXPathCampoSenhaAtual() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[2]/tbody/tr[1]/td[2]/input";
	}

	private String getXPathCampoNovaSenha() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[2]/tbody/tr[2]/td[2]/input";
	}

	private String getXPathCampoConfirmacaoSenha() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[2]/tbody/tr[3]/td[2]/input";
	}

	private String getClassNameTeclaEnter() {
		return "enter";
	}

}
