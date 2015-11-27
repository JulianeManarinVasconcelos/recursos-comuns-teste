package br.com.galgo.testes.recursos_comuns.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.utils.TesteUtils;

public class TesteLoginAthena extends Teste {

	@Before
	public void setUp() throws Exception {
		// configurar();
	}

	@Test
	public void exemploTesteLoginValidoAluno() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteLoginValidoAluno.png");
		TelaPrincipal.abrirBrowser("http://localhost:8080/athena/");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorXPath("/html/body/div[1]/div/nav/div/div[2]/ul/li[4]/a");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[1]", "8061535");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[2]", "123");
		tela.clicarItemPorXPath("/html/body/div[2]/div/div/form/input[3]");

		Assert.assertTrue(tela.verificaTextoNaTela("Logout"));

	}

	@Test
	public void exemploTesteLoginInvalidoAluno() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteLoginValidoAluno.png");
		TelaPrincipal.abrirBrowser("http://localhost:8080/athena/");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorXPath("/html/body/div[1]/div/nav/div/div[2]/ul/li[4]/a");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[1]", "8061535");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[2]", "juju");
		tela.clicarItemPorXPath("/html/body/div[2]/div/div/form/input[3]");

		Assert.assertTrue(tela.verificaTextoNaTela("Usuário ou senha inválidos... =/"));
	}
	
	@Test
	public void exemploTesteLoginValidoProfessor() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteLoginValidoAluno.png");
		TelaPrincipal.abrirBrowser("http://localhost:8080/athena/");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorXPath("/html/body/div[1]/div/nav/div/div[2]/ul/li[4]/a");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[1]", "8061555");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[2]", "123");
		tela.clicarItemPorXPath("/html/body/div[2]/div/div/form/input[3]");

		Assert.assertTrue(tela.verificaTextoNaTela("Chaim"));

	}

	@Test
	public void exemploTesteLoginInvalidoProfessor() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteLoginValidoAluno.png");
		TelaPrincipal.abrirBrowser("http://localhost:8080/athena/");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorXPath("/html/body/div[1]/div/nav/div/div[2]/ul/li[4]/a");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[1]", "8061555");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[2]", "juju");
		tela.clicarItemPorXPath("/html/body/div[2]/div/div/form/input[3]");

		Assert.assertTrue(tela.verificaTextoNaTela("Usuário ou senha inválidos... =/"));
	}

	@After
	public void tearDown() {
		TesteUtils.finalizarTeste(this.getNomeTeste());
	}

}
