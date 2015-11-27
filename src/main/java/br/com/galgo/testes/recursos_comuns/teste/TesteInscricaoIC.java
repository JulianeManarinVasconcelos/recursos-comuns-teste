package br.com.galgo.testes.recursos_comuns.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.utils.TesteUtils;

public class TesteInscricaoIC extends Teste {

	@Before
	public void setUp() throws Exception {
		// configurar();
	}

	@Test
	public void exemploTesteInscricaoIC() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteEdicaoPerfil.png");
		TelaPrincipal.abrirBrowser("http://localhost:8080/athena/");
		TelaPrincipal tela = new TelaPrincipal();
		
	}

	@After
	public void tearDown() {
		TesteUtils.finalizarTeste(this.getNomeTeste());
	}

}
