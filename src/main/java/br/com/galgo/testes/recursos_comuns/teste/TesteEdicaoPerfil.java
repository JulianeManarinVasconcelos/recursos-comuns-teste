package br.com.galgo.testes.recursos_comuns.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.utils.TesteUtils;

public class TesteEdicaoPerfil extends Teste {

	@Before
	public void setUp() throws Exception {
		// configurar();
	}

	@Test
	public void exemploTesteEdicaoPerfil() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteEdicaoPerfil.png");
		TelaPrincipal.abrirBrowser("http://pisi-project.herokuapp.com/signOut");
		TelaPrincipal tela = new TelaPrincipal();
		tela.clicarItemPorXPath("/html/body/div/section[1]/header/div/nav[2]/a");
		tela.preencheCampoXPath("/html/body/div[2]/div/form/input[1]", "mario@hotmail.com");
		tela.preencheCampoXPath("/html/body/div[2]/div/form/input[2]", "mario");
		tela.clicarItemPorXPath("/html/body/div[2]/div/form/button");
		Assert.assertTrue(tela.verificaTextoNaTela("Encanador"));
		tela.clicarItemPorXPath("/html/body/div/section/header/div/nav[1]/a");
		tela.preencheCampoPorId("workername", "Rosa" + Math.random());
		tela.clicarItemPorXPath("/html/body/div/section[1]/header/div/nav/a");

	}

	@After
	public void tearDown() {
		TesteUtils.finalizarTeste(this.getNomeTeste());
	}

}
