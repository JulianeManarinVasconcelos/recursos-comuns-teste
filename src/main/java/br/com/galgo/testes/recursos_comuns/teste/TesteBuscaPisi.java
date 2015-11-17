package br.com.galgo.testes.recursos_comuns.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.utils.TesteUtils;

public class TesteBuscaPisi extends Teste {

	@Before
	public void setUp() throws Exception {
		// configurar();
	}

	@Test
	public void exemploTesteBusca() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteCadastroCliente.png");
		TelaPrincipal.abrirBrowser("http://pisi-project.herokuapp.com/");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorId("advanced_search_btn");
		tela.clicarItemPorId("worker_class");
		tela.clicarItemPorXPath("//*[@id=\"worker_class\"]/option[2]");
		tela.clicarItemPorId("worker_name");

		Assert.assertTrue(tela.verificaTextoNaTela("Logout"));

	}

	@After
	public void tearDown() {
		TesteUtils.finalizarTeste(this.getNomeTeste());
	}

}
