package br.com.galgo.testes.recursos_comuns.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.utils.TesteUtils;

public class TesteCadastroAthena extends Teste {

	@Before
	public void setUp() throws Exception {
		// configurar();
	}

	@Test
	public void exemploTesteCadastroAluno() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteCadastroAluno.png");
		TelaPrincipal.abrirBrowser("http://localhost:8080/athena/");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorXPath("/html/body/div[1]/div/nav/div/div[2]/ul/li[3]/a");
		tela.clicarItemPorXPath("/html/body/div[2]/div/div/a[2]");

		tela.esperarSegundos(5);
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[2]/form/input[2]", "8061540"+(int) Math.random());
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[2]/form/input[3]", "juliane" + Math.random());
		tela.preencherCampoSelectByXPath("F", "/html/body/div[2]/div/div/div[2]/form/select");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[2]/form/input[4]", "juliane@gmail.com");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[2]/form/input[5]", "08/05/1993");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[2]/form/input[6]", "22222222");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[2]/form/input[7]", "999999999");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[2]/form/input[8]", "www.lates.com.br/juliane");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[2]/form/input[9]", "123");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[2]/form/input[10]", "SI");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[2]/form/input[11]", "01/12/2017");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[2]/form/textarea", "IA");

		tela.clicarItemPorXPath("/html/body/div[2]/div/div/div[2]/form/input[12]");

	}

	@Test
	public void exemploTesteCadastroProfessor() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteCadastroProfessor.png");
		TelaPrincipal.abrirBrowser("http://localhost:8080/athena/");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorXPath("/html/body/div[1]/div/nav/div/div[2]/ul/li[3]/a");
		tela.esperarSegundos(5);
		tela.clicarItemPorXPath("/html/body/div[2]/div/div/a[1]");

		tela.esperarSegundos(5);
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[1]/form/input[2]", "8061590"+(int) Math.random());
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[1]/form/input[3]", "chaim" + Math.random());
		tela.preencherCampoSelectByXPath("M", "/html/body/div[2]/div/div/div[1]/form/select");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[1]/form/input[4]", "chaim@gmail.com");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[1]/form/input[5]", "08/05/1993");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[1]/form/input[6]", "22222222");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[1]/form/input[7]", "999999999");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[1]/form/input[8]", "www.lates.com.br/chaim");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[1]/form/input[9]", "123");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[1]/form/input[10]", "SI");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/div[1]/form/input[11]", "IA");

		tela.clicarItemPorXPath("/html/body/div[2]/div/div/div[1]/form/input[12]");

		Assert.assertTrue(tela.verificaTextoNaTela("Usuário Adicionado com sucesso!"));
	}

	@Test
	public void exemploTesteCadastroIC() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteCadastroIC.png");

		TelaPrincipal.abrirBrowser("http://localhost:8080/athena/");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorXPath("/html/body/div[1]/div/nav/div/div[2]/ul/li[4]/a");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[1]", "8061555");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[2]", "123");
		tela.clicarItemPorXPath("/html/body/div[2]/div/div/form/input[3]");

		tela.esperarSegundos(5);
		tela.clicarItemPorXPath("/html/body/div[1]/div/nav/div/div[2]/ul/li[3]/a");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[1]", "IC teste" );
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[2]", "IC teste");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[3]", "2 anos");
		tela.preencheCampoXPath("/html/body/div[2]/div/div/form/input[4]", "SI");
		tela.clicarItemPorXPath("/html/body/div[2]/div/div/form/input[5]");
	}

	@After
	public void tearDown() {
		TesteUtils.finalizarTeste(this.getNomeTeste());
	}

}
