package br.com.galgo.testes.recursos_comuns.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.utils.TesteUtils;

@Ignore
public class TesteLoginPisi extends Teste {

	@Before
	public void setUp() throws Exception {
		// configurar();
	}

	@Test
	public void exemploTesteLoginValido() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteLoginValido.png");
		TelaPrincipal.abrirBrowser("http://pisi-project.herokuapp.com/signOut");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorXPath("/html/body/div/section[1]/header/div/nav[2]/a");
		tela.preencheCampoXPath("/html/body/div[2]/div/form/input[1]", "mario@hotmail.com");
		tela.preencheCampoXPath("/html/body/div[2]/div/form/input[2]", "mario");
		tela.clicarItemPorXPath("/html/body/div[2]/div/form/button");

		Assert.assertTrue(tela.verificaTextoNaTela("Encanador"));

	}

	@Test
	public void exemploTesteLoginInvalido() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteLoginInvalido.png");
		TelaPrincipal.abrirBrowser("http://pisi-project.herokuapp.com/signOut");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorXPath("/html/body/div/section[1]/header/div/nav[2]/a");
		tela.preencheCampoXPath("/html/body/div[2]/div/form/input[1]", "mario@hotmail.com");
		tela.preencheCampoXPath("/html/body/div[2]/div/form/input[2]", "123");
		tela.clicarItemPorXPath("/html/body/div[2]/div/form/button");

		Assert.assertTrue(tela.verificaTextoNaTela("E-mail ou senha incorretos"));
	}

	@After
	public void tearDown() {
		TesteUtils.finalizarTeste(this.getNomeTeste());
	}

}
