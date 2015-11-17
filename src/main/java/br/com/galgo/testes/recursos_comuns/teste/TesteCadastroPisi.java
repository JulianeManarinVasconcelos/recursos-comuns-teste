package br.com.galgo.testes.recursos_comuns.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.utils.TesteUtils;

@Ignore
public class TesteCadastroPisi extends Teste {

	@Before
	public void setUp() throws Exception {
		// configurar();
	}

	@Test
	public void exemploTesteCadastroCliente() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteCadastroCliente.png");
		TelaPrincipal.abrirBrowser("http://pisi-project.herokuapp.com/signOut");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorXPath("/html/body/div/section[1]/header/div/nav[1]/a");
		tela.preencheCampoPorId("username", "Juliane" + Math.random());
		tela.preencheCampoPorId("useremail", "juliane" + Math.random() + "@gmail.com");
		tela.preencheCampoPorId("passwordInput", "juliane");
		tela.preencheCampoPorId("passwordInputConfirmation", "juliane");
		tela.clicarItemPorId("submituser");
	}

	@Test
	public void exemploTesteCadastroProfissional() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteCadastroProfissional.png");
		TelaPrincipal.abrirBrowser("http://pisi-project.herokuapp.com/signOut");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorXPath("/html/body/div/section[1]/header/div/nav[1]/a");
		tela.preencheCampoPorId("username", "Juliane" + Math.random());
		tela.preencheCampoPorId("useremail", "juliane" + Math.random() + "@gmail.com");
		tela.preencheCampoPorId("passwordInput", "juliane");
		tela.preencheCampoPorId("passwordInputConfirmation", "juliane");
		tela.clicarItemPorId("isworker-0");
		tela.clicarItemPorId("submituser");
		tela.preencheCampoPorId("workername", "Juliane" + Math.random());
		tela.preencheCampoPorId("workeremail", "juliane" + Math.random() + "@gmail.com");
		tela.preencheCampoPorId("workerphone", "999999999");
		tela.preencherCampoSelectById("Eletricista", "workerclass");
		tela.preencheCampoPorId("workerexperience", "Encandaor de apartamento.");
		tela.preencheCampoPorId("workerprice", "A partir de R$100,00");
		tela.clicarItemPorId("submitworker");
	}

	@After
	public void tearDown() {
		TesteUtils.finalizarTeste(this.getNomeTeste());
	}

}
